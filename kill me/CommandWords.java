import java.util.HashMap;

import java.util.Set;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau + A.Molaei
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    /**
     * Tableau contenant les mots valides
     */
    private static final String[] sValidCommands = {
        "go", "quit", "help", "look", "heal", "back", "test" , "inventory", "take", "drop", "eat"
    }; //sValideCommands

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        // rien a faire pour le moment...
    } // CommandWords()

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand(final String pString){
        for(int i=0; i<sValidCommands.length; i++){
            if(sValidCommands[i].equals( pString)) return true;
        }
        return false;
    } // isCommand()

    /**
     * Affiche toutes les commandes valides
     */
    public String getCommandList(){
        StringBuilder vCommands = new StringBuilder();
        for(String vCommand : sValidCommands) {
            vCommands.append(vCommand + " ");
        }
        return vCommands.toString();
    }//getCommandList()
    
}//CommandWord