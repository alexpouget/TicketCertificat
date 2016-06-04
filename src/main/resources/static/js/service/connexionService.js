/**
 * Created by alex on 02/06/2016.
 */

angular.module('TicketCertificatApp')
    .factory('ConnexionService', ['$resource',
        function($resource){
            return $resource('/api/login',
                {

                }
            );
        }
    ]);