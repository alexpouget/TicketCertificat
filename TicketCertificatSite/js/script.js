'use strict';


/**
 * Déclaration de l'application TicketCertificatApp
 */
var TicketCertificatApp = angular.module('TicketCertificatApp', [
    // Dépendances du "module"
    'ngRoute','ngResource'

]);


/**
 * Configuration du module principal : routeApp
 */
 
TicketCertificatApp.config(['$routeProvider',
    function($routeProvider) { 
        
        // Système de routage
        $routeProvider
		   .when('/accueil', {
				templateUrl: 'views/accueil.html',
				controller: 'homeCtrl'
			})
            .when('/connexion', {
                templateUrl: 'views/connexion.html',
				controller: 'connexion'

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
        });
    }
]);

// Contrôleur de la page d'accueil
TicketCertificatApp.controller('homeCtrl', ['$scope',
    function($scope){
        $scope.message = "Bienvenue sur la page d'accueil";
    }
]);

// Fonction permettant l'échande de données entre deux controlleurs
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
