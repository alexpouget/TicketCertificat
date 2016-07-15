// Contrôleur de la page licences
TicketCertificatApp.controller('computer', ['$scope','$route','$location','$routeParams','Computer',
    function($scope,$route,$location,$routeParams,Computer){

		//init var
		$scope.computers = Computer.query();
		$scope.couldDelete = false;
		$scope.computerToDelete = [];


		$scope.addToDelete = function(u){
			var flag = false;
			for (var item in $scope.computerToDelete){
				console.log($scope.computerToDelete[item].uid);
				if ($scope.computerToDelete[item].uid == u.uid){
					$scope.computerToDeletefilter = [];
					for (var i in $scope.computerToDelete){
						if(i!=item){
							$scope.computerToDeletefilter.push($scope.computerToDelete[i]);
						}
					}
					$scope.computerToDelete = $scope.computerToDeletefilter
					flag = true;
				}
			}
			if (flag == false) {
				$scope.computerToDelete.push(u);
			}
		}

		$scope.delete = function(){
			console.log("delete : ");
			console.log($scope.computerToDelete);
			for(var u in $scope.computerToDelete) {
				console.log("delete : "+$scope.computerToDelete[u]);
				$scope.computerToDelete[u].$delete(function () {
					$route.reload();
				});
			}
		}

		$scope.modifier = function(e){
			$location.path("/computer/modifier/"+e.id);
		}


		$scope.activeAdd = function(){
			$location.path("/computer/ajouter");

		}
	}]);