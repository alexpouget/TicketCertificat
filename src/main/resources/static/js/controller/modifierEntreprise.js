/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('modifierEntreprise', ['$scope','$location',
                                                        '$routeParams','Company',
    function($scope,$location,$routeParams,Company){

        //init var
        var id = $routeParams.id;
        $scope.company = Company.get({id:id});

        $scope.valModifier = function () {
            $scope.company.$update(function() {
                $location.path("/entreprise");
            });
        }


    }
]);
