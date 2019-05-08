
import java.util.*;

/**
 * Permet de gérer la liste d'Item
 * 
 * @author Molaei avesta 
 * @version 2019 Avril
 */
public class ItemList
{
    private Map<String, Item> aItem;
    
    public ItemList()
    {
        this.aItem = new HashMap<String, Item>();
    }

    /**
     * procédure pour vérifier l'inventaire est vide
     */
    public boolean isEmpty(){
        return aItem.isEmpty();
    }

    /**
     * obtenir le poids total
     */
    public int totalWeight(){
        return aItem.values().stream().mapToInt(Item::getItemWeight).sum();
    }

    
    /**
     * méthode pour ajouter un item
     */
    public void addItem(final Item pItem)
    {
         this.aItem.put(pItem.getItemName().toLowerCase(), pItem);
    }
    
    /**
     * procédure pour supprimer un item
     */
    public void removeItem(final Item pItem)
    {
        removeItem(pItem.getItemName());
    }

    /**
     * méthode pour supprimer un item
     */
    public void removeItem(final String pItemname)
    {
        aItem.remove(pItemname.toLowerCase());
    }
    
    /**
     * fonction pour retourner un item
     */
    public Item getItem(final String pItem)
    {
        return aItem.get(pItem.toLowerCase());
    }
    
    /**
     * Retourne une string des Items
     */
    public String getItemString()
    {
        StringBuilder returnString = new StringBuilder("Items: :");
        for (String item : aItem.keySet())
        {
            returnString.append(" "+item);
        }
        
        return returnString.toString();
    }
    

    /**
     * obtenir le message concaténé des items
     */
    public String getStringDesc(){
        StringBuilder vRandom = new StringBuilder();
        for(Item vItemrandom: aItem.values()){
            vRandom.append("\n");
            vRandom.append(vItemrandom.getItemName());
        }
        return vRandom.toString();
    }
}
