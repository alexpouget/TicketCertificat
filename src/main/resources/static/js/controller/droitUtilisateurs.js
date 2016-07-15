/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('droitUtilisateurs', ['$scope','User','$location','$routeParams','$rootScope',
                                                        'UserRole','UserRoleUid','Role','$route',
    function($scope,User,$location,$routeParams,$rootScope,UserRole,UserRoleUid,Role,$route){

        //init var
        $scope.selected = {};
        $scope.password = "";
        $scope.uid = "";
        $scope.email = "";
        $scope.roles = Role.query();
        var uid = $routeParams.id;

        $scope.user = UserRoleUid.query({uid:uid},function(data) {

            console.log(JSON.stringify(data[0].role));
        });

        $scope.valRole = function () {
            console.log($scope.selected);
            console.log($scope.user[0].user);
            var newRole = new UserRole();
            newRole.user = $scope.user[0].user;
            newRole.role = $scope.selected;
            console.log(newRole);
            newRole.$save();
            $location.path("/utilisateurs");
        }

        $scope.deleteRole = function(data){
            console.log(data);
            var delRole = new UserRole();
            delRole.id = data.id;
            delRole.user = $scope.user[0].user;
            delRole.role = data.role;
            console.log(delRole);
            delRole.$delete();
            $route.reload();
        }

    }
]);
