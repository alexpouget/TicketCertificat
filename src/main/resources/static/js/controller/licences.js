// Contrôleur de la page licences
TicketCertificatApp.controller('licences', ['$scope','$routeParams','$location','Licences','LicencesOwner','Company','$rootScope',
    function($scope,$routeParams,$location,Licences,LicencesOwner,Company,$rootScope){

		$scope.idCompany = null;
		$scope.companySelected = "";
		$scope.computer = "";
		$scope.companys = Company.query();
		$scope.licencesFilter = LicencesOwner.query(function(data){});
		$scope.admin = false;
		$scope.comptable = false;
		$scope.user = false;
		$scope.session = $rootScope.user;

		if($scope.session !=null) {
			for (var u in $scope.session.authorities) {
				console.log("role : " + $scope.session.authorities[u].authority);
				if ($scope.session.authorities[u].authority == "admin") {
					$scope.admin = true;
				}
				if ($scope.session.authorities[u].authority == "comptable") {
					$scope.comptable = true;
				}
				if ($scope.session.authorities[u].authority == "user") {
					$scope.user = true;
				}
			}
		}

		$scope.licences = LicencesOwner.query(function(data){
			if($routeParams.id != null){
				$scope.idCompany = $routeParams.id;
				console.log("filtered"+$scope.idCompany);
				$scope.licencesFilter = data;
				console.log(JSON.stringify($scope.licencesFilter));
				$scope.licences = $scope.licencesFilter.filter(filterCompany);
			}
		});

		// ---filter -------------------------------------------------------------------

		function filterCompany(element){
			console.log("in filter company");
			console.log(element.company.id == $scope.idCompany);
			return element.company.id == $scope.idCompany;
		}

		function filterComputer(element){
			var str = element.computer.name+"";
			str = str.toLowerCase();
			var str2 = $scope.computer;
			str2 = str2.toLowerCase();
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

		//-----------------------------------------------------------------------------

		$scope.activeAdd = function(){
			$location.path("/licences/ajouter");

		}

		$scope.renouveler = function(id){
			console.log("renouveler : "+id);
			$location.path("/licences/renouveller/"+id);

		}

		$scope.exportCsv = function(id){
			console.log($scope.licences);

			$scope.fileName = "export"
			var CSV = "";

			CSV += "Type;Date Expiration;Poste;Entreprise;Nom logiciel\r\n"

			for(var index in $scope.licences){
				if($scope.licences[index].id!=undefined) {
					console.log($scope.licences[index]);
					var value = $scope.licences[index].license.typeLicense.type + ";" + $scope.licences[index].dateExpiration + ";" + $scope.licences[index].computer.name + ";" + $scope.licences[index].company.name + ";" + $scope.licences[index].license.software.name;

					CSV += value + "\r\n";
				}
			}

			if(navigator.appName == 'Microsoft Internet Explorer')
			{
				var IEwindow = window.open();

				IEwindow.document.write('sep='+ $scope.separator +'\r\n' + CSV);
				IEwindow.document.close();
				IEwindow.document.execCommand('SaveAs', true, $scope.fileName + ".csv");
				IEwindow.close();
			} else {

				var uri = 'data:application/csv;charset=utf-8,'+ escape(CSV);
				var link = document.createElement("a");
				link.href = uri;
				link.download = $scope.fileName + ".csv";
				document.body.appendChild(link);
				link.click();
				document.body.removeChild(link);
			}

		}


	}]);