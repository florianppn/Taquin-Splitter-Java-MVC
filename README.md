# Jeu du Taquin

## Description

Jeu du Taquin implémenté en Java à l'aide de la bibliothèque graphique Swing.

## Règles du jeu

Le taquin est un jeu de puzzle qui se joue sur une grille carrée, en 4x4, où il manque une case. 
Le but du jeu est de réorganiser les tuiles numérotées en les faisant glisser dans l'espace vide, afin de reconstituer une image ou un ordre numérique prédéfini.

## Fonctionnalités principales

+ Reconstituer une image.

+ Reconstituer un ordre numérique.

+ Possiblité de mettre une image personnalisé.

## Comment lancer le jeu

Les scripts permettant de lancer le jeu sont disponibles dans le dossier `dist`.

+ LINUX : lancer le fichier `./run.sh` pour lancer le jeu.

+ WINDOWS : lancer le fichier `./run.bat` pour lancer le jeu.

## Comment mettre une image personnalisée

J'ai mis à votre disposition un splitter permettant de découper une image en plusieurs morceaux. Il est disponible dans le dossier `dist`.

+ LINUX : lancer le fichier `./splitter.sh <chemin image> <lignes> <colonnes>`.
    + Exemple : `./splitter.sh /home/user/image.jpg 4 4`.
    + Exemple : `./splitter.sh image.jpg 4 4`.
+ WINDOWS : lancer le fichier `./splitter.bat <chemin image> <lignes> <colonnes>`.
    + Exemple : `./splitter.bat C:\Users\user\image.jpg 4 4`.
    + Exemple : `./splitter.bat image.jpg 4 4`.
+ JAVA : lancer la commande `java -jar splitter.jar <chemin image> <lignes> <colonnes>`.
    + Exemple : `java -jar splitter.jar /home/user/image.jpg 4 4`.
    + Exemple : `java -jar splitter.jar C:\Users\user\image.jpg 4 4`.

## Utilisation du fichier ANT

Le fichier `build.xml` se trouve à la racine du projet. Il permet de compiler le projet via ANT.

+ ANT : utiliser la commande `ant run` pour lancer le jeu.

+ ANT : utiliser la commande `ant dist-taquin` pour recompiler le jeu.

+ ANT : utiliser la commande `ant dist-splitter` pour recompiler le splitter.

+ ANT : ouvrez le fichier `build.xml` pour plus d'informations.

## Contribuer

+ N'hésitez pas à signaler des bugs.

+ N'hésitez pas à améliorer le code existant.

## Licence

Ce projet est sous licence [MIT].

## Captures d'écran

![Taquin](./screenshots/taquin.png)
