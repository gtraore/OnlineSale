# onlinesale
Application Web offrant les fonctionnalités suivantes : 
Afficher un catalogue de produits 
Afficher le détail d’un produit 
Ajouter un produit au panier 
Afficher le contenu du panier

Environement de DEV : 
Tomcat 9
Java 8
Eclipse Neon
MySQL Server

Avant de lancer le serveur, le script de création de la BD (db_create.sql) doit être exécuté.
Les paramètres de connexion à la BD doivent aussi être configurés dans les fichiers suivants :
/src/onlinesale/dbconnection/DBConnection.java
/WebContent/cartContent.jsp
/WebContent/productdetails.jsp
/WebContent/productslist.jsp
