'use strict';


/**
 * Déclaration de l'application TicketCertificatApp
 */
var httpHeaders;

var TicketCertificatApp = angular.module('TicketCertificatApp', [
    // Dépendances du "module"
    'ngRoute','ngResource'

]);


/**
 * Configuration du module principal : routeApp
 */
 
TicketCertificatApp.config(['$routeProvider','$httpProvider',
    function($routeProvider,$httpProvider) {
        
        // Système de routage
        $routeProvider

            .when('/connexion', {
                templateUrl: 'views/connexion.html',
				controller: 'connexion'
            })
            .when('/accueil', {
                templateUrl: 'views/accueil.html',
                controller: 'homeCtrl'
            })
		 .when('/entreprise', {
            templateUrl: 'views/entreprise.html'
        })
		 .when('/licences', {
            templateUrl: 'views/licences.html',
			controller: 'licences'
        })
		 .otherwise({
             templateUrl: 'views/accueil.html',
             controller: 'homeCtrl'
        })

        //intercept les requete 401 et lance un evenement loginRequired
        $httpProvider.interceptors.push(function ($rootScope, $q) {

            return {
                'request': function (config) {
                    // console.log('request:' + config);
                    return config || $q.when(config);
                },
                'requestError': function (rejection) {
                    // console.log('requestError:' + rejection);
                    return rejection;
                },
                //success -> don't intercept
                'response': function (response) {
                    // console.log('response:' + response);
                    return  response || $q.when(response);
                },
                //error -> if 401 save the request and broadcast an event
                'responseError': function (response) {
                    console.log('responseError:' + response);
                    if (response.status === 401) {
                        var deferred = $q.defer(),
                            req = {
                                config: response.config,
                                deferred: deferred
                            };
                        $rootScope.requests401.push(req);
                        $rootScope.$broadcast('event:loginRequired');
                        return deferred.promise;
                    }
                    return $q.reject(response);
                }

            };
        });

        httpHeaders = $httpProvider.defaults.headers;

    }]);

TicketCertificatApp.run(function ($rootScope, $http, $route, $location) {

    //stockage des retours 401
    $rootScope.requests401 = [];

    //quand le login est demander rediriger vers login par angular et pas par java serveur
    $rootScope.$on('event:loginRequired', function () {
        //$('#login').modal('show');
        $location.path('/connexion');
    });


     //apres envoi en broadcast de loginConfirmed rechargement de la requete qui a recu un 401.

    $rootScope.$on('event:loginConfirmed', function () {
        var i,
            requests = $rootScope.requests401,
            retry = function (req) {
                $http(req.config).then(function (response) {
                    req.deferred.resolve(response);
                });
            };

        for (i = 0; i < requests.length; i += 1) {
            retry(requests[i]);
        }

        $rootScope.requests401 = [];
        $location.path('/accueil');
    });


    $rootScope.$on('event:loginRequest',function(event, username,password){
        httpHeaders.common['Authorization'] = 'Basic ' + btoa(username+':'+password);
        $http.get('/api/login').success(function (data) {
            $rootScope.authenticated = true;
            $rootScope.user = data;
            console.log(JSON.stringify($rootScope.user));
            $rootScope.$broadcast('event:loginConfirmed')
        }).error(function(data){
            console.log("login failed ");
        });
    });

    $rootScope.$on('event:logoutRequest', function () {
        $http.get('/api/logout').success(function () {
            $rootScope.authenticated = false;
            delete $rootScope.name;
            delete httpHeaders.common['Authorization'];
            $location.path('/connexion');
        }).error(function(){
            console.log("logout failed ");
        });

    });

})


// Contrôleur de la page d'accueil
TicketCertificatApp.controller('homeCtrl', ['$scope','$rootScope',
    function($scope,$rootScope){
        $scope.message = "Bienvenue sur la page d'accueil";
        $scope.session = {id: 'xxx', content : 'user'}



    $scope.logout = function(){
        $rootScope.$broadcast('event:logoutRequest');
    }
    }
]);

// Fonction permettant l'échange de données entre deux controlleurs
TicketCertificatApp.factory('dataShare',function($rootScope){
  var service = {};
  service.data = false;
  service.sendData = function(data){
      this.data = data;
      $rootScope.$broadcast('data_shared');
  };
  service.getData = function(){
    return this.data;
  };
  return service;
});
