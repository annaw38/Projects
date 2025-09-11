import processing.core.PImage;
/**
 * Class to represent the treasure room
 *
 */
public class TreasureRoom extends Room {
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
  private static PImage treasureBackground; //the image ALWAYS used for treasure rooms
  /**
   * Constructor for the treasure room object. 
   * @param ID the ID to give this treasure room
   */
  public TreasureRoom(int ID){
    super(ID, "In the back of this room, you spot a treasure chest. It is locked...",
        treasureBackground);
  }
  /**
   * Getter for TREASURE_WARNING
   * @return the string for warning about treasure being nearby
   */
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }
  /**
   * Sets the background image for the TreasureRoom class.
   * @param treasureBackground the image to be the background
   */
  public static void setTreasureBackground(processing.core.PImage treasureBackground) {
    TreasureRoom.treasureBackground = treasureBackground;
  }
  /**
   * Determines whether or not the player can open the treasure chest in the room
   * @param p the player to check if they can open the chest
   * @return true if the player has the key and is in this TreasureRoom, false otherwise
   */
  public boolean playerCanGrabTreasure(Player p) {
    //if player has the key and is in a treasure room 
    if(p.hasKey() == true && p.getCurrentRoom() instanceof TreasureRoom == true) {
      return true;
    }
    return false;
  }
}
