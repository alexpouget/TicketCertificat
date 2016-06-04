/**
 * Created by bmichau on 04/06/2016.
 */
// Contrôleur de la page utilisateurs
TicketCertificatApp.controller('utilisateurs', ['$scope',
    function($scope){
        $( "#tabUtilisateurs #Modifier" ).click(function() {
            $("#formModifierUser").show();
            $("#tabGestionUsers").hide();
        });
        $( "#modifierUser" ).click(function() {
            $("#formModifierUser").hide();
            $("#tabGestionUsers").show();
        });
        $('#tabUtilisateurs input[type="checkbox"]').change(function(){

            $('#deleteUser').prop('disabled', $('#tabUtilisateurs input[type="checkbox"]').filter(':checked').length < 1);

        });

    }
]);
