import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling (DB edited) + Avesta Molaei
 * @version 1.0 (Jan 2003)
 */
public class UserInterface extends JFrame implements ActionListener 
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton aButton1;
    private JButton aButton2;
    private JButton aButton3;
    private JButton aButton4;
    private JButton aButton5;
    private JButton aButton6;
    private JButton aButton7;
    private JButton aButton8;
    private JButton aButton9;
    private JButton aButton10;
    private JButton aButton11;
    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {


        this.aEngine = pGameEngine;
        this.createGUI();

    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
        aLog.setCaretPosition(aLog.getDocument().getLength());
        
    } // println(.)

    /**
     * Show an image file in the interface.
     */
    public void showImage( final String pImageName )
    {
        URL vImageURL = this.getClass().getClassLoader().getResource( pImageName );
        if ( vImageURL == null )
            System.out.println( "image not found" );
        else { 
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff );
        if ( ! pOnOff )
            this.aEntryField.getCaret().setBlinkRate( 0 );
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        
        this.aMyFrame = new JFrame("Mission CAT!");
        this.aEntryField = new JTextField(12);
        Toolkit vTk = Toolkit.getDefaultToolkit();
        int vXsize = (int) vTk.getScreenSize().getWidth();
        int vYsize = (int) vTk.getScreenSize().getHeight();
        this.aMyFrame.setSize(vXsize, vYsize);
        this.aMyFrame.show();

        JPanel vB1 = new JPanel();
        JPanel vB2 = new JPanel();
        JPanel vB3 = new JPanel();
        vB1.add(aButton1 = new JButton("look"));
        vB1.add(aButton2 = new JButton("heal"));
        vB1.add(aButton3 = new JButton("help"));
        vB1.add(aButton4 = new JButton("quit"));
        vB2.add(aButton5 = new JButton("test"));
        vB2.add(aButton6 = new JButton("test1"));
        vB2.add(aButton7 = new JButton("test2"));
        vB3.add(aButton8 = new JButton("test3")); 
        //Création des boutons

        aButton1.addActionListener(this);
        aButton2.addActionListener(this);
        aButton3.addActionListener(this);
        aButton4.addActionListener(this);
        //action listener pour pouvoir associer des actions
    
        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 400) );
        vListScroller.setMinimumSize( new Dimension(50,50) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        
        vPanel.setLayout( new BorderLayout() );
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(vB1, BorderLayout.EAST);   


    
        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aEntryField.addActionListener( this );

        //this.aMyFrame.pack();
        
        this.aEntryField.requestFocus(); 

    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        
        if(pE.getSource() == aEntryField){
            processCommand();
        }
        if(pE.getSource() == aButton1){
            this.aEngine.interpretCommand("look");
        }
        if(pE.getSource() == aButton2){
            this.aEngine.interpretCommand("heal");
        }
        if(pE.getSource() == aButton3){
            this.aEngine.interpretCommand("help");
        }
        if(pE.getSource() == aButton4){
            this.aEngine.interpretCommand("quit");
        }
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText("");

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
