/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('modifierSoftware', ['$scope','$location',
                                                        '$routeParams','Software',
    function($scope,$location,$routeParams,Software){

        //init var
        var id = $routeParams.id;
        $scope.software = Software.get({id:id});

        $scope.valModifier = function () {
            $scope.software.$update(function() {
                $location.path("/software");
            });
        }


    }
]);
