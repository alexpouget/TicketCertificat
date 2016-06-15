/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('modifierComputer', ['$scope','$location',
                                                        '$routeParams','Computer','Company',
    function($scope,$location,$routeParams,Computer,Company){

        //init var
        $scope.companys = Company.query();
        var id = $routeParams.id;
        $scope.computer = Computer.get({id:id},function(data){
            $scope.selected = data.company;
        });

        $scope.valModifier = function () {
            $scope.computer.company = $scope.selected;
            $scope.computer.$update(function() {
                $location.path("/computer");
            });
        }


    }
]);
