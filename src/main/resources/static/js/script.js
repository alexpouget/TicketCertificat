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
            templateUrl: 'views/entreprise.html',
            controller: 'entreprise'
            })
            .when('/entreprise/modifier/:id', {
                templateUrl: 'views/modifierEntreprise.html',
                controller: 'modifierEntreprise'
            })
            .when('/entreprise/ajouter', {
                templateUrl: 'views/ajouterEntreprise.html',
                controller: 'ajouterEntreprise'
            })
            .when('/computer', {
                templateUrl: 'views/computer.html',
                controller: 'computer'
            })
            .when('/computer/modifier/:id', {
                templateUrl: 'views/modifierComputer.html',
                controller: 'modifierComputer'
            })
            .when('/computer/ajouter', {
                templateUrl: 'views/ajouterComputer.html',
                controller: 'ajouterComputer'
            })
            .when('/software', {
                templateUrl: 'views/software.html',
                controller: 'software'
            })
            .when('/software/modifier/:id', {
                templateUrl: 'views/modifierSoftware.html',
                controller: 'modifierSoftware'
            })
            .when('/software/ajouter', {
                templateUrl: 'views/ajouterSoftware.html',
                controller: 'ajouterSoftware'
            })
		    .when('/licences', {
            templateUrl: 'views/licences.html',
			controller: 'licences'
            })
            .when('/licences/ajouter', {
                templateUrl: 'views/ajouterLicences.html',
                controller: 'ajouterLicenses'
            })
            .when('/licences/:id', {
                templateUrl: 'views/licences.html',
                controller: 'licences'
            })
            .when('/licences/renouveller/:id', {
                templateUrl: 'views/Renouvelerlicences.html',
                controller: 'renouvelerLicences'
            })
            .when('/utilisateurs/modifier/:id', {
            templateUrl: 'views/modifierUtilisateur.html',
            controller: 'modifierUtilisateurs'
            })
            .when('/utilisateurs/ajouter', {
                templateUrl: 'views/ajouterUtilisateur.html',
                controller: 'ajouterUtilisateurs'
            })
            .when('/utilisateurs/droit/:id', {
                templateUrl: 'views/droitUtilisateur.html',
                controller: 'droitUtilisateurs'
            })
            .when('/compte/:id', {
                templateUrl: 'views/compte.html',
                controller: 'compte'
            })
            .when('/utilisateurs', {
                templateUrl: 'views/utilisateurs.html',
                controller: 'utilisateurs'
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
TicketCertificatApp.controller('homeCtrl', ['$scope','$rootScope','$location',
    function($scope,$rootScope,$location){
        $scope.admin = false;
        $scope.comptable = false;
        $scope.user = false;
        $scope.session = {};
        console.log("$scope.session");
        console.log($scope.session);

        $rootScope.$on('event:loginConfirmed', function () {
            $scope.session = $rootScope.user;
            for(var u in $scope.session.authorities) {
                console.log("role : "+$scope.session.authorities[u].authority);
                if($scope.session.authorities[u].authority=="admin"){
                    $scope.admin = true;
                }
                if($scope.session.authorities[u].authority=="comptable"){
                    $scope.comptable = true;
                }
                if($scope.session.authorities[u].authority=="user"){
                    $scope.user = true;
                }
            }
        });
        $rootScope.$on('event:logoutRequest', function () {
            $scope.admin = false;
            $scope.comptable = false;
            $scope.user = false;
            $scope.session = {};
        });

        $scope.goLicences = function(){
            $location.path("/licences/"+$scope.session.user.company.id);
        }
        $scope.compte = function(){
            $location.path("/compte/"+$scope.session.user.uid);
        }

    $scope.logout = function(){
        $rootScope.$emit('event:logoutRequest');
    }
    }
]);
