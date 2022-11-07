import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 
 * The class Room can be used to derive the building, room number, and the maximum number
 * of people who can be in room at a time. 
 * The class can also reduce the capacity for the room.
 *
 */
public class Room {

  private String location; // the building and room number, e.g. “Noland 168”
  private int capacity; // the maximum number of people who can be in the room at a time

  /**
   * Constructs capacity and location
   * 
   * @param location - the building and room number
   * @param capacity - the maximum number of people who can be in the room at a time
   * @throws IllegalArgumentException when capacity is less than zero
   */
  public Room(String location, int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("capacity exception");
    }
    // Sets capacity and location
    this.capacity = capacity;
    this.location = location;
  }

  /**
   * Get building and room number
   * 
   * @return location
   */
  public String getLocation() {
    // getter method for location
    return this.location;
  }

  /**
   * Get the maximum number of people who can be in the room at a time
   * 
   * @return capacity
   */
  public int getCapacity() {
    // getter method for capacity
    return this.capacity;
  }

  /**
   * Updates the capacity of the room based on the input capacity
   * 
   * @param capacity
   * @return newRoom - new Room Object with same location, but with updated capacity
   * @throws IllegalArgumentException when the input capacity is greater than the maximum number
   *                                  of people who can be in the room at a time
   */
  public Room reduceCapacity(int capacity) {
    // creates new Room object
    Room newRoom = new Room(location, capacity);

    // checks if input capacity is less than the actual Room capacity
    if (capacity > this.capacity) {
      throw new IllegalArgumentException("Arguement is greater than the given Room’s capacity");
    }
    // returns updated Room
    newRoom = new Room(location, this.capacity - capacity);
    return newRoom;
  }
}
