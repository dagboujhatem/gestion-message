# Coding Test

Cette application a été réalisé pour répondre à un test technique.

Vous pouvez éxécuter l'application en tappant `docker-compose up --build`. Ce qui permet de lancer: 
 
- L'application Backend : 
- L'application Frontend : 
- Container de base de données sql :
- Container d'`IBM MQ` : 

## Context: 
Le département de paiement de la banque est amené à recevoir des messages de la part des applications Back Office via une file `IBM MQ` Series.
Ces messages vont transiter dans une application de routage pour être transférés vers d’autres destinations.
Les utilisateurs ont aussi la possibilité d’ajouter des partenaires pour configurer les MQ.

## A réaliser: 

Créer une application qui permet :

- De lire et de stocker les messages déposés sur une file `IBM MQ` Series dans une base de données relationnelle.
- D’afficher la liste des messages stockés dans l’IHM sous forme de tableau.
- Pouvoir afficher le détails d’un message quand l’utilisateur clique sur le message dans le tableau.
Le détail s’affiche sous forme de popup avec un bouton `cancel` pour fermer la popup.
- D’exposer des API REST pour la consultation des messages via une IHM.
- D’exposer une API REST pour ajouter des partenaires. Pour ajouter un partenaire il faut les informations suivantes:
  - Alias:  required
  - Type: required
  - Direction:  deux possibilités `INBOUND, OUTBOUND`
  - Application: champ texte libre
  - Processed Flow Type 3 possibilités `MESSAGE, ALERTING, NOTIFICATION`
  - Description: required
- D’ajouter et de supprimer des partenaires MQ côté IHM
- Côté IHM l’utilisateur a menu de navigation qui contient Messages pour afficher la liste des messages, Partenaires pour accéder à la liste de partenaire et de pouvoir ajouter des partenaires. La liste des partenaires est un tableau aussi avec les propriétés comme nom de colonne.

Cette application devrait répondre à des contraintes de performance et de résilience étant donnée la volumétrie importante de messages à traiter.

#### Environnement technique:

- Langage: Java 11+
- Framework Spring Boot 2+
- Framework Angular 17, Angular Material ou autre comme couche graphique.
- Base de données relationnelle : aucune préférence
- Projet Maven
- Documentation pour tester l’application
- Utilisation de docker si possible
- Pusher le code sur github

#### Out Of Scope:

Gestion de l’authentification et des autorisations.

### Contact

You can contact me : [dagboujhatem@gmail.com](mailto:dagboujhatem@gmail.com)
