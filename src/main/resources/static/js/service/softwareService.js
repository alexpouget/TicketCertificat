/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('Software', ['$resource',
        function($resource){
            return $resource('/api/software/:id', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);