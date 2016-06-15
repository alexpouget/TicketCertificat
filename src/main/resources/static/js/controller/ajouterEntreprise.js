/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('ajouterEntreprise', ['$scope','$location','Company',
    function($scope,$location,Company){

        $scope.add = function(){
            var e = new Company();
            e.name = $scope.newName;
            e.adress = $scope.newAdress;
            e.$save(function() {
                $location.path("/entreprise");
            });

        }
    }
]);
