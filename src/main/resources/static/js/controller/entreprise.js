// Contrôleur de la page licences
TicketCertificatApp.controller('entreprise', ['$scope','$location','$routeParams','Company',
    function($scope,$location,$routeParams,Company){

		//init var
		$scope.entreprises = Company.query();
		$scope.couldDelete = false;
		$scope.companyToDelete = [];


		$scope.addToDelete = function(u){

			if(companyToDelete==null || !companyToDelete.contains(u)) {
				$scope.companyToDelete.push(u);
			}else{
				$scope.companyToDelete.filter(removeToDelete,u);
				console.log($scope.companyToDelete);
			}
		}

		function removeToDelete(element,element2) {
			console.log(element2);
			return element != element2;
		}

		$scope.delete = function(){
			console.log("delete : ");
			console.log($scope.companyToDelete);
			for(var u in $scope.companyToDelete) {
				console.log("delete : "+$scope.companyToDelete[u]);
				$scope.companyToDelete[u].$delete();
			}
			$route.reload();
		}


		$scope.modifier = function(e){
			$location.path("/entreprise/modifier/"+e.id);
		}


		$scope.activeAdd = function(){
			$location.path("/entreprise/ajouter");

		}
	}]);