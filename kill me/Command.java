/**
 * LA CLASSE COMMANDE, Traitement des commandes textuelles
 * 
 * @author AVESTA MOLAEI
 * @version 2019.21.30
 */

public class Command
{
    /**
     * Attributs
     */
    private String aCommandWord;
    private String aSecondWord;
    //Attributs

    /**
     * Constructeur naturel de la classe
     * @param pCommandWord mot de commande aka premier mot
     * @param pSecondWord mot de description aka deuxieme mot
     */
    public Command(final String pCommandWord, final String pSecondWord){
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }//Command(..)

    /**
     * GETTERS
     */
    public String getCommandWord(){
        return this.aCommandWord;
    }//getCommandWord()
     
    public String getSecondWord(){
        return this.aSecondWord;
    }//getSecondWord()

    /**
     * vérifie si la string a bien un second terme
     */
    public boolean hasSecondWord(){
        return(this.aSecondWord != null);
    }//hasSecondWord()

    /**
     * vérifie si le terme de commande n'est pas nulle
     */
    public boolean isUnknown(){
        return(this.aCommandWord == null);
    }//isUnknown()

}//Command