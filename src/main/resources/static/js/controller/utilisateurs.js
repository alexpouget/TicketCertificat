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

            $scope.userToDelete.push(u);
        }

        $scope.delete = function(){
            console.log("delete : ");
            console.log($scope.userToDelete);
            for(var u in $scope.userToDelete) {
                console.log("delete : "+$scope.userToDelete[u]);
                $scope.userToDelete[u].$delete();
            }
            $route.reload();
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
