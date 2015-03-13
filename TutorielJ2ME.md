# Tutoriel sur le fonctionnement de J2ME (_work in progress_) #

## Sommaire ##

### Introduction ###
### I. Le principe de fonctionnement d'une MIDlet ###
> a. Le cycle de vie d'une MIDlet
### II. Un exemple de MIDlet ###
> a. Code source
> b. Resultat
### III. Une application CDC ###
### IV. Liens utiles ###
### Conclusion ###


---


### Introduction ###

Petite info avant de commencer:
_J2ME ou Java 2 Mobile Edition est l'ancienne appelation pour Java ME ou Java Platform, Mobile Edition._
Java ME ou Java Platform, Micro Edition est l'édition de la plateforme Java à destination de l'électronique grand public et des systèmes embarqués. La technologie Java ME fourni une machine virtuelle et un ensemble d'API répartis dans deux composants principaux : les configurations et les profiles.


**NB:** Ce Tuto à pour but de faire une présentation générale de J2ME (CDC et CDLC), cependant dans le cadre de notre projet, il y a de grande chance que nous utilisions CDC. Donc la partie CDLC est en quelque sorte un _bonus_ pour ceux et celles qui souhaite approfondir leurs connaissances. Cette mise au point faite, nous pouvons attaquer.


La **configuration** représente le socle de J2ME. Elle est constituée de la machine virtuelle et des librairies bas-niveaux. Il existe actuellement deux types de configurations : CDC et CLDC.
CLDC ou Connected Limited Device Configuration est défini par les JSR 30 (CLDC 1.0) et JSR 139 (CLDC 1.1). Cette configuration est à destination des appareils à puissance modeste tels que téléphone cellulaire, organizer bas de gamme,... Les capacités de l'appareil sont généralement :

  * Un processeur 16 ou 32 bits avec une horloge à 16 MHz ou plus.
  * Au moins 150 Ko de mémoire non volatile alloués à la machine virtuelle et les librairies CLDC.
  * Au moins 192 Ko de mémoire totale disponible pour la plateforme Java. (160 ko pour la version 1.0)
  * Une faible consommation d'énergie.
  * Connection à certains type de réseaux, souvent sans fil, avec connection intermittente et bande passante limitée.

L'élément principal de toutes application mobile CDLC se nomme une _MIDlet_ (cf un peu plus loin pour de plus amples informations)


CDC ou Connected Device Configuration est défini par les JSR 36 (CDC 1.0.1) et JSR 218 (CDC 1.1 in progress). CDC est à destination d'appareil possédant des processeurs 32 bits, 2 MO de RAM et 2,5 MO de ROM pour l'environnement. Ces appareils disposent aussi d'une connection au réseau. Ce sont des appareils tels que les PDA haut de gammes, décodeur télévision, ...

Le **profil** est une spécification détaillant une API. Il est basé sur et utilise une configuration. Le profil est nécessaire pour fournir un environnement de fonctionnement complet pour un type d'appareil donné. Le profil fourni généralement l'interface utilisateur, les méthodes d'entrées-sorties et le mécanisme de persistance pour un groupe vertical d'appareil. Il doit se suffir à lui même et ne pas nécessiter l'ajout d'autres classes java.
Toutefois certains profils peuvent être créés pour répondre à certaines capacités ou services d'appareils (RMI, multimédia,...). Un appareil peut donc supporter plusieurs profils.
L'implémentation du profil est à la charge du fabricant de l'appareil qui porte la JVM sur son matériel.

### I. Le principe de fonctionnement d'une MIDlet ###
a. Le cycle de vie d'une MIDlet

https://www.etud.insa-toulouse.fr/trac/BE4IA2/attachment/wiki/Tutoriel%20J2ME/MIDlet_Cycle_de_vie.PNG?format=raw

La classe javax.microedition.midlet.Midlet permet le dialogue entre le système et l'application.

Elle possède trois méthodes qui permettent de gérer le cycle de vie de l'application en fonction des trois états possibles (active, suspendue ou détruite) : startApp() - Méthode appelée à chaque démarrage ou redémarrage de l'application. pauseApp() - Méthode appelée lors de la mise en pause de l'application. destroyApp() - Méthode appelée lors de la destruction de l'application.

C'est l'Application Management Software (AMS) qui crée le contexte et l'objet permettant d'exécuter votre application.

### II. Un exemple de MIDlet ###
a. Code source

Pour ne pas déroger aux traditions voici le merveilleux "Hello World!" propre à tout tutoriel qui se respecte.
Tout d'abord, créez un nouveau projet sur l'IDE de votre choix, puis ajouter une classe HelloMIDlet dans votre projet et enfin copiez ce petit programme.

```
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class HelloMIDlet extends MIDlet implements !CommandListener
{
    private Display display;
    private Form form;

    private Command infoQuitter = new Command("Quitter", Command.EXIT, 1);
    private Command quitter = new Command("Confirmer", Command.EXIT, 1);

    public HelloMIDlet(){
        super();
        display = Display.getDisplay(this);
        form = new Form("Ma Midlet");
        form.append(new !StringItem("","Bonjour à toutes et à tous."));

        form.addCommand(infoQuitter);
        form.setCommandListener(this); 
    }

    protected void destroyApp(boolean unconditional){
        this.notifyDestroyed();
    }

    protected void pauseApp() {
    }

    protected void startApp(){
        display.setCurrent(form); 
    }

    public void commandAction(Command c, Displayable d) {
        if(c == infoQuitter){
            Form formExit = new Form("");
            formExit.append(new !StringItem("", "Au revoir.\nMerci d'avoir utilisé cette MIDlet."));
            formExit.addCommand(quitter);
            formExit.setCommandListener(this);
            display.setCurrent(formExit);
        }
        else if (c == quitter){
            notifyDestroyed();
        }
    }
}
```

b. Resultat

Après compilation et exécution du projet, vous devriez voir un émulateur de téléphone portable.
Sur l'écran de celui-ci doit apparaître le message "Bonjour à toutes et à tous."

Il doit également il y avoir une commande "Quitter", qui lorsque l'on appuie dessus affiche le message:
"Au revoir.Merci d'avoir utilisé cette MIDlet."

### IV. Liens utiles ###

Voici une liste d'URL à visiter si vous voulez un peu plus d'information.

**Le** site de référence : http://java.sun.com/javame/reference/apis.jsp

FAQ de Developpez : http://java.developpez.com/faq/javame/

Création de MIDlet: http://today.java.net/article/2005/02/07/j2me-tutorial-part-1-creating-midlets

Interface utilisateur: http://today.java.net/article/2005/04/26/j2me-tutorial-part-2-user-interfaces-midp-20

Le multimedia sur J2ME: http://today.java.net/article/2005/09/22/j2me-tutorial-part-4-multimedia-and-midp-20

### Conclusion ###
Merci d'être passé par cette page du wiki et je nous souhaite bonne continuation pour mener à bien ce 'petit' projet.