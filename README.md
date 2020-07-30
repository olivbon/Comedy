# Comedy

Le test proposé consiste à lire un gros document et à publier son contenu dans un message
broker. Ce dernier a pour but d’évaluer votre niveau en programmation réactive.

## Consigne

Le test doit être écrit en scala en s’appuyant sur la bibliothèque Akka Stream. L’utilisation de
bibliothèques supplémentaires est recommandée.

Les données à traiter sont dans un fichier TSV (tab separated values) à télécharger sur IMDB
via le lien ci-dessous :
- https://datasets.imdbws.com/title.basics.tsv.gz
La structure de données utilisée dans les fichiers est décrite dans le lien ci-dessous :
- https://www.imdb.com/interfaces/

Le besoin formulé par le product owner est le suivant :
- En tant qu’utilisateur je souhaite récupérer dans une file RabbitMQ l’intégralité des
titres originaux de type film et du genre comédie.

## Remarques

Le fichier est trop gros pour être herbergé sur github directement. Il doit être ajouter dans Comedy/resource/.

Bibilothèques utilisées :

- Akka Stream 
- Alpakka pour le parsing du fichier https://doc.akka.io/docs/alpakka/current/data-transformations/csv.html
- op-rabbit pour publier dans une file RabbitMQ https://github.com/SpinGo/op-rabbit

Pour tester : 

- Le CLI de RabbitMQ avec la commande : rabbitmqctl list_queues

OU

- RabbitMQ Management http://localhost:15672/

