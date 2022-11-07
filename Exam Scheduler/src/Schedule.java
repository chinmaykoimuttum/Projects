import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 
 * The class Schedule derives the number of rooms available 
 * and courses in the schedule, checks if
 * courses have been assigned at given indexes, 
 * and ensures whether the courses have been assigned
 * to rooms.
 * 
 */
public class Schedule {

  private Room[] rooms; // an array of the Room objects available for exams
  private Course[] courses; // an array of the Course objects which require exam rooms
  private int[] assignments;
  // array where the integer at index N is index of room that course[N] has been assigned to


  /**
   * Constructs rooms array, courses array, and assignments array
   * 
   * @param rooms   - array of Room objects available for exams
   * @param courses - array of the Course objects which require exam rooms
   */
  public Schedule(Room[] rooms, Course[] courses) {

    // Initializes rooms and courses and assignments
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];

    // set assignment array values to -1
    for (int i = 0; i < courses.length; i++) {
      assignments[i] = -1;
    }

  }

  /**
   * Constructs rooms array, courses array, and assignments array
   * 
   * @param rooms       - array of Room objects available for exams
   * @param courses     - array of the Course objects which require exam rooms
   * @param assignments - an array where the integer at index N is the index of the room that
   *                    course[N] has been assigned to
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {

    // Initializes rooms and courses and assignments
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;

  }

  /**
   * Gets the number of rooms available in this schedule
   * 
   * @return rooms.length - the number of rooms available in this schedule
   */
  public int getNumRooms() {
    // gets rooms.length
    return this.rooms.length;
  }

  /**
   * Gets the Room object at the given index in the rooms array
   * 
   * @param index - specific given index for rooms array
   * @return rooms[index] - Room object at the given index in the rooms array
   * @throws IndexOutOfBoundsException when index is invalid
   */
  public Room getRoom(int index) { //
    // checks whether given index is invalid
    if (index > rooms.length - 1 || index < 0) {
      throw new IndexOutOfBoundsException("rooms index is out of order ");
    }
    return rooms[index];
  }

  /**
   * Gets the number of courses in this schedule
   * 
   * @return courses.length - number of courses in this schedule
   */
  public int getNumCourses() {
    // gets courses.length
    return courses.length;
  }

  /**
   * returns the Course object at the given index in the courses array
   * 
   * @param index - specific given index for courses array
   * @return courses[index] - the Course object at the given index in the courses array
   * @throws IndexOutOfBoundsException when index is invalid
   */
  public Course getCourse(int index) {
    // checks to make sure given index is not invalid
    if (index > courses.length - 1 || index < 0) {
      throw new IndexOutOfBoundsException("courses index is out of order ");
    }
    return courses[index];
  }

  /**
   * checks if course at the given index has been assigned or not
   * 
   * @param index - checks specific index whether course is assigned room or not
   * @return true if the course at the given index has been assigned a room
   */
  public boolean isAssigned(int index) {

    // checks whether course at the given index has been assigned a room
    if (assignments[index] == -1 || index < 0) {
      return false;
    }
    return true;

  }

  /**
   * Get the Room object assigned to the course at the given index
   * 
   * @param index - specific input index
   * @return Room object assigned to the course at the given index
   * @throws IndexOutOfBoundsException if index is invalid
   * @throws IllegalArgumentException  if course is not assigned a room
   */
  public Room getAssignment(int index) {// TODO WORK ON THIS! NULL
    // checks if given index is invalid
    if (index > courses.length || index < 0) {
      throw new IndexOutOfBoundsException("this index is out of order ");
    }
    // checks if the course has not been assigned a room
    if (assignments[index] == -1 || index < 0) {
      throw new IllegalArgumentException("courses index is out of order ");
    }
    return rooms[assignments[index]];
  }

  /**
   * Checks if all courses have been assigned to rooms
   * 
   * @return returns true if all courses have been assigned to rooms
   */
  public boolean isComplete() {

    // checks if all courses have been assigned to rooms
    for (int i = 0; i < courses.length; i++) {
      if (assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * returns a new Schedule object with the course at the first argument 
   * index assigned to the room at the second argument index
   * 
   * @param courseIndex - index for course array
   * @param roomIndex   - index for rooms array
   * @return newSchedule - new Schedule object with updated course information
   * @throws IllegalArgumentException  if courseIndex is invalid
   * @throws IllegalArgumentException  if roomIndex is invalid
   * @throws IndexOutOfBoundsException if course or room index is invalid
   */
  public Schedule assignCourse(int courseIndex, int roomIndex) {// TODO WORK ON THIS!

    // checks if courseIndex is invalid
    if (courseIndex < 0 || courseIndex > courses.length - 1) {
      throw new IllegalArgumentException("this index is out of order ");
    }
    // checks if roomIndex is invalid
    if (roomIndex > rooms.length - 1 || roomIndex < 0) {
      throw new IllegalArgumentException("the rooms index is out of order");
    }

    // checks to ensure capacity is less than number of students
    if (rooms[roomIndex].getCapacity() < courses[courseIndex].getNumStudents()) {
      throw new IllegalArgumentException("the rooms index and course index is out of order");
    }

    // checks to make sure is not invalid at given courseIndex
    if (assignments[courseIndex] != -1) {
      throw new IndexOutOfBoundsException("the courses index is out of order ");
    }

    // creates copies of assignments, rooms, and courses array
    int assignmentsCopy[] = new int[assignments.length];
    Room roomsCopy[] = new Room[rooms.length];
    Course coursesCopy[] = new Course[courses.length];

    // Assigns values to the duplicate arrays from original arrays
    for (int i = 0; i < assignments.length; i++) {
      assignmentsCopy[i] = assignments[i];
    }

    for (int i = 0; i < rooms.length; i++) {
      roomsCopy[i] = rooms[i];
    }

    for (int i = 0; i < courses.length; i++) {
      coursesCopy[i] = courses[i];
    }

    // assigns and makes changes and updates to the new copied arrays
    assignmentsCopy[courseIndex] = roomIndex;
    int newCapacity = coursesCopy[courseIndex].getNumStudents();
    roomsCopy[roomIndex] = roomsCopy[roomIndex].reduceCapacity(newCapacity);

    // creates new Schedule object with updated duplicated arrays
    Schedule newSchedule = new Schedule(roomsCopy, coursesCopy, assignmentsCopy);

    return newSchedule;
  }

  /**
   * Method overrides the toString() method to create the new String representation
   * 
   * @return overridden output as per listed specification: 
   *         {CS300: AG 125, CS200: HUM 3650, CS400: Unassigned}
   */
  public String toString() {
    // sets "{" in the beginning of the String
    String finalValue = "{";

    // overrides with given values
    for (int i = 0; i < courses.length; i++) {
      finalValue += courses[i].getName();
      finalValue += ": ";
      if (assignments[i] >= 0) {
        finalValue += rooms[assignments[i]].getLocation();
      } else {
        finalValue += "Unassigned";
      }
      finalValue += ", ";
    }
    finalValue = finalValue.substring(0, finalValue.length() - 2);

    // adds "}" towards the end of the String
    finalValue += "}";
    String overridenValue = finalValue;

    // returns the overridden string as per the given specification
    return overridenValue;
  }
}