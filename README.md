# SQLhandle
Final Year Project at the Higher School of Technology of Meknes, 'SQL handle' built with java

![Finished App](https://github.com/salaheddinelhamraoui/SQLhandle/blob/master/1.jpg)



1.	Page d'authentification:

Sur cette page, l'utilisateur saisit les informations relatives à la base de données MYSQL. Le système vérifie si ces informations ont été saisies correctement. Si tel est le cas, une connexion avec la base de données est établi: Si la réponse de la base de données est négative, l'utilisateur en est informé via un message d erreur. Si la réponse de la base de données est positive, l'utilisateur est redirigé vers la page principale de l'application.

2.	Page principale:

Dès que la connexion avec la Base de données a été établie avec succès, l'ensemble des tables et des tableaux de la RAM sont récupérés et figurent ainsi sur le tableau de bord de l'application. Ce dernier regroupe plusieurs panels dont chacun a une fonctionnalité bien définie:

2.1.	Barre supérieure:

La barre supérieure comporte deux listes déroulantes:

2.1.1.	Menu:
La première liste est intitulée `Menu` et comprend les éléments suivants:
➢	`Nouveau tableau` permet d'ajouter un nouveau tableau.
➢	`Nouvelle base de données` permet d'ajouter une nouvelle base de données.
➢	`Éditeur de texte` permet, comme son nom l'indique, d'éditer du texte.
➢	`Afficher l`historique` permet d'afficher la liste des modifications effectuées par l`utilisateur.

2.1.2.	Fichier:
Cette liste contient deux éléments: `Import` et `Export`
➢	`Import` permet d'importer une base de données.
➢	`Export` permet d'exporter une base de données.


2.2.	Barre latérale: 
La barre latérale est divisée en deux parties: 

➢	La partie supérieure contient une icône permettant de supprimer une base de données et une deuxième icône responsable de réimporter une base de données pour montrer les modifications récentes.
➢	La partie inférieure n'est autre qu une arborescence de tableaux et bases de données.. Il suffit d'un clic droit sur l'un des éléments de l'arborescence pour afficher la liste des options que l'on peut y appliquer:
➔	`Supprimer` permet de supprimer l`élément.
➔	`Afficher les enregistrements` permet d'afficher les données enregistrées dans le tableau.
 
➔	`Afficher structure` permet d'afficher la structure du tableau.
 
➔	`Insérer` permet d'intégrer de nouvelles données au tableau.
 
2.3.	Milieu de la page:

Le milieu de page affiche tout ce qui a été ouvert par l'utilisateur sous forme d'onglets, où chaque onglet correspond à un projet donné. La navigation entre ces différents onglets se fait de manière intuitive. La suppression des onglets est toute aussi intuitive, soulignant ainsi le caractère ergonomique de l'application.


3.	Nouveau tableau:

	Sur cette vue, l'utilisateur peut ajouter un nouveau tableau pour toute base de données. Il est nécessaire de choisir dans un premier temps la base de donnée concernée par cet ajout, puis mentionner le nom du tableau et spécifier le nombre de colonnes. L'utilisateur devra également remplir les propriétés spécifiques à chaque colonne.
	 
	

Un message d'erreur s'affiche au cas où une ou plusieurs données saisies par l'utilisateur sont erronées ou encore si le programme ne s'est pas connecté correctement à la base de données.

	Une fois que le tableau a été ajouté avec succès, le programme est actualisé. Le nom du tableau figurera donc parmi les éléments affichés sur le menu latéral.

4.	Nouvelle base de données:

	Cette fonctionnalité permet à l'utilisateur d'ajouter une ou plusieurs bases de données en commençant par en saisir le nom. En cas d'erreur, un message d'erreur s`affichera afin d`en aviser l`utilisateur.

5.	Afficher l`historique:

Il est possible de visualiser l'ensemble de l'activité de l'utilisateur sur cette vue, y compris les modifications des tableaux et des bases de données ainsi que les éléments ajoutés.

6.	Import des bases de données:

	L'utilisateur peut importer une ou plusieurs bases de données externes sur cette vue en spécifiant le chemin du script SQL afin que la base de données soit importée.

	Un message de confirmation s'affiche stipulant que l'impôt a été effectué avec succès. Sinon , en cas d'échec, les informations relatives à l'erreur seront affichées sur le message d'erreur.

7.	Export des bases de données:

L'utilisateur peut exporter toute base de donnée disponible sur le serveur dans le dossier SQL et l'utiliser avec tout autre programme de gestion de base de données.

8.	Éditeur de texte:

	Il s`agit d`un éditeur de texte permettant d'écrire toute requête SQL et de l'appliquer de manière instantanée sur les bases de données.

	En cas de `DESC`, `SHOW`, `SELECT`, le résultat de la requête est généré sous forme de tableau. Ce dernier est donc présenté à l'utilisateur en JTable. Quant aux autres requêtes, elles seront appliquées aux bases de données et l'utilisateur sera avisé de leur succès ou , cas échéant, de leur échec.
