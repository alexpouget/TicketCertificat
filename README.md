# TicketCertificat
Projet annuel gestion de licence logiciel

pour lancer la solution installer une base de données MySql et importer script.sql

puis executer la commande suivante :

en mettant a jour le chemin du fichier application.properties qui comporte les info de la base de données MySql

ainsi que configuration.properties qui comporte les informations du serveur SMTP

java -jar pom-0.0.1-SNAPSHOT.jar --spring.config.location=/Users/alex/IdeaProjects/TicketCertificat/src/main/resources/application.properties -Dproperties=/Users/alex/IdeaProjects/TicketCertificat/src/main/resources/configuration.properties

