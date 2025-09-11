//import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
/**
 * This class creates the fire breathing dragon and the various features it has
 * @author Anna Wang
 *
 */
public class Dragon {
  private Room currentRoom; //current location of the dragon
  private Random randGen; //random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
  
  /**
   * Constructor for the dragon 
   * @param currentRoom the current room or the room the dragon starts in
   */
  public Dragon(Room currentRoom) {
    this.currentRoom = currentRoom;
    randGen = new Random();
  }
  /**
   * Gets the room the dragon is currently in 
   * @return Room the room the dragon is in
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }
  /**
   * Randomly picks the room the dragon will move to from a list of room(s) that the dragon can be 
   * in and moves it there. 
   * 
   */
  public void changeRooms() {
    ArrayList<Room> nonPortalRooms = new ArrayList<Room>();
    for(int i = 0; i < currentRoom.getAdjacentRooms().size();i++) {
      if(currentRoom.getAdjacentRooms().get(i).getType() != RoomType.PORTAL) {
        nonPortalRooms.add(currentRoom.getAdjacentRooms().get(i));
      }
    }
    int randRoom = randGen.nextInt(nonPortalRooms.size());
    if(nonPortalRooms.get(randRoom).getType() == RoomType.PORTAL ||
        !currentRoom.isAdjacent(nonPortalRooms.get(randRoom))) {
      randRoom = randGen.nextInt(nonPortalRooms.size());
    }
    else{
     currentRoom = nonPortalRooms.get(randRoom);
    }
  }
  /**
   * Gets the dragon warning for when the dragon is nearby
   * @return String a warning that the player hears a fire breathing dragon nearby
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }
}
