import java.util.ArrayList;
/**
 * Class to represent a character
 *
 */
public class Character {
  private Room currentRoom; //current room the character is in
  private String label; //a label giving a basic description of the character
  
  /**
   * Constructor for a Character object. Initializes all instance fields.
   * @param currentRoom the room that the Character is located in
   * @param label a descriptive label of this Character
   * @throws IllegalArgumentException if current room is null
   */
  public Character(Room currentRoom, String label) {
    //check if the current room is null or not
    if(currentRoom == null) {
      throw new IllegalArgumentException("The current room can not be null");
    }
    this.currentRoom = currentRoom;
    this.label = label;
  }
  /**
   * Getter for the current room of this Character.
   * @return the room where the character is
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }
  /**
   * Getter for the label of this Character.
   * @return this Character's descriptive label
   */
  public String getLabel() {
    return label;
  }
  /**
   * Gets the list of rooms adjacent to this Character.
   * @return an ArrayList of rooms adjacent to this character
   */
  public ArrayList<Room> getAdjacentRooms(){
    return currentRoom.getAdjacentRooms();
  }
  /**
   * Sets the current room to the one given.
   * @param newRoom the room that should become the current room
   */
  public void setCurrentRoom(Room newRoom) {
    currentRoom = newRoom;
  }


}
