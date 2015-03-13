Voici 3 codes pour lire un .wav à tester sur mobile.

```
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class AudioPlayer {

    private static final int EXTERNAL_BUFFER_SIZE = 128000;

    public static void main(String[] args) {

        /* Chemin du fichier à lire */
        String strFilepath = new String("donnees/pho_wav/phrase");
        File soundFile = new File(strFilepath + ".wav");

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        AudioFormat audioFormat = audioInputStream.getFormat();

        SourceDataLine line = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                audioFormat);
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        line.start();

        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                int nBytesWritten = line.write(abData, 0, nBytesRead);
            }
        }

        line.drain();

        line.close();

        System.exit(0);
    }

    private static void out(String strMessage) {
        System.out.println(strMessage);
    }
}

```

---

```
import java.io.InputStream;

import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;


public class AudioPlayer
        extends MIDlet
        implements CommandListener, Runnable {

    private Display mDisplay;
    private List mMainScreen;

    public void startApp() {
        mDisplay = Display.getDisplay(this);

        if (mMainScreen == null) {
            mMainScreen = new List("AudioPlayer", List.IMPLICIT);
            mMainScreen.append("From resource", null);
            mMainScreen.addCommand(new Command("Exit", Command.EXIT, 0));
            mMainScreen.addCommand(new Command("Play", Command.SCREEN, 0));
            mMainScreen.setCommandListener(this);
        }

        mDisplay.setCurrent(mMainScreen);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
        if (c.getCommandType() == Command.EXIT) {
            notifyDestroyed();
        } else {
            Form waitForm = new Form("Loading...");
            mDisplay.setCurrent(waitForm);
            Thread t = new Thread(this);
            t.start();
        }
    }

    public void run() {
        try {
            InputStream in = getClass().getResourceAsStream("/donnees/pho_wav/phrase.wav");
            Player player = Manager.createPlayer(in, "audio/x-wav");
            player.start();
        } catch (Exception e) {
            showException(e);
            return;
        }
        mDisplay.setCurrent(mMainScreen);
    }

    private void showException(Exception e) {
        Alert a = new Alert("Exception", e.toString(), null, null);
        a.setTimeout(Alert.FOREVER);
        mDisplay.setCurrent(a, mMainScreen);
    }
}

```

---

```
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.media.*;

public class AudioPlayer {

    public static void main(String[] args) {

        try {
            InputStream in = InputStream.class.getResourceAsStream("donnees/pho_wav/phrase.wav");
            Player p = Manager.createPlayer(in, "audio/x-wav");
            p.start();
        } catch (MediaException me) {
            me.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

```