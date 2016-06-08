/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('modifierUtilisateurs', ['$scope','User','$location',
                                                        '$routeParams',
    function($scope,User,$location,$routeParams){

        //init var
        $scope.password = "";
        $scope.uid = "";
        $scope.email = "";
        var uid = $routeParams.uid;
        $scope.user = User.query({uid:uid}, function (data) {
            console.log(data);
            $scope.password = data.password;
            $scope.uid = data.uid;
            $scope.email = data.email;
        });




        $scope.valModifier = function () {
            var u = new User();
            u.id = $scope.user.id;
            u.uid = $scope.uid;
            if($scope.password != "" && $scope.password != $scope.user.password) {
                u.password = $scope.password;
            }else{
                u.password = $scope.user.password;
            }
            u.email = $scope.email;
            u.$update(function() {
                $location.path("/utilisateurs");
            });
        }


    }
]);
