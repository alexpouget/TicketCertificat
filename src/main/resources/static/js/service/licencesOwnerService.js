/**
 * Created by alex on 16/04/2016.
 */

angular.module('TicketCertificatApp')
    .factory('LicencesOwner', ['$resource',
        function($resource){
            return $resource('/api/licenseowner/:id', {id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);