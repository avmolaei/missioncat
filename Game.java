 

/**
 * CLASSE GAME, moteur du jeu
 *
 * @author MOLAEI Avesta
 * @version 22.01.2019
 */

public class Game
{

//-------------------------------------------------------------------------------------//

    /**
     * Attributs
     */
    private Room aCurrentRoom;
    private Parser aParser;
    //Attributs

//-------------------------------------------------------------------------------------//

    /**
     * Constructeur de la classe
     */
    public Game()
    {
        aParser = new Parser();
        createRooms();
    }//Game()

//-------------------------------------------------------------------------------------//

    /**
     * createRooms(), créé les pièces
     */
   private void createRooms()
    {
        Room vEntree = new Room("outside the building, in front of the main entrance");
        Room vCoteEst = new Room("on the west side of the building");
        Room vArriere = new Room("behind the building");
        Room vCour = new Room("in a yard away from the building");
        Room vIntérieur = new Room("entering inside...");
       
        Room vBureauGardes = new Room("in the guards room!");
        Room vStockage1 = new Room(" in a Storage unit");
        Room vLabo1 = new Room("in a chemistery Lab...");
        Room vHangar1 = new Room("in an arsenal. Lots of ammo arround");
        Room vCageEsca1 = new Room("in the stairs to the next floor...");
        
        Room vHall2 = new Room("in a small hall with statues and paintings of Stalin everywhere");
        Room vHangar2 = new Room("in a Hangar with experimental weapons arround...");
        Room vLaboCaché = new Room("... You don't really know. Looks like a secret lab.");
        Room vSalleDeRepos = new Room("IN THE GUARDS LOUNGE!!! Why are you even here?!");
        Room vCageEsca2 = new Room("in the stairs to the next floor...");
        
        Room vBureauStaline = new Room("in Staline's office.");
        Room vSilo = new Room("the missile launch room !");
        Room vFin = new Room("you lead the mission to its succes. The missle launch was aborted, and Staline is now dead. Good job agent.\nYou can now type \"quit\" to leave.");
        //création des Rooms
       
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
   
//-------------------------------------------------------------------------------------//

    /**
     * goRoom, déplacement
     * @param pCommand commande entrée
     */
    private void goRoom(final Command pCommand){
       
        if(!pCommand.hasSecondWord()){
            System.out.println("go where ?") ;
            return;
        }

        
        String vDirection=pCommand.getSecondWord();
        Room vNextRoom = aCurrentRoom.getExit(vDirection);

        if(vNextRoom == null){
            System.out.print("There is no door");
            return;
        }
      
        this.aCurrentRoom=vNextRoom;
        printLocationInfo();
    }//goRoom(.)

//-------------------------------------------------------------------------------------//

    /**
     * procédure message début jeu
     */
    private void printWelcome(){
        System.out.println("----------------------------------------------------");
        System.out.println("Welcome to Mission CAT! (or Counter of Annahilating Threat for short)");
        System.out.println("an incredibly boring adventure game made by Avesta, based on Zuul");        
        System.out.println("Type 'help' if you need help.");
        printLocationInfo();
    }//printWelcome()

//-------------------------------------------------------------------------------------//

    private void printLocationInfo(){

        System.out.println("\\-------------------------------------------//");
        System.out.println("You are " + aCurrentRoom.getDescription());
        System.out.println(aCurrentRoom.getExitString());
    }

//-------------------------------------------------------------------------------------//
    /**
     * procédure aide
     */
    private void printHelp()
    {
        System.out.println("You are the best agent the CIA has. Your misson: abort the missile launch");
        System.out.println("You have been dropped on the site where the missiles are going to be launched from. Find how to abort the launch, and kill Stalin!");
        System.out.println("Your command words are :");
        System.out.println("go quit help");
    }//printHelp()

//-------------------------------------------------------------------------------------//

    /**
     * quitter jeu
     */
    private boolean quit(final Command pCommand)
   {
    if (pCommand.hasSecondWord())
    {
        System.out.println("Quit what ?");
        return  false;
    }
    else
    {
        return true;
    }
   }//quit(final Command pCommand)
   
//-------------------------------------------------------------------------------------//

   /**
    * traitement des commandes
    *@param pCommand commande entrée
    */
   private boolean processCommand (final Command pCommand){
        if (pCommand.isUnknown()){
            System.out.println("I don't know what you mean...");
        }
        else if (pCommand.getCommandWord().equals("go")){
            this.goRoom(pCommand);
        }
        else if (pCommand.getCommandWord().equals("help")){
            printHelp();
        }
        else if (pCommand.getCommandWord().equals("quit")){
            return true;
        }

        return false;
   }//processCommand(final Command pCommand)
  
//-------------------------------------------------------------------------------------//

   /**
    * play(), lancement du jeu
    */
   public void play()
   {
       this.printWelcome();
       boolean vFinished = false; 
       while(!vFinished){
           Command vCommand = this.aParser.getCommand(); 
           vFinished = this.processCommand(vCommand);
       } 
       System.out.println("Thank you for playing. Good bye.");   
    } //play()

//-------------------------------------------------------------------------------------//

}//Game