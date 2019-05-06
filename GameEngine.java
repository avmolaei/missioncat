import java.util.*;
import java.io.*;

/** 
 * CLASSE GAME ENGINE, Moteur du jeu
 *
 * @author MOLAEI Avesta
 * @version 22.01.2019
 */
public class GameEngine
{
    /**
     * Attributs
     */
    private Parser aParser;
    private Map<String, Room> aRooms;
    private UserInterface aGui;
    private Room aCurrentRoom;
    private Room aBackRoom;
    private Stack<Room> aBackRooms;
    private Player aPlayer;
    //Attributs



    /**
     * Constructeur de la classe
     */
    public GameEngine(){
        aParser = new Parser();
        createRooms();
        this.aBackRooms= new Stack<Room>();
        this.aPlayer = new Player();

    }//Game()

    /**
     * Initialisation de l'IHM
     * @param pUserInterface la GUI
     */
    public void setGUI(UserInterface pUserInterface){
        aGui = pUserInterface;
        printWelcome();
    }//setGUI(.)

    /**
     * createRooms(), créé les pièces
     */
    private void createRooms(){
        aRooms = new HashMap<String, Room>();
        
        this.aBackRooms = new Stack<Room>();
        Room vEntree = new Room("start","outside the building, in front of the main entrance", "img/entree v2.gif");
        Room vCoteEst = new Room("east side", "on the west side of the building", "img/cote est v2.gif");
        Room vArriere = new Room("back yard", "behind the building", "img/Arriere v2.gif");
        Room vCour = new Room("forest", "in a yard away from the building", "img/cour intérieure v2.gif");
        Room vIntérieur = new Room("inside", "entering inside...", "img/Interieur v2.gif");
       
        Room vBureauGardes = new Room("guards office", "in the guards room!", "img/bureau gardes v2.gif");
        Room vStockage1 = new Room("storage unit", " in a Storage unit", "img/Stockage v2.gif");
        Room vLabo1 = new Room("lab", "in a chemistery Lab...", "img/labo1 v2.gif");
        Room vHangar1 = new Room("arsenal", "in an arsenal. Lots of ammo arround", "img/hangar1 v2.gif");
        Room vCageEsca1 = new Room("staircase", "in the stairs to the next floor...", "img/cage esca v2.gif");
        
        Room vHall2 = new Room("hallway", "in a small hall with statues and paintings of Stalin everywhere", "img/hall2 V2.gif");
        Room vHangar2 = new Room("arsenal", "in a Hangar with experimental weapons arround...", "img/hangar2 v2.gif");
        Room vLaboCaché = new Room("???", "... You don't really know. Looks like a secret lab.", "img/labo caché v2.gif");
        Room vSalleDeRepos = new Room("Lounge", "IN THE GUARDS LOUNGE!!! Why are you even here?!", "img/repos garde v2.gif");
        Room vCageEsca2 = new Room("Staircase", "in the stairs to the next floor...", "img/cage esca v2.gif");
        
        Room vBureauStaline = new Room("Staline's office", "in Staline's office.", "img/Bureau staline v2.gif");
        Room vSilo = new Room("launch room", "the missile launch room !", "img/missile launch room v2.gif");
        Room vFin = new Room("end", "you lead the mission to its succes. The missle launch was aborted, and Staline is now dead. Good job agent.\nYou can now type \"quit\" to leave.", "img/fin.gif");
        //création des Rooms


        aRooms.put("Outside", vEntree);
        aRooms.put("West Side", vCoteEst);
        aRooms.put("Back", vArriere);
        aRooms.put("Yard", vCour);
        aRooms.put("Inside, first floor", vIntérieur);

        aRooms.put("Guards room", vBureauGardes);
        aRooms.put("Storage room", vStockage1);
        aRooms.put("Weapons Lab", vLabo1);
        aRooms.put("Hangar bay", vHangar1);
        aRooms.put("Staircase to the 2nd floor", vCageEsca1);

        aRooms.put("Hall", vHall2);
        aRooms.put("Another Hangar bay", vHangar2);
        aRooms.put("A hidden lab?", vLaboCaché);
        aRooms.put("Guards lounge", vSalleDeRepos);
        aRooms.put("Staircase to the next floor", vCageEsca2);

        aRooms.put("Staline's office.", vBureauStaline);
        aRooms.put("The missile launch room", vSilo);
        aRooms.put("THE END", vFin);
        //exo 7.18.5

        Item vCiga = new Item("Cigarettes", 5);
        Item vAmm1 = new Item(".45mm ammo (x10)", 10);
        Item vTool = new Item("LockPicking tools", 10);
        Item vAmm2 = new Item("5.56mm ammo (x200)", 20);
        Item vM249 = new Item("M249", 200);
        Item vKey1 = new Item("Key Card", 1);
        Item vMedK = new Item("Band-aids",5);
        Item vKey2 = new Item("Key Card", 1);
        Item vKeyS = new Item("Stalin's KeyCard", 1);
        Item vWP    = new Item("A white powder... Could it be?", 1);
        //Créé les items

        vEntree.getItemList().addItem(vCiga);
        vCoteEst.getItemList().addItem(vTool);
        vArriere.getItemList().addItem(vAmm1);
        vStockage1.getItemList().addItem(vAmm2);
        vBureauGardes.getItemList().addItem(vM249);
        vLabo1.getItemList().addItem(vMedK);
        vHangar2.getItemList().addItem(vKey2);
        vBureauStaline.getItemList().addItem(vKeyS);
        vBureauGardes.getItemList().addItem(vWP);
        //Placer les items

        

 
        vEntree.setExit("north", vCoteEst);
        vCoteEst.setExit("north", vArriere);
        vCoteEst.setExit("south", vEntree);
        vCoteEst.setExit("west", vIntérieur);
        vArriere.setExit("south", vCoteEst);
        vArriere.setExit("west", vCour);
        vCour.setExit("east", vArriere);
        vIntérieur.setExit("up", vBureauGardes);
        vBureauGardes.setExit("north", vStockage1);
        vBureauGardes.setExit("east", vLabo1);
        vStockage1.setExit(("south"), vBureauGardes);
        vLabo1.setExit("east", vHangar1);
        vLabo1.setExit("west", vBureauGardes); 
        vHangar1.setExit("east", vCageEsca1);
        vHangar1.setExit("west", vLabo1);
        vCageEsca1.setExit("up", vHall2);
        vHall2.setExit("east", vHangar2); 
        vHangar2.setExit("north", vLaboCaché);
        vHangar2.setExit("east", vSalleDeRepos);
        vHangar2.setExit("south", vCageEsca2);
        vHangar2.setExit("west", vHall2);
        vSalleDeRepos.setExit("west", vHangar2);
        vLaboCaché.setExit("south", vHangar2);
        vCageEsca2.setExit("up", vBureauStaline);    
        vBureauStaline.setExit("east", vSilo);    
        vSilo.setExit("up", vFin);
        //positionnement des sorties
       
        this.aCurrentRoom = vEntree;
    } //createRooms()  

    /**
     * Intérpréter les commandes
     * @param pCommandLine commande entrée
     */

    public void interpretCommand(String pCommandLine){
        aGui.println("\t> " +pCommandLine);
        Command vCommand = aParser.getCommand(pCommandLine);

        if(vCommand.isUnknown()) {
            aGui.println("I don't know what you mean...\n");
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        
        if(vCommandWord.equals("help"))         
            printHelp();
        else if(vCommandWord.equals("go"))      
            goRoom(vCommand);
        else if(vCommandWord.equals("look"))    
            look();
        else if(vCommandWord.equals("test"))
            test(vCommand);
        else if(vCommandWord.equals("back"))
            back();
        else if(vCommandWord.equals("heal"))    
            aGui.println("you used a medkit you had");
        else if(vCommandWord.equals("inventory"))
            this.inventory();
        else if(vCommandWord.equals("take"))
            this.take(vCommand);
        else if(vCommandWord.equals("drop"))
            this.drop(vCommand);
        else if(vCommandWord.equals("eat"))
            eat(vCommand);
        else if(vCommandWord.equals("quit")) {
            if(vCommand.hasSecondWord())        
                aGui.println("Quit what?\n");
            else                                 
                endGame();
        }
    }//interpretCommand(.)

    /**Procédure chargant les fichiers de test
     * @param pCommand nom du fichier
     */
    private void test(final Command pCommand){
        if(!(pCommand.hasSecondWord())){
            aGui.println("Enter the test file name ( /!\\ make sure it is a .txt file, do not write the extension)...");
            return;
        }
        String vFileName = pCommand.getSecondWord();
        vFileName = vFileName + ". ";

        try{
            Scanner vScan = new Scanner(this.getClass().getResourceAsStream(vFileName));
            while(vScan.hasNextLine()){
                String vLine = vScan.nextLine();
                interpretCommand(vLine);
            }
        }catch(NullPointerException pE){
            aGui.println("Cannot read file");
        }
    }

    /**
     * procédure permettant de gérer l'action manger
     * @param pCommand la commande entrée
     */
    private void eat(final Command pCommand){
        if(pCommand.hasSecondWord()){
            Item vItem = aPlayer.getInventory().getItem(pCommand.getSecondWord());
            if(vItem!=null){
                if(vItem.getItemName().equals("vWP")){
                    aPlayer.setPoidsMax(200);
                    aPlayer.getInventory().removeItem(vItem);
                    aGui.println("You ate the white powder. You feel a lot stronger");
                }
                else{
                    aGui.println("You can't eat that\n");
                }
            }
            else{
                aGui.println("the said item is not in your inventory...\n");
            }
        }
        else{
            aGui.println("What do you want to eat?\n");
        }
    }
    
    /**
     * goRoom, déplacement
     * @param pCommand commande entrée
     */
    private void goRoom(final Command pCommand){
        if(!pCommand.hasSecondWord()){
            aGui.println("Where do you want to go?\n") ;
            return;
        }

        String vDirection=pCommand.getSecondWord();
        Room vNextRoom = aCurrentRoom.getExit(vDirection);

        if(vNextRoom == null){
            aGui.print("There is no door\n");
            return;
        }
        else{
        

            this.aBackRooms.push(this.aCurrentRoom);
            this.aCurrentRoom = vNextRoom;
            aGui.println(this.aCurrentRoom.getLongDescription());
            aGui.showImage(this.aCurrentRoom.getImageName());
        }
    }//goRoom(.)

    /**
     *Afficher la LongDescription si look est appellée 
     */
    private void look(){
        aGui.println(aCurrentRoom.getLongDescription());
    }//look()

    /**
     * Procédure permettant de retourner dans la room précédente
     */
    private void back(){

        if(!(this.aBackRooms.empty())){
            this.aBackRoom = aBackRooms.pop();
            this.aCurrentRoom = aBackRoom;
            aGui.showImage(this.aCurrentRoom.getImageName());
            look();
        }  
        else{
            aGui.println("You can't go any further back.\n");
        }
    }

    /**
     * Procédure permettant de prendre un item
     * @param pCommand La commande entrée
     */
    public void take(Command pCommand){
        if(pCommand.hasSecondWord()){
            Item vItem = aPlayer.getInventory().getItem(pCommand.getSecondWord());
            if(vItem != null){
                if(aPlayer.check(vItem)){
                    aPlayer.take(vItem);
                    aGui.println("You picked up: " + vItem.getItemName());
            }
            else{
                aGui.println("You don't have enough room to carry this item");
            }
        }
        else{
                aGui.println("" + pCommand.getSecondWord() + "is not an item");
            }
        }
        else{
            aGui.println("What do you want to take?\n");
        }
    }
    
    /**
     * procédure pour lacher un item
     * @param pCommand la commande entrée
     */
    public void drop(Command pCommand){
          if (pCommand.hasSecondWord()) {
            Item vItem = aPlayer.getInventory().getItem(pCommand.getSecondWord());
            if (vItem != null) {
                aPlayer.drop(vItem);
                aGui.println("You dropped " + vItem.getItemName());
            } else {
                aGui.println("You don't have " + pCommand.getSecondWord());
            }
        } else {
            if (aPlayer.getInventory().isEmpty()) {
                aGui.println("You don't have anything to drop.");
            } else {
                StringBuilder vSB = new StringBuilder("Drop what? ");
                vSB.append(aPlayer.getInventory().getStringDesc());
                aGui.println(vSB.toString());
            }
        }
    }

    /**
     * Gestion de l'inventaire
     */
    private void inventory(){
        if(!aPlayer.getInventory().isEmpty()){
            StringBuilder vString = new StringBuilder("Inventory: ");
            vString.append(aPlayer.getInventory().getStringDesc());
            vString.append(aPlayer.getPoidsMax());
            vString.append("-");
            vString.append(aPlayer.getPoidsMax());
            aGui.println(vString.toString());
        }
        else{
            aGui.println("Your inventory is empty");
        }
    }

    /**
     * procédure afficant message début jeu
     */
    private void printWelcome(){
        aGui.println("----------------------------------------------------");
        aGui.println("Welcome to Mission CAT! (or Counter of Annahilating Threat for short)");
        aGui.println("an incredibly boring adventure game made by Avesta, based on Zuul");     
        aGui.println("Your goal: abort the missile launch!!!");   
        aGui.println("Type 'help' if you need help.");
        aGui.println("GL HF!!\n\n");
        this.aCurrentRoom.getLongDescription();
        aGui.showImage(this.aCurrentRoom.getImageName());
    }//printWelcome()

    /**
     * Afficher la string de description d'un lieu + les sorties dispo + l image
     */
    private void printLocationInfo(){
        aGui.println(this.aCurrentRoom.getLongDescription());
        aGui.showImage(this.aCurrentRoom.getImageName());
    }//printLocationInfo()

    /**
     * procédure aide
     */
    private void printHelp(){
        aGui.println("You are the best agent the CIA has. Your misson: abort the missile launch");
        aGui.println("You have been dropped on the site where the missiles are going to be launched from. Find how to abort the launch, and kill Stalin!");
        aGui.println("Your command words are :");
        aGui.println(aParser.showCommands());
        aGui.println("\n\n");
    }//printHelp()

    /**
     * Méthode qui taskill le jeu si quit est entré
     */
    private void endGame(){
        aGui.println("Thank you for playing. Good bye!");
        aGui.enable(false);  
    }//endGame()
  
}//GameEngine{}   