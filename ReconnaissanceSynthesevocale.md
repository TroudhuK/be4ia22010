# '''Reconnaissance/Synthese vocale ''' #

> Tout d'abord il faut savoir que ceci n'est pas vraiment un wiki mais plutot un bilan sur quelques recherches. Il faudra determiner avec le client ce qu'on peut utiliser et vers quoi on peut partir. C'est la que l'on pourra faire un wiki plus spécifique sur ce qu'on aura choisi.

## Plusieur possibilités : ##

Speech Recognition (ASR) : Reconnaissance vocale
Text-To-Speech (TTS) : Synthese vocale

### 1) Tout se fait sur le serveur ###

TTS :

Le client envoie le texte au serveur qui utilise J2EE. C'est lui qui fait la synthese (il existe des API libres comme Java Speech). Une fois la synthese faite, un fichier audio est renvoyé au client.

ASR :

Faire une middlet qui enregistre un fichier audio (par exemple MMAPI 1.1 est un paquet optionnel de J2ME permettant cela). Envoyer le fichier audio au server qui s'occupera de la reconnaissance vocale et renverra le texte (Java Speech peut aussi le faire).

Liens : Java Speech : pdf avec exemples simples pour comprendre l'utilisation de Java Speech :  http://charliter2003.free.fr/NOS-DOCS/jsapi.pdf


### 2) On passe par un serveur voice xml : ###

https://www.etud.insa-toulouse.fr/trac/BE4IA2/attachment/wiki/Reconnaissance/Synthese%20vocale/voiceXML.jpg?format=raw

http://fr.wikipedia.org/wiki/VoiceXML

http://www.voicexml.org/

petit pdf avec exemple simples de la syntaxe vxml (hello world exemple) :http://www.philippe.prados.name/Internet/VoiceXML/VoiceXML.pdf


### 3) Tout est fait au niveau du client (ce que je pense qu'il faudrait faire (si possible)) : ###

Inclure freeTTS (faire le tri de ce qu'il nous faut) dans J2ME (MIDP).
Peut marcher mais apparement beaucoup de travail.
Par contre je n'ai (pour l'instant) pas trouvé de solutions concernant la possibilite de faire la reconnaissance vocale sur le client.

Google code lien : inclusion de freeTTS pour faire synthese vocale sur un android :
http://code.google.com/p/android-text2speech/source/browse/

Lien sur l'utilisation de freeTTS : http://freetts.sourceforge.net/docs/ProgrammerGuide.html


### 4) Derniere solution : ###

Apparement la derniere version de l'api java speech (JSAPI 2) serait compatible avec J2ME mais je n'ai trouvé personne qui arrive à le faire fonctionner correctement et à l'integrer a J2ME.
De plus cette API ne semble pas open source : http://www.conversations.com/JSAPI2JSR113/FinalStandardCandidateReleaseRIDownload/tabid/201/Default.aspx

exemple de problème avec JSAPI 2: http://www.conversations.com/Forum/tabid/205/forumid/3/threadid/70/scope/posts/Default.aspx


## Conclusion : ##

Il faut voir avec le client mais je pense qu'il serait plus facile de prendre la solution 1 ou 2. C'est ce qui se fait généralement le plus.
Aprés on peut chercher pour la solution 3 (voir 4) mais ce sera peut etre dur d'aboutir a quelque chose de bien.

liens intéressant : http://espeak.sourceforge.net/

