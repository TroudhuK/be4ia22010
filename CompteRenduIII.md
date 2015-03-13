### Compte rendu de la rencontre avec le client du 03/12/2009 ###

**J'ai noté ici ce que j'ai retenu de reunion mais c'est bien sur modifiable, commentable et a completer.._'._


---**


_Doit-on prévoir une interface compatible avec les Framework déjà existants pour la saisie d’ordres ? Si oui, donnez des exemples de Framework._
Réponse:Non pas dans l’immédiat car il serait surprenant que notre  programme ne soit pas du tout interfassable.

"_Si un ordre ne peut pas être terminé, par exemple c’est la fin de journée, doit-on envisager une solution pour que le serveur stocke le dernier ordre validé, afin qu'il apparaisse le lendemain dans la liste des ordre à effectuer ? Ou alors le terminal mobile garde-t-il l’ordre en mémoire, et le lendemain la personne reprendra sa tâche là où elle l’avait arrêtée ?_
Ceci correspond au problème de persistance des données.
Solution proposé lors de la rencontre:
Après chaque action que le client aura validé un message sera envoyé au serveur pour qu’il puisse savoir ou en est chaque utilisateur dans sa mission. Donc même si le terminal est éteint lorsque l’utilisateur se reloguera le serveur pourra lui redonner le même ordre a partir du point d'arrêt

_"Est-il nécessaire de prévoir une désactivation de la reconnaissance vocale pour pouvoir avoir des discussions annexes (désactivation manuelle ou vocale de l'oreillette) ?"_
Réponse:Oui mais pas un besoin fonctionnel primaire

_"Information sur le mode de wokflow?"_
Réponse:Devait être optionnel mais a l’air de devenir plus que optionnel...

_"Le système doit il écouter en permanence_?"
Réponse :Il écoute après chaque ordre données donc oui ne pas tenir compte des problèmes liés au bruit ou a l’utilisation d'énergie trop importante.

_"Aura-t-on un machine afin de pouvoir tester nos programme sur un terminal mobile? Si oui quand? Comment fait on pour l’instant?"_
Réponse :Oui. Début Janvier. Utiliser des simulateur de Windows Mobile

_"Le terminal possède t il déjà un JVM?"_
Réponse:Non il faut le choisir et ensuite le mettre sur le terminal mobile.

_"Peut on envisager de mettre un synthèse vocal coté serveur et transferer seulement des flux audio_?"
Réponse:Priorité sur la synthèse vocal sur le mobile. Mais envisageable de le penser niveau serveur si on a de trop gros problème.

_"Dois t on envisager de pouvoir donner plusieurs ordre sur le même terminal pour un parallélisme des taches?"_
Réponse:1 seul ordre sur le terminal.

_"Comment un utilisateur se logue t il?"_
Réponse:Identification de l'utilisateur: login mdp...reconnaissance vocal a voir..

_"Une priorité des missions est elle a prendre en compte?"_
Réponse:Non pas du coté client mais peu être du coté serveur.

_"L’affectation des ordres est il nominatif?"_
Réponse:Oui et il est effectuer par le le responsable des ordres coté serveur.

_"L’ordre doit il envisager toute les possibilité de réponse du client dés son envoie ou en cas de réponse non prévu envoie d’un message du coté serveur afin de donner la procédure a suivre?"_
Réponse:Euh pas bien compris la réponse.
(note:validation d'un ordre le serveur génère un nouveau workflow)



---


Besoin non fonctionnel : Prévoir une commande d’annulation de validation d’ordre.

Besoin Fonctionnel : Le serveur doit savoir quand et qui fait une pause.

Idée conception : Penser au préambule d’ordre spécifique a un utilisateur afin d'éviter les conflits avec d’autre utilisateur.
Pour workflow : Regarder Bipel? Regarder standars workflow

document a partagé:
Diagrame classe
Cas utilisatiokn
Tableau exigence pour chaque itération