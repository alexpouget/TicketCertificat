/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('modifierUtilisateurs', ['$scope','User','$location',
                                                        '$routeParams','Company',
    function($scope,User,$location,$routeParams,Company){

        //init var
        $scope.password = "";
        $scope.uid = "";
        $scope.email = "";
        $scope.companys = Company.query();
        var uid = $routeParams.id;
        $scope.user = User.get({uid:uid}, function (data) {
            console.log(data);
            $scope.password = data.password;
            $scope.uid = data.uid;
            $scope.email = data.email;
            $scope.selected = data.company;
        });

        $scope.valModifier = function () {
            var u = new User();
            u.id = $scope.user.id;
            u.uid = $scope.uid;
            u.password = $scope.user.password;
            u.email = $scope.email;
            u.company = $scope.selected;
            u.$update(function() {
                $location.path("/utilisateurs");
            });
        }


    }
]);
