/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('ajouterSoftware', ['$scope','$location','Software',
    function($scope,$location,Software){

        $scope.add = function(){
            var e = new Software();
            e.name = $scope.newName;
            e.$save(function() {
                $location.path("/software");
            });

        }
    }
]);
