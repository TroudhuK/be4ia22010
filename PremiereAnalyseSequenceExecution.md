## Premiere analyse de la sequence d'exécution d'un ordre ##
Cette première analyse a pour but de savoir si on conçoit de la même manière l'exécution d'un ordre. Cette analyse n'est n'a encore pour but de mettre sur papier les différents diagramme UML que l'on aura besoin pour notre conception. Mais pour mettre en évidence quelques questions aux qu'elles on doit répondre avant de commencer la modélisation. Dans un premier temps un schéma (incomplet) montre un déroulement d'exécution d'un ordre ensuite vient une série de questions sur ce déroulement.


---

[Gestion Ordre sur mobile.pdf](https://www.etud.insa-toulouse.fr/trac/BE4IA2/attachment/wiki/Premiere%20analyse%20sequence%20execution/Gestion%20Ordre%20sur%20mobile.pdf)

---


Rajouter dans cette partie toutes les parties qu'il manque au schéma ci dessus (je les rajouterais ensuite au schéma voir les mettrait mieux sous formes de séquences diagrammes;
Question:
Comment gère t on le fait qu'un segment d'ordre est validé négativement?
  * Doit on continuer normalement la sequence et juste avertir le serveur que le segment de l'ordre n'a pus être réalisé. (voir peut être mettre en place un système de dépendance entre les ordres?)
  * Avertir el serveur que la tache est impossible a réaliser et attendre un réponse de celui ci afin qu'il nous donne un nouvel ordre?  (perte de la capacité de persistance)
  * Prévoir dans la structure de l'ordre tous les cas possible et prévoir une alternative a chaque segment d'ordre si il ne peut pas être réalisé

Comment gère t on la fin d'un ordre?
  * A la validation du dernier segment d'ordre si tout les segments d'ordre ont étés validé on averti le serveur que l'ordre a été complété avec succès mais sinon ?? on refait un boucle afin de voir si un tache refusé un maintenant disponible ou on envoie un message au serveur signalant au serveur quels segments n'a pas été réalisé et le serveur remettra disponible un version raccourci de l'ordre avec tous les segment non complétés quand ils seront disponible?