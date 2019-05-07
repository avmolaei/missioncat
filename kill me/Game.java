import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 * CLASSE GAME, lance le jeu et initialise la GUI
 * @author Avesta Molaei
 * @version early feb 2019
 */
public class Game{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Constructeur pour l initialisation
     */
    public Game(){

        try { 
            
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
   
        
        } catch (Exception e) {
            System.out.println("Error. It seems something went wrong when we tried to get your OS's Look & Feel. Please try again later.\n");
        }
        aEngine = new GameEngine();
        aGui = new UserInterface(aEngine);
        playMusic("music.wav");
        aEngine.setGUI(aGui);
    }

    /**  
     * procédure pour lancer la musique de fond
     * @param pFilepath emplacement du fichier WAV
     */
    public static void playMusic(String pFilepath){
        InputStream vMusic;
        try{
            vMusic = new FileInputStream(new File(pFilepath));
            AudioStream vAudio = new AudioStream(vMusic);
            AudioPlayer.player.start(vAudio);
        }
        catch(Exception pE){
            JOptionPane.showMessageDialog(null, "Error while playing the audio file\n Please make sure it is named \"music\", is a .WAV file, and is in the same directory than the Game.java class. Also, check line 35 of Game.java if needed.");
        }
    }

}
