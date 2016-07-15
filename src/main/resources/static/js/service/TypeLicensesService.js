/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('Typelicenses', ['$resource',
        function($resource){
            return $resource('/api/typelicense/:id', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);