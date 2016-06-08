/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('utilisateurs', ['$scope','User','$location',
    function($scope,User,$location){

        //init var
        $scope.users = User.query();
        $scope.userToDelete = [];


        $scope.addToDelete = function(u){
            window.alert("user to delete" + u.uid +" id "+ u.id);
            $scope.userToDelete.push(u);
        }
        $scope.delete = function(){
            for(var u in $scope.userToDelete) {
                console.log("delete : "+$scope.userToDelete[u]);
                $scope.userToDelete[u].$delete();
            }
        }

        $scope.modifier = function(u){

            $location.path("/utilisateurs/modifier/"+u.uid);
        }

        $scope.activeAdd = function(){
            $location.path("/utilisateurs/ajouter");

        }

    }
]);
