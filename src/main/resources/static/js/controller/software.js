// Contrôleur de la page licences
TicketCertificatApp.controller('software', ['$scope','$route','$location','$routeParams','Software',
    function($scope,$route,$location,$routeParams,Software){

		//init var
		$scope.softwares = Software.query();
		$scope.couldDelete = false;
		$scope.softwareToDelete = [];


		$scope.addToDelete = function(u){
			var flag = false;
			for (var item in $scope.softwareToDelete){
				console.log($scope.softwareToDelete[item].uid);
				if ($scope.softwareToDelete[item].uid == u.uid){
					$scope.softwareToDeletefilter = [];
					for (var i in $scope.softwareToDelete){
						if(i!=item){
							$scope.softwareToDeletefilter.push($scope.softwareToDelete[i]);
						}
					}
					$scope.softwareToDelete = $scope.softwareToDeletefilter
					flag = true;
				}
			}
			if (flag == false) {
				$scope.softwareToDelete.push(u);
			}
		}


		$scope.delete = function(){
			console.log("delete : ");
			console.log(JSON.stringify($scope.softwareToDelete));
			for(var u in $scope.softwareToDelete) {
				console.log("delete : "+$scope.softwareToDelete[u]);
				$scope.softwareToDelete[u].$delete(function () {
					$route.reload();
				});
			}
		}


		$scope.modifier = function(s){
			$location.path("/software/modifier/"+s.id);
		}


		$scope.activeAdd = function(){
			$location.path("/software/ajouter");

		}
	}]);