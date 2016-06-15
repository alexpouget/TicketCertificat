/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('ajouterLicenses', ['$scope','$location','Company','Computer','Software','Typelicenses',
                                'LicencesOwner','Licences',
    function($scope,$location,Company,Computer,Software,Typelicenses,LicencesOwner,Licences){


        $scope.companys = Company.query();
        $scope.computers = Computer.query();
        $scope.softwares = Software.query();
        $scope.types = Typelicenses.query();
        $scope.result = null;

        function find(softwareSelected, typeSelected) {
            $scope.result = null;
            $scope.licences = Licences.query(function(data){
                console.log("merdier");
                console.log(JSON.stringify(data));
                for(var d in data) {
                    console.log("merde");
                    console.log(JSON.stringify(data[d]));
                    if(data[d].software != null &&  data[d].software.name==softwareSelected.name){
                        console.log("passe1");
                        if(data[d].typeLicense.type==typeSelected.type){
                            console.log("passe2");
                            $scope.result = data[d];
                            console.log($scope.result);
                        }
                    }
                }
            });
        }

        function create(softwareSelected, typeSelected) {
            console.log("create");
            var l = new Licences();
            l.software = softwareSelected;
            l.typeLicense = typeSelected;
            l.$save(function (data) {
                $scope.result = data;
            });
            return $scope.result;
        }

        $scope.add = function(){
            var l = new LicencesOwner();
            l.dateDebut = new Date().toLocaleString();
            l.dateExpiration = $scope.newDate;
            l.company = $scope.companySelected;
            l.computer = $scope.computerSelected;
            find($scope.softwareSelected,$scope.typeSelected);
            if($scope.result==null){
                create($scope.softwareSelected,$scope.typeSelected);
            }
            l.license = $scope.result;
            console.log("new L");
            console.log(JSON.stringify(l));
            if(l.license!=null) {
                l.$save(function () {
                    $location.path("/licenses");
                });
            }

        }
    }
]);
