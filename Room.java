/** 
 * LA CLASSE ROOM, Gestion des salles
 * 
 * @author  AVESTA MOLAEI
 * @version 2019.21.30
 */

import java.util.HashMap;
import java.util.Set;



public class Room
{

    /**
     * Atributs
     */
    private String aDescription;
    private HashMap<String, Room> aExits;
    


    /**
     *Constructeur pour la string décrivant la pièce
     *@param pDescription string qui décrit la pièce
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
        aExits = new HashMap<String, Room>();
    }//Room(.)

//-------------------------------------------------------------------------------------//
    
    /**
     *getter, acceseur de la description 
     */
    public String getDescription(){
        return aDescription;
    }//getDescription()

//-------------------------------------------------------------------------------------// 

    /**
     *setter, modificateur pour les sorties 
     */
    public void setExits(final Room pNorthExit, final Room pEastExit, final Room pSouthExit, final Room pWestExit, final Room pUpExit){
        if(pNorthExit != null) aExits.put("North", pNorthExit);
        if(pEastExit != null) aExits.put("East", pEastExit);
        if(pSouthExit != null) aExits.put("South", pSouthExit);
        if(pWestExit != null) aExits.put("West", pWestExit);
        if(pUpExit != null) aExits.put("Up", pUpExit);

    }//setExit(....)


    public void setExit(String pDirection, Room pVoisin){
        aExits.put(pDirection, pVoisin);
    }


//-------------------------------------------------------------------------------------// 

    public Room getExit(String pDirection){
    return aExits.get(pDirection);
}


    public String getExitString(){
        String vStr = new String("Exits: ");
        Set<String> vKeys = aExits.keySet();
        for(String aExit : vKeys){
            vStr += " \n"+aExit;
        }
        vStr +="\n";
        return vStr;
    }



//-------------------------------------------------------------------------------------//



} // Room

//-------------------------------------------------------------------------------------// 
