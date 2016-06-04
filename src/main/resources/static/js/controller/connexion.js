// Contrôleur de la page de connexion
angular.module('TicketCertificatApp').controller('connexion',
    function ($scope,$rootScope,$http,$location,User,ConnexionService)
    {


        $scope.login = function(){

            console.log($scope.username);

            if($scope.username!=null && $scope.password!=null){
                var user = {"uid":$scope.username,"password":$scope.password}
                $scope.$emit('event:loginRequest',$scope.username,$scope.password)
            }
        }

	});