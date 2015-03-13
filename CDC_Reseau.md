# Introduction #
Ce cookbook a pour vocation de vous expliquer les bases du réseau en CDC.
Les pré-requis sont bien sur d'avoir déjà fait du JAVA et surtout d'avoir déjà manipulé les classes Socket, ServerSocket et autres joyeusetés.

# Details #

  * Rappel sur les modes connecté et non connecté
  * Exemple d'un échange entre un terminal mobile et un serveur d'echo

## Rappel ##

_Mode connecté_ : un canal de communication est établi entre les différentes entités participant à la communication. Ce mécanisme garanti qu'un message placé dans le canal arrivera vers à son destinataire. Cependant l'établissement et le maintient du dit canal entraine un coût supplémentaire (mécanisme de connexion, en-tête supplémentaire, mécanisme de détection d'erreur, ...).

Protocole phare : **TCP**

_Mode non connecté_ : au contraire du mode connecté, le mode non connecté n'offre aucune garantie de fiabilité. Il est cependant plus léger à mettre en œuvre.

Protocole phare: **UDP**

## Exemple ##

L'exemple qui suit utilise un serveur d'écho réalisé en J2SE, ce serveur ne fait que renvoyer un message qu'il reçoit en le précédant de la chaine " (echo) - ". Le client est est écrit pour être exécuté sur un terminal mobile (en utilisation la configuration CDC).

Le protocole utilisé est TCP.

**Serveur** - Classe TCPServeur:
```
import java.io.IOException;
import java.net.ServerSocket;

public class TCPServeur extends Thread{

    private ServerSocket ss;
    private int port;

    public TCPServeur(int port){
        try {
            this.port = port
            ss = new ServerSocket(this.port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run(){
         try{
             System.out.println("Serveur TCP en attente sur le port "+port);
            while (true){
                TCPThread tmp = new TCPThread( ss.accept());
                System.out.println("Un client est connecte");
                tmp.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
```
**Serveur** - Classe TCPThread:
```
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPThread extends Thread {

    private Socket soc;
    private int num;
    private String echo;

    public TCPThread(Socket soc) {
        this.soc = soc;
    }

    public void run() {
        try {
            byte[] octets = new byte[1024];

            BufferedInputStream in = new BufferedInputStream(soc.getInputStream());
            OutputStream outFichier = new BufferedOutputStream(soc.getOutputStream());
            
            num = in.read(octets, 0, 1024);
            System.out.println("Reçu: "+new String(octets).trim());

            echo = "(echo) - "+new String(octets).trim();
            
            outFichier.write(echo.getBytes(), 0, echo.getBytes().length);
            outFichier.flush();

            System.out.println("Fin de reception");
        }
        catch (SocketException se){
            System.out.println("Connexion resetee par le client: "+se);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Client** - Classe TCPClient:
```
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    private int port;
    private String host;

    private Socket soc;
    private OutputStream os;
    private InputStream is;

    private byte[] sReaded;

    public TCPClient(int port, String host){
        this.port = port;
        this.host = host;

        sReaded = new byte[512];

        try {
            soc = new Socket(host, port);
            os = new BufferedOutputStream(soc.getOutputStream());
            is = new BufferedInputStream(soc.getInputStream());

            os.write("phrase du client".getBytes());
            os.flush();

            is.read(sReaded);

            System.out.println("Reception: "+new String(sReaded).trim());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

## Conclusion ##

Comme vous avez pu le constater au travers de cet exemple, il n'y a pas de différence entre l'utilisation des classes orientées réseaux de J2SE et J2ME.