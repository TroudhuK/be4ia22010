
package network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Aurelien Mariage
 */
public class ReceptionFichierServeur extends Thread {

    private ServerSocket ss;
    private gui.IHM main;
    private String path="";
    private ctrl.Controleur ctrl;

    /**
     * Constructeur de la classe ReceptionFichierServeur
     * @param port Port d'ecoute du serveur
     * @param m La fenetre du programme
     */
    public ReceptionFichierServeur(int port, gui.IHM m) {
        try {
            main = m;
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ReceptionFichierServeur(int port, ctrl.Controleur ctrl, String path) {
        try {        	
            main = null;
            this.ctrl=ctrl;
            this.path = path;
            
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Méthode définissant le comportement du Thread.
     */
    public void run() {
        try {
            System.out.println("Serveur de fichier en attente");
            while (true) {
                // lorsqu'un client se connecte, on crée un objet ReceptionFichierClientThread afin de rendre le serveur MultiClient
                ReceptionFichierClientThread tmp = new ReceptionFichierClientThread(ss.accept(), main, ctrl, path);
                System.out.println("Un client est connecte au serveur de fichier");
                tmp.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
