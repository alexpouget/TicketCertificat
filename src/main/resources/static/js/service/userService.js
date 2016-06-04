/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('User', ['$resource',
        function($resource){
            return $resource('/api/user/:uid', {uid:'@uid'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);