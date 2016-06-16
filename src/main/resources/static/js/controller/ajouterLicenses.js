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

        /*function find(softwareSelected, typeSelected) {
            $scope.result = null;
            $scope.licences = Licences.query(function(data){
                console.log("merdier");
                console.log(JSON.stringify(data));
                for(var d in data) {
                    console.log("merde");
                    console.log(JSON.stringify(data[d]));
                    if(data[d].software != null &&  data[d].software.id==softwareSelected.id){
                        console.log("passe1");
                        if(data[d].typeLicense.id==typeSelected.id){
                            console.log("passe2");
                            $scope.result = data[d];
                            console.log($scope.result);
                        }
                    }
                }
            });
        }*/

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
    }
]);
