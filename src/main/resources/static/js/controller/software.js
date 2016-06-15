// Contrôleur de la page licences
TicketCertificatApp.controller('software', ['$scope','$location','$routeParams','Software',
    function($scope,$location,$routeParams,Software){

		//init var
		$scope.softwares = Software.query();
		$scope.couldDelete = false;
		$scope.softwareToDelete = [];


		$scope.addToDelete = function(u){

			if($scope.softwareToDelete==null || !$scope.softwareToDelete.contains(u)) {
				$scope.softwareToDelete.push(u);
			}else{
				$scope.softwareToDelete.filter(removeToDelete,u);
				console.log($scope.softwareToDelete);
			}
		}

		function removeToDelete(element,element2) {
			console.log(element2);
			return element != element2;
		}

		$scope.delete = function(){
			console.log("delete : ");
			console.log($scope.softwareToDelete);
			for(var u in $scope.softwareToDelete) {
				console.log("delete : "+$scope.softwareToDelete[u]);
				$scope.softwareToDelete[u].$delete();
			}
			$route.reload();
		}


		$scope.modifier = function(s){
			$location.path("/software/modifier/"+s.id);
		}


		$scope.activeAdd = function(){
			$location.path("/software/ajouter");

		}
	}]);