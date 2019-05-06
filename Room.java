/** 
 * LA CLASSE ROOM, Gestion des salles
 * 
 * @author  AVESTA MOLAEI
 * @version 2019.21.30
 */

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Room
{
    /**
     * Attributs
     */
    private String aName;
    private String aDescription;
    private String aImageName;
    private HashMap<String, Room> aExits;
    private ItemList aItemList;       
    //Attributs

    /**
     *Constructeur pour la string décrivant la pièce
     *@param pDescription string qui décrit la pièce
     *@param pImage nom de l'image
     */
    public Room(String pName, final String pDescription, final String pImage){
        this.aName = pName;
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aImageName = pImage;
        this.aItemList = new ItemList();
    }//Room(..)

    /**
     * Mettre en place les sorties avec la table de hashage
     * @param pDirection nord sud est ou ouest
     * @param pVoisin rooms avoisinantes
     */
    public void setExit(String pDirection, Room pVoisin){                                                                                                                                                                                                                                                                                                                                                             
        this.aExits.put(pDirection, pVoisin);
    }//setExit(..)

    /**
     * getter pour les sorties
     * @param pDirection direction (nsew)
     */
    public Room getExit(String pDirection){
        return aExits.get(pDirection);
    }//getExit(.)

    /**
     * Obtenir les sorties dispo sous forme d'une seule string concaténée
     */
    public String getExitString(){
        String vStr = new String("Exits: ");
        Set<String> vKeys = aExits.keySet();    
        for(String aExit : vKeys){
            vStr += " \n"+aExit;
        }
        vStr +="\n";
        return vStr;
    }//getExitString()

    /**
     * Obtenir le liste des items sous forme d'une seule string concaténée
     *//*
    public String getItemsString(){
        String vStr = new String("");
        Set<String> vKeys = aItems.keySet();
        if(aItems == null){
            return "nothing";
        }
        else{
        for(String aItems: vKeys){
            vStr += " " + aItems;
        }
        vStr +=" ";
        return vStr;
    }
    }*/

    /**
     * Getter du Nom 
     */
    public String getName(){
        return aName;
    }

    /**
     *getter, acceseur de la description 
     */
    public String getDescription(){
        return aDescription;
    }//getDescription()

    /**     
     * Retourner une version plus longue de la description de la room
     */
    public String getLongDescription(){

        StringBuilder vInter = new StringBuilder("You are "+this.getDescription()+"\n"+this.getExitString());
        if(this.aItemList.isEmpty()){
            vInter.append("\nThere are no items here...");
        }
        else{
            vInter.append("\nItems: ");
            vInter.append(aItemList.getStringDesc());
        }
        return vInter.toString();
        
    }//getLongDescription()

    /**
     * getter pour les noms d image
     */
    public String getImageName(){
        return this.aImageName;
    }//getImageName()   

    /**
     * getter pour l item
     * @param pItemName nom de l item
     */
    public Item getItem(final String pItemName){
        return aItemList.getItem(pItemName);
    }//getItem(.)

    /**
     * getter pour la liste d items
     */
    public ItemList getItemList(){
        return aItemList;
    }
}

 // Room
