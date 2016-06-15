/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('Licences', ['$resource',
        function($resource){
            return $resource('/api/license/:uid', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);