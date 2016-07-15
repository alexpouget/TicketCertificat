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


        function create(softwareSelected, typeSelected) {
            console.log("create");

            return $scope.result;
        }

        $scope.add = function(){
            $scope.l = new LicencesOwner();
            var now = new Date();
            $scope.l.dateDebut = now.getFullYear()+"-"+now.getMonth()+"-"+now.getDay();

            $scope.l.dateExpiration = $scope.newDate.getFullYear()+"-"+$scope.newDate.getMonth()+"-"+$scope.newDate.getDay();;
            $scope.l.company = $scope.companySelected;
            $scope.l.computer = $scope.computerSelected;
            Licences.get({id:$scope.softwareSelected.id,type:$scope.typeSelected.id},function(data){
                $scope.result = data;
                console.log(JSON.stringify($scope.result));
                console.log($scope.result.id);
                if($scope.result.id==undefined || $scope.result.id==null){
                    console.log("create");
                    var l = new Licences();
                    l.software = $scope.softwareSelected;
                    l.typeLicense = $scope.typeSelected;
                    l.$save(function (data) {
                        $scope.result = data;
                        $scope.l.license = $scope.result;
                        console.log("new L");
                        console.log(JSON.stringify($scope.l));
                        $scope.l.$save(function () {
                            $location.path("/licenses");
                        });
                    });
                }else{
                    $scope.l.license = $scope.result;
                    console.log("new L");
                    console.log(JSON.stringify($scope.l));
                    $scope.l.$save(function () {
                        $location.path("/licenses");
                    });

                }
            });


        }

        $scope.setCompany = function() {
            $scope.companySelected = $scope.computerSelected.company
        }
        $scope.filterComputer = function() {
            $scope.computersFiltered = [];
            $scope.computers = Computer.query(function(data){
                for (var i in data){
                    if(data[i].company.id == $scope.companySelected.id){
                        $scope.computersFiltered.push(data[i]);
                    }
                }
            });
            $scope.computers = $scope.computersFiltered;
        }
    }
]);
