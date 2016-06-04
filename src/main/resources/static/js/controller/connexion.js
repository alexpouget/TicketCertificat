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

/*
        $scope.authenticate = function(credentials, callback){

            $scope.users = ConnexionService.save($scope.username,$scope.password);
            console.log($scope.users);

             User.get(function(data) {
                 console.log("data ",JSON.stringify(data));
                 console.log("data.name ",JSON.stringify(data.name));
                 if (data.name) {
                     $rootScope.authenticated = true;
                 } else {
                     $rootScope.authenticated = false;
                 }
                 callback && callback();
             });/*.error(function() {
                 console.log("error");
                 $rootScope.authenticated = false;
                 callback && callback();
             });*/
           /*  console.log("end get")
        }

        $scope.logout = function() {
            $http.post('logout', {}).finally(function() {
                $rootScope.authenticated = false;
                $location.path("/");
            });
        }

        $scope.authenticate();
        $scope.credentials = {};
        $scope.login = function() {
            console.log($scope.credentials.username);
            $scope.authenticate($scope.credentials, function() {
                if ($rootScope.authenticated) {
                    console.log("true");
                    $location.path("/");
                    $scope.error = false;
                } else {
                    console.log("false");
                    $location.path("/login");
                    $scope.error = true;
                }
            });
        };*/
	});