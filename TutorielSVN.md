# Tutoriel sur SVN _(en cours d'amélioration)_ #


_La plupart des informations de ce document (notamment la partie 2) sont issues du cours google docs sur les outils de travail collaboratif. N'hésitez pas à le consulter pour peut-être plus de précisions (voir adresse dans les liens utiles)_


## Qu'est ce que SVN ? ##

SVN (_Subversion_) est un **logiciel de contrôle de versions**, c'est à dire permettant de sauvegarder les versions successives de fichiers, ainsi que leurs différences.
Basé sur le principe client-serveur, il permet de mutualiser des documents entre plusieurs membres d'une équipe (nous !), et de gérer leurs évolutions (modifications successives, éventuels conflits de versions).



## Comment ça marche ? ##

SVN est basé sur l'utilisation d'un serveur, sur lequel sont placés les documents. C'est ce que l'on appelle le **dépôt SVN** (repository), où sont regroupés tous les fichiers du projet.
L'adresse de notre dépôt pour le BE est : https://svn.etud.insa-toulouse.fr/BE4IA2/
Ce dépôt contient (ou plutôt contiendra) toutes les versions des fichiers qui y seront déposés, les différents commentaires correspondant aux mises à jour, les dates, heures, et auteur de ces mises à jour.
Comme vous pouvez le voir si vous visiter l'adresse du dépôt avec un navigateur, il est composé de 3 répertoires : trunk, branches, et tag.
Les sources en cours de développement sont généralement placées dans le répertoire trunk ; branches correspond plutôt à un aspect différent ou parallèle du développement en cours, et tag est réservé au stockage des différentes releases.

Pour pouvoir travailler sur le projet, il vous faut en faire une **copie locale** (sur votre ordinateur). C'est sur cette copie que vous apporterez les modifications que vous voulez, avant de les exporter vers le dépôt.

Un **conflit** apparaît quand la version de la copie locale est différente de celle située sur le dépôt : des modifications ont été faites par un autre utilisateur entre le moment où vous avez mis à jour votre copie, et le moment où vous voulez envoyer vos modifications sur le dépôt.
Il faut donc résoudre le conflit en récupérant la dernière version effectivement disponible, et vérifier que les modifications effectuées par l'autre utilisateur sont compatibles avec celles que vous souhaitiez apporter.

Les principales actions à connaitre pour travailler :
  * **_checkout_** : consiste à récupérer pour la 1ère fois les fichiers présents sur le dépôt pour créer sa copie locale (ne se fait qu'une seule fois par projet)
  * **_import_** : opération inverse du checkout, qui place les fichiers correspondants à la création d'un à un nouveau projet sur le dépôt.(ne se fait également qu'une fois par projet, à la création ; dans le cadre du BE, il est strictement inutile de se servir de cette commande, on se contentera d'ajouter des sources, le projet étant déjà créé sur le dépôt)
  * **_update_** : synchronisation de sa copie locale avec le dépôt. Si des modifications de la copie entrent en conflit avec la version du dépôt, c'est lors d'un update que ce sera signalé.
  * **_commit_** : à l'inverse de l'update, le commit charge sur le dépôt la copie locale. Une nouvelle révision est créée à chaque mise à jour du dépôt. Attention : pour pouvoir faire un commit, il faut que la copie de travail corresponde à la dernière révision du dépôt (modifications locales mises à part). Pour être sûr que ça soit le cas, penser à faire un update avant de tenter un commit, et résoudre les conflits si nécessaires.
  * **_add_** : ajout d'une source sur le dépot. Ne sera effectif qu'après le prochain commit
  * **_delete_** : suppression d'une source sur le dépot. Ne sera effectif qu'après le prochain commit



## Utilisation de SVN ##

  * **Directement depuis son IDE** : des tutoriaux ont été fait par Raphaël sur le forum 4GI, je me permet donc juste de vous mettre ici un lien vers le forum :
_(Dans l'attente du choix définitif de notre IDE, je vous met les 2)_
    1. [Eclipse](https://www.etud.insa-toulouse.fr/~wiketudgei/forum/viewtopic.php?f=13&t=26) (Attention ! il ya le tuto pour Jigloo avec, qui n'a strictement aucun rapport avec SVN)
    1. [Netbeans](https://www.etud.insa-toulouse.fr/~wiketudgei/forum/viewtopic.php?f=13&t=32)

  * **En ligne de commande** (sous linux)
Pour les inconditionnels du terminal sous linux, inutile de préciser que toutes les commandes sont évidemment possible depuis ce dernier. Pour les commandes de base :
    1. effectuer un checkout : **svn checkout** !https://svn.etud.insa-toulouse.fr/BE4IA2/
    1. ajouter un fichier : **svn add** nouveaufichier.extension
    1. supprimer un fichier : **svn remove** vieuxtruc.php
    1. valider ses modifications et les charger sur le serveur : **svn commit** [noms des fichiers ](.md) -m "commentaire"
    1. mettre à jour sa copie locale : **svn update**
    1. signaler la résolution d'un conflit : **svn resolved**


  * **A partir d'un client graphique**
Il existe de nombreux clients graphiques sous windows et linux permettant de gérer vos fichiers SVN simplement ([TortoiseSVN](http://tortoisesvn.net/downloads) (win), [RapidSVN](http://www.rapidsvn.org/index.php/Main_Page) (win et linux) par exemple). Ils peuvent vous être utiles si vous désirez mettre autre chose que des fichiers sources sur le SVN (un peu étrange que d'utiliser Eclipse pour mettre un pdf sur le serveur..) et que vous êtes allergique au terminal (ou sous windows tout simplement).
Même si chacun a ses spécificités (intégré à l'explorateur de fichiers pour TortoiseSVN par exemple), vous retrouverez à chaque fois les différentes actions nécessaires à la gestion de votre repository.
_Si quelqu'un désire un mini tuto sur l'utilisation d'un client graphique particulier, qu'il me le demande et je le rajouterai._



## Liens utiles : ##

  * Cours sur les outils de travail collaboratif : http://docs.google.com/View?id=ajd3dkpt7wh5_274qrbhxh3q
  * Liste complète de clients SVN : http://subversion.tigris.org/links.html#clients