/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('Licences', ['$resource',
        function($resource){
            return $resource('/api/license/:id/:type', {id:'@id',type:'@type'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);