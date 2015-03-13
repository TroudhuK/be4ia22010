### Page d'informations sur la modélisation des "missions" du côté du client ###

By Arthur et Aurélien

Compte tenu du fait que les "missions" seront représentées en XML, il faut mettre en place un mécanisme de sauvegarde de ces "missions".<br />
Petit diagramme UML:<br />
https://www.etud.insa-toulouse.fr/trac/BE4IA2/attachment/wiki/Mod%C3%A9lisation%20c%C3%B4t%C3%A9%20client/BdD%20Client%20-%20UML.PNG?format=raw

Version XML:
```
<mission>
   <idMission>1</idMission>
   <ordre>
      <idOrdre>1</idOrdre>
      <contenu>Ouvrir l'oeil gauche</contenu>
      <etat>false</etat>
   </ordre>
   <ordre>
      <idOrdre>2</idOrdre>
      <contenu>Ouvrir l'oeil droit</contenu>
      <etat>false</etat>
   </ordre>
   <ordre>
      <idOrdre>3</idOrdre>
      <contenu>Sortez de votre lit (attention à bien choisir le bon pied...)</contenu>
      <etat>false</etat>
   </ordre>
   ...
</mission>
```