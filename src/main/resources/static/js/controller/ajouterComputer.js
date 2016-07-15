/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('ajouterComputer', ['$scope','$location','Company','Computer',
    function($scope,$location,Company,Computer){

        $scope.companys = Company.query();

        $scope.add = function(){
            var c = new Computer();
            c.name = $scope.newName;
            c.company = $scope.selected;
            c.$save(function() {
                $location.path("/computer");
            });

        }
    }
]);
