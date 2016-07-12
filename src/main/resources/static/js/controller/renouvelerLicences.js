/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('renouvelerLicences', ['$scope','$location',
                                                        '$routeParams','Licences','LicencesOwner',
    function($scope,$location,$routeParams,Licences,LicencesOwner){

        //init var
        $scope.error = false;

        var id = $routeParams.id;
        $scope.licence = LicencesOwner.get({id:id},function(data){
        });

        $scope.valModifier = function () {
            var now = new Date();
            if ($scope.newDate > now) {
                // selected date is in the future

            var month = $scope.newDate.getMonth()+1;
            if(month<10){
                month = '0'+month;
            }
            var day = $scope.newDate.getDate();
            if(day<10){
                day = '0'+day;
            }
            $scope.licence.dateExpiration = $scope.newDate.getFullYear()+"-"+day+"-"+month;
            $scope.licence.$update(function() {
                $location.path("/licences");
            });
            }else{
                $scope.error = true;
            }
        }

    }
]);
