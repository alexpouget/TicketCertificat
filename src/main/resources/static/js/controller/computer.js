// Contrôleur de la page licences
TicketCertificatApp.controller('computer', ['$scope','$location','$routeParams','Computer',
    function($scope,$location,$routeParams,Computer){

		//init var
		$scope.computers = Computer.query();
		$scope.couldDelete = false;
		$scope.computerToDelete = [];


		$scope.addToDelete = function(u){
			if($scope.computerToDelete==null || !$scope.computerToDelete.contains(u)) {
				$scope.computerToDelete.push(u);
			}else{
				$scope.computerToDelete.filter(removeToDelete,u);
				console.log($scope.computerToDelete);
			}
		}

		function removeToDelete(element,element2) {
			console.log(element2);
			return element != element2;
		}

		$scope.delete = function(){
			console.log("delete : ");
			console.log($scope.computerToDelete);
			for(var u in $scope.computerToDelete) {
				console.log("delete : "+$scope.computerToDelete[u]);
				$scope.computerToDelete[u].$delete();
			}
			$route.reload();
		}


		$scope.modifier = function(e){
			$location.path("/computer/modifier/"+e.id);
		}


		$scope.activeAdd = function(){
			$location.path("/computer/ajouter");

		}
	}]);