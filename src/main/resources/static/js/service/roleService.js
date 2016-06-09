/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('Role', ['$resource',
        function($resource){
            return $resource('/api/role/:uid', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);