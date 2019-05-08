import java.util.Stack;
import java.util.HashMap;

/**
 * CLASSE PLAYER, gestion du joueur
 * @author MOLAEI Avesta
 * @version 20.02.2019
 * 
 * 
 */


public class Player{


    private Room aCurrentRoom;
    private Stack<Room> aBackRooms;
    private Room aBackRoom;
    private ItemList aItemList;
    private int aPoidsMax;
    //Attributs

        
    /**
      * Constructeur Player
      */
    public Player(){
        this.aBackRooms = new Stack<Room>();
        this.aItemList = new ItemList();
        this.aPoidsMax=100;
    }
   
    /**
     * Back pour le player
     */
    public void backPlayer(){
        this.aBackRoom = aBackRooms.pop();
        this.aCurrentRoom = aBackRoom;
    }
   
    /**
     * changer la pièce du joueur
     * @param pRoom la nouvelle room
     */
    public void goRoom(final Room pRoom){
        aBackRooms.push(aCurrentRoom);
        aCurrentRoom = pRoom;
        }
    

    /**
     * accesseur de getbackrooms
     */
    public Stack<Room> getBackRooms(){
        return this.aBackRooms;
    }
    
    /**
     * Permet de changer de room et remplace la stack
     */
     public void changeRoom (final Room pNextRoom){
        this.aCurrentRoom = pNextRoom;
    }

    
    /**
     * Retourne la Room du joueur
     */
    public Room getCurrentRoom(){
        return aCurrentRoom;
    }
   
    /**
     * Initialise la Room du joueur
     */
    public void setCurrentRoom(final Room pCurrentRoom){
        this.aCurrentRoom = pCurrentRoom;
    }
     
    /**
     * fonction qui retourne le poids max du joueur
     */
    public int getPoidsMax(){
        return this.aPoidsMax;
    }

    /**
     * vérifier si il est possible de ramasser un item ou non
     * @param pItem l'item
     */
    public boolean check(final Item pItem){
        if(aItemList.totalWeight() + pItem.getItemWeight()<=aPoidsMax){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * obtenir le poids total
     */
    public int getPoidsTotal(){
        return aItemList.totalWeight();
    }

    /**
     * accesseur qui modifie le poids max du joueur
     */
    public void setPoidsMax( final int pPoids){
        this.aPoidsMax += pPoids;
    }
      /**
      * fonctione qui retourne l'itemList
      */
    public ItemList getInventory(){
        return this.aItemList;
    }

    /**
     * procédure pour lacher un item
     */
    public void drop(Item pItem){
        aItemList.removeItem(pItem);
        getCurrentRoom().getItemList().addItem(pItem);
    }

    /**
     * procédure pour prendre un item
     */
    public void take(Item pItem){
        aItemList.addItem(pItem);
        getCurrentRoom().getItemList().removeItem(pItem);

    }

   
} 