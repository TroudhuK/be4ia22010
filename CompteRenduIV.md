# Compte rendu de la séance du 10/12/09 #


## Redéfinition de l'organisation : ##
2 personnes s'occuperont finalement de la conception côté serveur (Sylvain et Edith)



## Technologies de Reconnaissance et Synthèse vocale : ##
le Java ne serait à priori pas l'idéal, il existe des modules dans d'autres langages qui seraient plus adaptés (modules en C# notamment)



## Bilan de la séance : ##
  * _Conception :_
se référer aux diagrammes UML réalisés (Use Cases + diagrammes de séquence pour l'Identification, la Mise en pause et la Sortie de pause)

  * _Reconnaissance Vocale :_
La majorité des outils sont basés sur le principe de comparaison de l'enregistrement avec des échantillons préexistants.
Il faudra donc prendre en compte la nécessité de stocker ces échantillons et de les comparer à l'enregistrement entrant.

Après recherches, il existe un outil en C faisant cette comparaison, mais il faut vérifier :
- si cette application est compilable sous Windows Mobile
- si elle est compatible Windows Mobile
- sous quelle licence elle a été publiée (droit de la réutiliser en open source ou pas)

  * _Synthèse vocale :_
De même que pour la reconnaissance vocale, existence d'outils en C => même problèmes/vérifications que pour l'application de reconnaissance vocale



**Pour Dimanche soir :**
  * explorer les différentes pistes disponibles pour les technologies de reconnaissance et synthèse vocale, et publier les résultats de ces recherches
  * Continuer la conception (diagrammes de séquences)


## Questions d'organisation : ##
  * Prêt du terminal : à priori disponible la semaine prochaine, mais certainement pas possible de faire les tests pendant les vacances. A réfléchir pour préparer les tests pour la rentrée ?
  * Pour les parties synthèse et reconnaissance vocale, penser à bien séparer l'implémentation technique de ces technologies à proprement dites du reste, afin de limiter les modifications nécessaires si jamais il fallait se rabattre sur de la synthèse/reconnaissance sur serveur (par exemple, séparer synthèse et lecture audio)
  * Ne pas hésiter à partages les informations avec les autres groupes, pour les recherches de solutions de synthèse/reconnaissances notamment