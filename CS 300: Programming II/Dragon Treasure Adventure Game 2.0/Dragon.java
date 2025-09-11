import java.util.ArrayList;
import java.util.Random;
/**
 * Class to represent a dragon
 */
public class Dragon extends Character implements Moveable {
  private Random randGen; //random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
  private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire" +
  " breathing dragon!\n";
  /**
   * Constructor for a Dragon object. Initializes all instance fields. 
   * @param currentRoom the room that the Dragon starts in
   * @throws IllegalArgumentException if currentRoom is not a TreasureRoom
   */
  public Dragon(Room currentRoom) throws IllegalArgumentException{
    super(currentRoom, "DRAGON");
    randGen = new Random();
    //check if the current room is a treasure room
    if(!(getCurrentRoom() instanceof TreasureRoom)) {
      throw new IllegalArgumentException("The current room is not a treasure room.");
    }
  }
  /**
   * Moves the Dragon to the destination room.
   * @param destination the Room to change the dragon to
   * @return true if the change was successful, false otherwise
   */
  @Override
  public boolean changeRoom(Room destination) {
    //call the canMoveTo method to check if the dragon can move to the destination
    if(canMoveTo(destination) == true) {
      super.setCurrentRoom(destination);
      //check if the dragon actually changed rooms
      if(super.getCurrentRoom().equals(destination)) {
        return true;
      }
    }
    return false;
  }
  /**
   * Checks if the dragon can move to the given destination.
   * @param destination the room to check if the dragon can move towards
   * @return true if they can, false otherwise
   */
  @Override
  public boolean canMoveTo(Room destination) {
    //checks if the destination is a portal room not adjacent to the current room
    if(!(destination instanceof PortalRoom) && super.getAdjacentRooms().contains(destination)) {
      return true;
    }
    return false;
  }
  /**
   * Randomly picks an adjacent room for the dragon to move into
   * @return the room that this Dragon should try to move into
   */
  public Room pickRoom() {
    //create a new arraylist for the current room's adjacent rooms
    ArrayList<Room> adjRooms = getCurrentRoom().getAdjacentRooms();
    //the index of the destination
    int randInt = randGen.nextInt(adjRooms.size());
    return adjRooms.get(randInt);
  }
  /**
   * Getter for DRAGON_WARNING.
   * @return the string for warning about a dragon being nearby
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }
  /**
   * Getter for DRAGON_ENCOUNTER.
   * @return the string for letting the player know they ran into the dragon.
   */
  public static String getDragonEncounter() {
    return DRAGON_ENCOUNTER;
  }
  
  
}
