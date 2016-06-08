/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('ajouterUtilisateurs', ['$scope','User','$location',
    function($scope,User,$location){

        $scope.add = function(){
            var u = new User();
            u.uid = $scope.newUid;
            u.password = $scope.newPassword;
            u.email = $scope.newEmail;
            u.$save(function() {
                $location.path("/utilisateurs");
            });

        }
    }
]);
