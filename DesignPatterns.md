## Patrons de conception (Design pattern) ##

pour informations complémentaires (diagrammes et autres designs patterns)
Visiter la pages
http://fr.wikibooks.org/wiki/Patrons_de_conception


## 1 Patron de conception ##


Un patron de conception (design pattern en anglais) est un concept de génie logiciel destiné à résoudre les problèmes récurrents suivant le paradigme objet. En français on utilise aussi le terme motif de conception qui est une traduction alternative de design pattern, perçue comme incorrecte par certains[réf. nécessaire].

Les patrons de conception décrivent des solutions standard pour répondre à des problèmes d'architecture et de conception des logiciels. À la différence d'un algorithme qui s'attache à décrire d'une manière formelle comment résoudre un problème particulier, les patrons de conception décrivent des procédés de conception généraux. On peut considérer un patron de conception comme une formalisation de bonnes pratiques, ce qui signifie qu'on privilégie les solutions éprouvées.

Il ne s'agit pas de fragments de code, puisque les patrons de conception sont le plus souvent indépendants du langage de programmation, mais d'une méthode de conception, c’est-à-dire d'une manière standardisée de résoudre un problème qui s'est déjà posé par le passé. Le concept de patron de conception a donc une grande influence sur l'architecture logicielle d'un système.
On peut donc considérer les patrons de conception comme un outil de capitalisation de l'expérience appliqué à la conception logicielle.

## 1.1 But général ##


Le but général des patrons de conception est de minimiser les interactions qu'il peut y avoir entre les différentes classes (ou modules, plus généralement) d'un même programme. L'avantage de ces patrons est de diminuer le temps nécessaire au développement d'un logiciel et d'augmenter la qualité du résultat, notamment en appliquant des solutions déjà existantes à des problèmes courants de conception. Ils sont là pour éviter la présence d'anti-patrons. Ils sont aussi utiles pour définir un vocabulaire commun entre les différents acteurs de l'écriture d'un logiciel.
Ces patrons sont décrits sous une forme abstraite, sans s'attacher aux détails du problème à
Les motifs de conception sont classifiés selon trois grandes familles :

•	Motifs de création :

> Motif Abstract Factory, Motif Builder, Motif Factory Method, Motif Prototype, Motif Singleton.

•	Motifs de structuration :

> Motif Adapter, Motif Bridge, Motif Composite, Motif Decorator, Motif Facade, Motif Flyweight, Motif Proxy.

•	Motifs de comportement :

> Motif Chain of Responsibility, Motif Command, Motif Interpreter, Motif Iterator, Motif Mediator, Motif Memento, Motif Observer, Motif State, Motif Strategy, Motif Template Method, Motif Visitor.


## 2 Quelques exemples de motifs de conception . ##


## 2.1 Patrons de création ##

## 2.1.1  Prototype (patron de conception) ##

Le patron de conception prototype est utilisé lorsque la création d'une instance est complexe ou consommatrice en temps. Plutôt que créer plusieurs instances de la classe, on copie la première instance et on modifie la copie de façon appropriée.

Pour implémenter ce patron il faut déclarer une classe abstraite spécifiant une méthode virtuelle pure appelée clone(). Toute classe nécessitant un constructeur polymorphique dérivera de cette classe abstraite et implémentera la méthode clone().
Le client de cette classe, au lieu d'écrire du code invoquant directement l'opérateur "new" sur une classe explicitement connue, appellera la méthode clone() sur le prototype ou passera par un mécanisme fourni par un autre patron de conception (par exemple une méthode de fabrique avec un paramètre désignant la classe concrète à instancier).





Exemple de code en JAVA

```
 /* Prototype Class */
 
 public class Cookie implements Cloneable
 {
    public Object clone()
    {
        try
        {
            // In an actual implementation of this pattern you would now attach references to
            // the expensive to produce parts from the copies that are held inside the prototype.
 
            return this.getClass().newInstance();
        }
        catch(InstantiationException e)
        {
           e.printStackTrace();
           return null;
        }
    }
 }
 
 /* Concrete Prototypes to clone */
 
 public class CoconutCookie extends Cookie { }
 
 /* Client Class */
 
 public class CookieMachine
 {
     private Cookie cookie; // could have been a private Cloneable cookie;
 
     public CookieMachine(Cookie cookie)
     { 
         this.cookie = cookie; 
     }
 
     public Cookie makeCookie()
     {
         return (Cookie) cookie.clone(); 
     }
 
     public Object clone() { } 
 
     public static void main(String args[])
     { 
         Cookie        tempCookie =  null; 
         Cookie        prot       = new CoconutCookie(); 
         CookieMachine cm         = new CookieMachine(prot); 
 
         for (int i=0; i<100; i++)
             tempCookie = cm.makeCookie(); 
     }
 }
```


Exemple

Exemple où prototype s'applique : supposons une classe pour interroger une base de données. À l'instanciation de cette classe on se connecte et on récupère les données de la base avant d'effectuer tous types de manipulation. Par la suite il sera plus performant pour les futures instances de cette classe de continuer à manipuler ces données que de réinterroger la base. Le premier objet de connexion à la base de données aura été créé directement puis initialisé. Les objets suivants seront une copie de celui-ci et donc ne nécessiteront pas de phase d'initialisation.

## 2.1.2 Singleton ##


Le singleton est un patron de conception dont l'objet est de restreindre l'instanciation d'une classe à un seul objet (ou bien à quelques objets seulement). Il est utilisé lorsque l'on a besoin d'exactement un objet pour coordonner des opérations dans un système. Le modèle est parfois utilisé pour son efficacité, lorsque le système est plus rapide ou occupe moins de mémoire avec peu d'objets qu'avec beaucoup d'objets similaires.

On implémente le singleton en écrivant une classe contenant une méthode qui crée une instance uniquement s'il n'en existe pas encore. Sinon elle renvoie une référence vers l'objet qui existe déjà. Dans beaucoup de langages de type objet, il faudra veiller à ce que le constructeur de la classe soit privé ou bien protégé, afin de s'assurer que la classe ne puisse être instanciée autrement que par la méthode de création contrôlée.

Le singleton doit être implémenté avec précaution dans les applications multi-thread. Si deux processus légers exécutent en même temps la méthode de création alors que l'objet unique n'existe pas encore, il faut absolument s'assurer qu'un seul créera l'objet, et que l'autre obtiendra une référence vers ce nouvel objet.
La solution classique à ce problème consiste à utiliser l'exclusion mutuelle pour indiquer que l'objet est en cours d'instanciation.

Diagramme de classes UML
La figure ci-dessous donne le diagramme de classes UML du patron de conception Singleton.


Diagramme de classes UML du patron de conception Singleton

voir http://fr.wikibooks.org/wiki/Patrons_de_conception/Singleton

Implémentation Java
Voici une solution écrite en Java (il faut écrire un code similaire pour chaque classe-singleton) :
```
public class Singleton
{
    private static Singleton INSTANCE = null;
 
    /**
     * La présence d'un constructeur privé supprime
     * le constructeur public par défaut.
     */
    private Singleton() {}
 
    /**
     * Le mot-clé synchronized sur la méthode de création
     * empêche toute instanciation multiple même par
     * différents threads.
     * Retourne l'instance du singleton.
     */
    public synchronized static Singleton getInstance()
    {
        if (INSTANCE == null) 
            INSTANCE = new Singleton();
        return INSTANCE;
    }
}
```
Une solution variante existe cependant. Elle consiste à alléger le travail de la méthode getInstance en déplaçant la création de l'instance unique au niveau de la déclaration de la variable référant l'instance unique :
```
public class Singleton
{
    /**
     * Création de l'instance au niveau de la variable.
     */
    private static final Singleton INSTANCE = new Singleton();
 
    /**
     * La présence d'un constructeur privé supprime
     * le constructeur public par défaut.
     */
    private Singleton() {}
 
    /**
     * Dans ce cas présent, le mot-clé synchronized n'est pas utile.
     * L'unique instanciation du singleton se fait avant
     * l'appel de la méthode getInstance(). Donc aucun risque d'accès concurrents.
     * Retourne l'instance du singleton.
     */
    public static Singleton getInstance()
    {
        return INSTANCE;
    }
}
```

## 2.1.3 Monteur ##

Le monteur (builder) est un patron de conception utilisé pour la création d'une variété d'objets complexes à partir d'un objet source. L'objet source peut consister en une variété de parties contribuant individuellement à la création de chaque objet complet grâce à un ensemble d'appels à l'interface commune de la classe abstraite Monteur.

Un exemple d'objet source est une liste de caractères ou d'images dans un message devant être codé. Un objet directeur est nécessaire pour fournir les informations à propos de l'objet source vers la classe Monteur. La classe Monteur abstraite pourrait être une liste d'appel de l'interface que la classe directeur utilise comme par exemple handleCharacter() ou handleImage(). Chaque version concrète de la classe Monteur pourrait implémenter une méthode pour ces appels ou bien simplement ignorer l'information si appelée.

Un exemple de monteur concret serait enigmaBuilder qui crypterait le texte, mais ignorerait les images.
Dans l'exemple précédent, le logiciel va créer une classe Monteur spécifique, enigmaBuilder. Cet objet est passé à un objet directeur simple qui effectue une itération à travers chaque donnée du message principal de l'objet source. La classe monteur crée, incrémentalement, son projet final. Finalement, le code principal va demander l'objet final depuis le Monteur et ensuite détruire celui-ci et l'objet directeur. Par la suite, si jamais un remplacement de la technique de cryptage de enigmaBuilder par une autre se faisait sentir, une nouvelle classe Monteur pourrait être substituée avec peu de changements pour la classe directeur et le code principal. En effet, le seul changement serait la classe Monteur actuelle passée en paramètre au directeur.
But : Séparer la construction d'un objet complexe de la représentation afin que le même processus de construction puisse créer différentes représentations.

Diagramme de classes
La structure des classes du patron de conception Monteur peut être représenté par le diagramme de classes UML suivant :

Diagramme UML des classes du patron de conception Monteur

http://fr.wikibooks.org/wiki/Patrons_de_conception/Monteur

Exemple   Java
```
/* Produit */
class Pizza
{
    private String pate = "";
    private String sauce = "";
    private String garniture = "";
 
    public void setPate(String pate)          { this.pate = pate; }
    public void setSauce(String sauce)         { this.sauce = sauce; }
    public void setGarniture(String garniture) { this.garniture = garniture; }
}
 
/* Monteur */
abstract class MonteurPizza
{
    protected Pizza pizza;
 
    public Pizza getPizza() { return pizza; }
    public void creerNouvellePizza() { pizza = new Pizza(); }
 
    public abstract void monterPate();
    public abstract void monterSauce();
    public abstract void monterGarniture();
}
 
/* MonteurConcret */
class MonteurPizzaHawaii extends MonteurPizza
{
    public void monterPate()      { pizza.setPate("croisée"); }
    public void monterSauce()     { pizza.setSauce("douce"); }
    public void monterGarniture() { pizza.setGarniture("jambon+ananas"); }
}
 
/* MonteurConcret */
class MonteurPizzaPiquante extends MonteurPizza
{
    public void monterPate()      { pizza.setPate("feuilletée"); }
    public void monterSauce()     { pizza.setSauce("piquante"); }
    public void monterGarniture() { pizza.setGarniture("pepperoni+salami"); }
}
 
/* Directeur */
class Serveur
{
    private MonteurPizza monteurPizza;
 
    public void setMonteurPizza(MonteurPizza mp) { monteurPizza = mp; }
    public Pizza getPizza() { return monteurPizza.getPizza(); }
 
    public void construirePizza()
    {
        monteurPizza.creerNouvellePizza();
        monteurPizza.monterPate();
        monteurPizza.monterSauce();
        monteurPizza.monterGarniture();
    }
}
 
/* Un client commandant une pizza. */
class ExempleMonteur
{
    public static void main(String[] args)
    {
        Serveur serveur = new Serveur();
        MonteurPizza monteurPizzaHawaii  = new MonteurPizzaHawaii();
        MonteurPizza monteurPizzaPiquante = new MonteurPizzaPiquante();
 
        serveur.setMonteurPizza(monteurPizzaHawaii);
        serveur.construirePizza();
 
        Pizza pizza = serveur.getPizza();
    }
}
```

## 2.2 Patrons de structure ##


## 2.2.1 Proxy ##

Un proxy est une classe se substituant à une autre classe. Par convention et simplicité, le proxy implémente la même interface que la classe à laquelle il se substitue. L'utilisation de ce proxy ajoute une indirection à l'utilisation de la classe à substituer. Le proxy sert à gérer l'accès à un objet, il agit comme un intermédiaire entre la classe utilisatrice et l'objet.
Un proxy est un cas particulier du patron de comportement État. Un proxy implémente une et une seule interface, donc se substitue à une seule classe. Un état peut implémenter un nombre quelconque d'interfaces.
Un proxy est utilisé principalement pour contrôler l'accès aux méthodes de la classe substituée. Un état est utilisé pour changer dynamiquement d'interface.
Outre l'utilisation principale du proxy (contrôle des accès), ce dernier est également utilisé pour simplifier l'utilisation d'un objet « complexe » à la base. Par exemple, si l'objet doit être manipulé à distance (via un réseau) ou si l'objet est consommateur de temps.
Il existe différents types de Proxy ayant un comportement ou un rôle différent :
•	Remote proxy : fournir une référence sur un objet situé sur un espace d'adressage différent, sur la même machine ou sur une autre,
•	Virtual proxy : retarder l'allocation mémoire des ressources de l'objet jusqu'à son utilisation réelle,
•	Copy-on-write proxy : une forme de proxy virtuel pour retarder la copie de l'objet jusqu'à demande par la classe utilisatrice, utilisé notamment pour la modification concurrente par différents threads,
•	Protection (access) proxy : fournir à chaque classe cliente un accès à l'objet avec des niveaux de protection différents,
•	Firewall proxy : protéger l'accès à l'objet par des classes « malveillantes » ou vice-versa,
•	Synchronization proxy : fournir plusieurs accès à l'objet synchronisé entre différentes classes utilisatrices (cas de threads multiples),
•	Smart reference proxy : fournir des actions supplémentaires à chaque accès à l'objet (compteur de références, ...),
•	Cache proxy : stocker le résultat d'opérations coûteuse en temps, afin de pouvoir les partager avec les différentes classes utilisatrices.



Exemple
L'exemple Java suivant implémente un Proxy virtuel. La classe ProxyImage est utilisée pour retarder le long chargement d'un fichier jusqu'à ce que le chargement soit réellement nécessaire. Si le fichier n'est pas nécessaire, le chargement coûteux en temps n'a pas du tout lieu.
```
import java.util.*;
 
interface Image
{
    public void displayImage();
}
 
class RealImage implements Image
{
    private String filename;
    public RealImage(String filename)
    {
        this.filename = filename;
        loadImageFromDisk();
    }
 
    private void loadImageFromDisk()
    {
        System.out.println("Chargement de "+filename);
        // Opération potentiellement coûteuse en temps
    }
 
    public void displayImage()
    {
        System.out.println("Affichage de  "+filename);
    }
}
 
class ProxyImage implements Image
{
    private String filename;
    private Image image;
 
    public ProxyImage(String filename)
    {
        this.filename = filename;
    }
 
    public void displayImage()
    {
        if (image == null)
        {
            image = new RealImage(filename); // Chargement sur demande seulement
        }
        image.displayImage();
    }
}
 
class ProxyExample
{
    public static void main(String[] args)
    {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");
        Image image3 = new ProxyImage("HiRes_10MB_Photo3");
 
        image1.displayImage(); // chargement nécessaire
        image2.displayImage(); // chargement nécessaire
        image1.displayImage(); // pas de chargement nécessaire, déjà fait
        // la troisième image ne sera jamais chargée : pas de temps gaspillé
    }
}
```
Le programme affiche :
```
Chargement de HiRes_10MB_Photo1
Affichage de  HiRes_10MB_Photo1
Chargement de HiRes_10MB_Photo2
Affichage de  HiRes_10MB_Photo2
Affichage de  HiRes_10MB_Photo1
```

## 2.2.2 Adaptateur ##


Adaptateur est un patron de conception qui permet de convertir l'interface d'une classe en une autre interface que le client attend. Adaptateur fait fonctionner un ensemble des classes qui n'auraient pas pu fonctionner sans lui, à cause d'une incompatibilité d'interfaces.
Exemple
Vous voulez intégrer une classe que vous ne voulez/pouvez pas modifier.
Applicabilité
•	Une API tiers convient à votre besoin fonctionnel, mais la signature de ses méthodes ne vous convient pas.
•	Vous voulez normaliser l'utilisation d'anciennes classes sans pour autant en reprendre tout le code.


Conséquences

Un objet Adaptateur sert de liaison entre les objets manipulés et un programme les utilisant, à simplifier la communication entre deux classes. Il est utilisé pour modifier l'interface d'un objet vers une autre interface.

Utilisations connues

On peut également utiliser un adaptateur lorsque l'on ne veut pas implémenter toutes les méthodes d'une certaine interface. Par exemple, si l'on doit implémenter l'interface MouseListener en Java, mais que l'on ne souhaite pas implémenter de comportement pour toutes les méthodes, on peut dériver la classe MouseAdapter. Celle-ci fournit en effet un comportement par défaut (vide) pour toutes les méthodes de MouseListener.

Exemple avec MouseAdapter :
```
public class MouseBeeper extends MouseAdapter
{
    public void mouseClicked(MouseEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
    }
}

Exemple avec MouseListener :

public class MouseBeeper implements MouseListener
{
    public void mouseClicked(MouseEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
    }
 
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
```


## 2.2.3 Objet composite ##

Dans ce patron de conception, un objet composite est constitué d'un ou de plusieurs objets similaires (ayant des fonctionnalités similaires). L'idée est de manipuler un groupe d'objets de la même façon que s'il s'agissait d'un seul objet. Les objets ainsi regroupés doivent posséder des opérations communes, c'est-à-dire un "dénominateur commun".

Quand l'utiliser

Vous avez l'impression d'utiliser de multiples objets de la même façon, souvent avec des lignes de code identiques ou presque. Par exemple, lorsque la seule et unique différence entre deux méthodes est que l'une manipule un objet de type Carré, et l'autre un objet Cercle. Lorsque, pour le traitement considéré, la différenciation n'a pas besoin d'exister, il serait plus simple de considérer l'ensemble de ces objets comme homogène.
Un exemple
Un exemple simple consiste à considérer l'affichage des noms de fichiers contenus dans des dossiers :
•	Pour un fichier, on affiche ses informations.
•	Pour un dossier, on affiche les informations des fichiers qu'il contient.
Dans ce cas, le patron composite est tout à fait adapté :
•	L'Objet est de façon générale ce qui peut être contenu dans un dossier : un fichier ou d'un dossier,
•	L'ObjetSimple est un fichier, sa méthode affiche() affiche simplement le nom du fichier,
•	L'ObjetComposite est un dossier, il contient des objets (c'est à dire des fichiers et des dossiers). Sa méthode affiche() parcourt l'ensemble des objets qu'il contient (fichier ou dossier) en appelant leur méthode affiche().



La classe utilisatrice manipule les objets de la composition à travers l'interface Objet.

Implémentations Java

L'exemple qui suit, écrit en Java, met en œuvre une classe graphique qui peut être ou bien une ellipse ou une composition de différents graphiques. Chaque graphique peut être imprimé.
Il pourrait être étendu en y ajoutant d'autres formes (rectangle etc.) et méthodes (translation etc.).
```
import java.util.ArrayList;
 
interface Graphic
{
    //Imprime le graphique.
    public void print();
}
 
class CompositeGraphic implements Graphic
{
    //Collection de graphiques enfants.
    private ArrayList<Graphic> mChildGraphics = new ArrayList<Graphic>();
 
    //Imprime le graphique.
    public void print()
    {
        for (Graphic graphic : mChildGraphics)
        {
            graphic.print();
        }
    }
 
    //Ajoute le graphique à la composition composition.
    public void add(Graphic graphic)
    {
        mChildGraphics.add(graphic);
    }
 
    //Retire le graphique de la composition.
    public void remove(Graphic graphic)
    {
        mChildGraphics.remove(graphic);
    }
 
}
 
class Ellipse implements Graphic
{
    //Imprime le graphique.
    public void print()
    {
        System.out.println("Ellipse");
    }
 
}
 
public class Program
{
    public static void main(String[] args)
    {
        //Initialise quatre ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();
 
        //Initialise three graphiques composites
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();
 
        //Composes les graphiques
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);
 
        graphic2.add(ellipse4);
 
        graphic.add(graphic1);
        graphic.add(graphic2);
 
        //Imprime le graphique complet (quatre fois la chaîne "Ellipse").
        graphic.print();
    }
}
```



## 2.2.4  Pont ##

Le pont est un patron de conception qui permet de découpler l'interface d'une classe et son implémentation. Ainsi l'interface et l'implémentation peuvent varier séparément.

Attention, à ne pas confondre ce patron avec l'adaptateur. En effet, l'adaptateur est utilisé pour adapter l'interface d'une classe vers une autre interface (donc pour faire en sorte que l'interface d'une ou plusieurs classes ressemble à l'interface d'une classe en particulier).
Le pont est lui utilisé pour découpler l'interface de l'implémentation. Ainsi, vous pouvez modifier ou changer l'implémentation d'une classe sans devoir modifier le code client (si l'interface ne change pas bien entendu).


## 2.2.5 Facade ##


Unifie et simplie l'interface d'un sous système cohérent et éventuellement autonome. Forme donc un point d'entrée simplifié dans une API.

## 2.3 Patrons de comportement ##


## 2.3.1 Etat ##


La technique de l'État est un patron de conception comportemental utilisé en génie logiciel. Ce patron de conception est utilisé entre autres lorsqu'il est souhaité pouvoir changer le comportement de l'État d'un objet sans pour autant en changer l'instance.
> Principe Général
La classe censée changer d'état a un lien vers une classe abstraite "État". Cette classe abstraite "État" définit les différentes méthodes qui seront à redéfinir dans les implémentations. Dans chaque classe dérivée d'État, l'appel à la méthode X pourra avoir un comportement différent.
La classe pouvant changer d'état appellera les services de sa classe d'état dont l'instance change quand le comportement de notre classe change. De plus l'instance de la classe pouvant changer d'état peut être passée en paramètre à la méthode X de sa classe d'état. Ceci permet de changer l'état de la classe pendant l'exécution de la méthode X en instanciant un nouvel état.
Ce patron permet donc à la classe de passer d'un état à l'autre de telle façon que cette dernière apparaît changer de type dynamiquement (sans changer d'instance).
Exemple : Un programme de dessin utilise une interface abstraite pour représenter un outil. Chaque instance de ses classes dérivées concrètes représente un type d'outil différent. Quand l'utilisateur change d'outil, une nouvelle instance de la classe dérivée associée est créée.



## 2.3.2 Mémento ##


Le patron mémento est un patron de conception qui fournit la manière de renvoyer un objet à un état précédent (retour arrière) sans violer le principe d'encapsulation.
Le mémento est utilisé par deux objets : le créateur et le gardien. Le créateur est un objet ayant un état interne (état à sauvegarder). Le gardien agira sur le créateur, tout en conservant la possibilité de revenir en arrière. Le gardien demande alors au créateur l'objet mémento pour enregistrer son état actuel. Il effectue l'opération (ou séquence d'opérations) souhaitée. Afin de permettre le retour arrière dans l'état d'avant les opérations, le mémento est retourné au créateur. L'objet mémento même est opaque (le gardien ne peut, ou ne devrait pas, le modifier). Lors de l'utilisation de ce patron, une attention toute particulière doit être prise si le créateur modifie d'autres objets ou ressources : Le patron mémento n'opère que sur un seul objet.
Il faut souligner que le fait de sauvegarder l'état interne de l'objet créateur doit s'effectuer sans casser le principe d'encapsulation. Cela n'est pas toujours possible (exemple : SmallTalk ne le permet pas de façon directe).
Des exemples classiques du patron mémento incluent le générateur de nombres pseudo-aléatoires, la machine à états finis, la fonction "Annulation" / "Undo".

Exemple  Java

Cet exemple illustre l'usage du pattern Mémento pour réaliser une commande de type annuler.
```
import java.util.*;
 
class Originator
{
    private String state;
 
    public void set(String state)
    {
        System.out.println("Originator : état affecté à : "+state);
        this.state = state;
    }
 
    public Object saveToMemento()
    {
        System.out.println("Originator : sauvegardé dans le mémento.");
        return new Memento(state);
    }
 
    public void restoreFromMemento(Object m)
    {
        if (m instanceof Memento)
        {
            Memento memento = (Memento)m;
            state = memento.getSavedState();
            System.out.println("Originator : État après restauration : "+state);
        }
    }
 
    private static class Memento
    {
        private String state;
 
        public Memento(String stateToSave) { state = stateToSave; }
        public String getSavedState() { return state; }
    }
}
 
class Caretaker
{
    private ArrayList savedStates = new ArrayList();
 
    public void addMemento(Object m) { savedStates.add(m); }
    public Object getMemento(int index) { return savedStates.get(index); }
}
 
class MementoExample
{
    public static void main(String[] args)
    {
        Caretaker caretaker = new Caretaker();
 
        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        caretaker.addMemento( originator.saveToMemento() );
        originator.set("State3");
        caretaker.addMemento( originator.saveToMemento() );
        originator.set("State4");
 
        originator.restoreFromMemento( caretaker.getMemento(1) );
    }
}
```
Ce programme affiche :
```
Originator : état affecté à : State1
Originator : état affecté à : State2
Originator : sauvegarde dans le memento.
Originator : état affecté à : State3
Originator : sauvegarde dans le memento.
Originator : état affecté à : State4
Originator : État après restauration : State3
```