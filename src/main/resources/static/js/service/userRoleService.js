/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('UserRole', ['$resource',
        function($resource){
            return $resource('/api/userRole/:id', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);
angular.module('TicketCertificatApp')
    .factory('UserRoleUid', ['$resource',
        function($resource){
            return $resource('/api/userRoleUid/:uid', {uid:'@uid'},
                {
                   //'get'   : {method: 'get', isArray:true},
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);
angular.module('TicketCertificatApp')
    .factory('UserRoleRole', ['$resource',
        function($resource){
            return $resource('/api/userRole/role/:id', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);