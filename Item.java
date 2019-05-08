
/**
 *LA CLASSE ITEM, Gestion des Items
 *
 * @author Avesta MOLAEI
 * @version 14.02.2019
 */
public class Item{
    /**
     * Attributs
     */
    private String aItemName;
    private int aItemWeight;
    //Atributs

    /**
     * constructeur pour l'item
     * @param pItemName nom de l item
     * @param pItemWeight poids de l item
     */
    public Item(final String pItemName, final int pItemWeight){
        this.aItemName = pItemName;
        this.aItemWeight = pItemWeight;
    }//Item(..)

    /**
     * Getter du nom
     */
    public String getItemName(){
        return this.aItemName;
    }//getItemName()

    /**
     * Getter du poids
     */
    public int getItemWeight(){
        return this.aItemWeight;
    }//getItemWeight()
    
    /**
     * Getter de la description
     */
    public String getItemDescription(){
        return getItemName() + " (" + getItemWeight() +" g)";
    }//getItemDescription()

}//Item
