/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('Computer', ['$resource',
        function($resource){
            return $resource('/api/computer/:id', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);