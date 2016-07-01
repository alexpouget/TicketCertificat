/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('utilisateurs', ['$scope','User','$location','$route',
    function($scope,User,$location,$route){

        //init var
        $scope.users = User.query();
        $scope.couldDelete = false;
        $scope.userToDelete = [];


        $scope.addToDelete = function(u){
            var flag = false;
            for (var item in $scope.userToDelete){
                console.log($scope.userToDelete[item].uid);
                if ($scope.userToDelete[item].uid == u.uid){
                    $scope.userToDeletefilter = [];
                    for (var i in $scope.userToDelete){
                        if(i!=item){
                            $scope.userToDeletefilter.push($scope.userToDelete[i]);
                        }
                    }
                    $scope.userToDelete = $scope.userToDeletefilter
                    flag = true;
                }
            }
            if (flag == false) {
                $scope.userToDelete.push(u);
            }
        }


        $scope.delete = function(){
            console.log("delete : ");
            console.log(JSON.stringify($scope.userToDelete));
            for(var u in $scope.userToDelete) {
                console.log("delete : "+$scope.userToDelete[u]);
                $scope.userToDelete[u].$delete(function () {
                    console.log("reload");
                    $route.reload();
                });
            }
        }


        $scope.modifier = function(u){
            $location.path("/utilisateurs/modifier/"+u.uid);
        }

        $scope.droit = function(u){
            $location.path("/utilisateurs/droit/"+u.uid);
        }

        $scope.activeAdd = function(){
            $location.path("/utilisateurs/ajouter");

        }

    }
]);
