/*
 * InterfaceServeurApp.java
 */

package interfaceserveur;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import serveurtcp.*;
/**
 * The main class of the application.
 */
public class InterfaceServeurApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new InterfaceServeurView(this));
        // On lance le serveur au début
        TCPServeur serv = new TCPServeur(4242);
        serv.start();
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of InterfaceServeurApp
     */
    public static InterfaceServeurApp getApplication() {
        return Application.getInstance(InterfaceServeurApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(InterfaceServeurApp.class, args);
    }
}
