// Contrôleur de la page licences
TicketCertificatApp.controller('entreprise', ['$scope','$route','$location','$routeParams','Company',
    function($scope,$route,$location,$routeParams,Company){

		//init var
		$scope.entreprises = Company.query();
		$scope.couldDelete = false;
		$scope.companyToDelete = [];

		$scope.addToDelete = function(u){
			var flag = false;
			for (var item in $scope.companyToDelete){
				console.log($scope.companyToDelete[item].uid);
				if ($scope.companyToDelete[item].uid == u.uid){
					$scope.companyToDeletefilter = [];
					for (var i in $scope.companyToDelete){
						if(i!=item){
							$scope.companyToDeletefilter.push($scope.companyToDelete[i]);
						}
					}
					$scope.companyToDelete = $scope.companyToDeletefilter
					flag = true;
				}
			}
			if (flag == false) {
				$scope.companyToDelete.push(u);
			}
		}

		$scope.delete = function(){
			console.log("delete : ");
			console.log($scope.companyToDelete);
			for(var u in $scope.companyToDelete) {
				console.log("delete : "+$scope.companyToDelete[u]);
				$scope.companyToDelete[u].$delete(function () {
					$route.reload();
				});
			}
		}



		$scope.modifier = function(e){
			$location.path("/entreprise/modifier/"+e.id);
		}


		$scope.activeAdd = function(){
			$location.path("/entreprise/ajouter");

		}
	}]);