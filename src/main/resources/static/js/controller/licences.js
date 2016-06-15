// Contrôleur de la page licences
TicketCertificatApp.controller('licences', ['$scope','$routeParams','$location','Licences','LicencesOwner','Company',
    function($scope,$routeParams,$location,Licences,LicencesOwner,Company){

		$scope.idCompany = null;
		$scope.companySelected = "";
		$scope.computer = "";
		$scope.companys = Company.query();
		$scope.licencesFilter = LicencesOwner.query(function(data){});

		$scope.licences = LicencesOwner.query(function(data){
			if($routeParams.id != null){
				$scope.idCompany = $routeParams.id;
				console.log("filtered"+$scope.idCompany);
				$scope.licencesFilter = data;
				console.log(JSON.stringify($scope.licencesFilter));
				$scope.licences = $scope.licencesFilter.filter(filterCompany);
			}
		});

		function filterCompany(element){
			console.log("in filter company");
			console.log(element.company.id == $scope.idCompany);
			return element.company.id == $scope.idCompany;
		}

		function filterComputer(element){
			var str = element.computer.name+"";
			str = str.toLowerCase();
			var str2 = $scope.computer;
			return str.indexOf(str2) == -1 ? false : true;
		}

		$scope.doFilterComputer = function(){
			console.log("filtered computer "+$scope.computer);
			if($scope.companySelected != "" && $scope.companySelected != null){
				console.log("here");
				$scope.idCompany = $scope.companySelected.id;
				$scope.licences = $scope.licencesFilter.filter(filterCompany);
			}else if($scope.idCompany != null){
				$scope.licences = $scope.licencesFilter.filter(filterCompany);
			}
			$scope.l = $scope.licences;
			$scope.licences = $scope.l.filter(filterComputer);
		};

		$scope.doFilterCompany = function(){
			console.log("filtered company "+$scope.companySelected);
			$scope.licencesFilter = $scope.licences;
			if($scope.companySelected == "" || $scope.companySelected == null){
				$scope.licences = LicencesOwner.query(function(data){
						$scope.licences = data.filter(filterComputer);
				});
			}else {
				$scope.idCompany = $scope.companySelected.id;
				$scope.licences = $scope.licencesFilter.filter(filterCompany);
			}
		};

		$scope.activeAdd = function(){
			$location.path("/licences/ajouter");

		}


	}]);