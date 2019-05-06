import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser 
{
    private CommandWords aValidCommands;  
    // Attributs

    /**
     * Constructeur par defaut qui cree les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
        // System.in designe le clavier, comme System.out designe l'ecran
    }//Parser()

    /**
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine){
        String vWord1 = null;
        String vWord2 = null;

        StringTokenizer tokenizer = new StringTokenizer(pInputLine);

        if(tokenizer.hasMoreTokens()) vWord1 = tokenizer.nextToken();
            else vWord1 = null;

        if(tokenizer.hasMoreTokens()) vWord2 = tokenizer.nextToken();
            else vWord2 = null;

        if(this.aValidCommands.isCommand(vWord1)) return new Command(vWord1, vWord2);
            else return new Command(null, vWord2);

    }//getCommand()

    /**
     * @return une string de toutes les commandes valides
     */
    public String showCommands(){
        return aValidCommands.getCommandList();
    }//showCommands()

} // Parser

