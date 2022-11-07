import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 
 * This class tests the methods of ExamScheduler class and the methods found in Schedule class
 *
 */
public class ExamSchedulerTester {

  /**
   * The main method executes the test methods in order to 
   * ensure that the tested methods of P06 are working properly
   * 
   * @param args
   */
  public static void main(String args[]) {
    testCourse(); //checks whether testCourse() works 
    testRoom(); //checks whether testRoom() works 
    testAssignCourse(); //checks whether testAssignCourse() works 
    testScheduleAccessors(); //checks whether testScheduleAccessors() works
  }

  /**
   * Tests the creation of testRoom under invalid parameters
   * 
   * @return true if exception is caught
   * @throws IllegalArgumentException if exception is properly caught
   */
  private static boolean testRoomHelperFalse() {
    try {
      //creates testRoom with invalid parameters
      Room testRoom = new Room("Room 234", -1);
    } catch (IllegalArgumentException e) {
      System.out.println("testRoom() is working");
      return true; //returns true if exception is caught
    } catch (Exception e) {
      System.out.println("Exception in testRoom()");
      return false;
    }
    return false;
  }

  /**
   * Tests the creation of testCourse under invalid parameters
   * 
   * @return true if exception is caught
   * @throws IllegalArgumentException if exception is properly caught
   */
  private static boolean testCourseHelperFalse() {
    try {
      //creates testCourse with invalid parameters
      Course testCourse = new Course("Artistic Dancing", -1);
    } catch (IllegalArgumentException e) {
      System.out.println("testCourse() is working");
      return true; //returns true if exception is caught
    } catch (Exception e) {
      System.out.println("Exception in testCourse()");
      return false;
    }
    return false;
  }

  /**
   * Tests the creation of testRoom under valid parameters
   * 
   * @return true if no exception is thrown
   * @throws IllegalArgumentException is exception is caught in creation 
   *                                  of testRoom and deriving location and capacity
   */
  private static boolean testRoomHelperTrue() {
    try {
      //creates testRoom with valid parameters
      Room testRoom = new Room("Science 231", 8);
      //checks if location and capacity for testRoom returns the correct values
      if ((!testRoom.getLocation().equals("Science")) && (testRoom.getCapacity() != 8)) {
        System.out.println("Exception in testRoom()");
        return false; //returns false if location and capacity do not return correct values
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Exception in testRoom()");
      return false;
    }
    return true;
  }

  /**
   * Tests creation of testCourse under valid parameters
   * 
   * @return true if no exception is thrown
   * @throws IllegalArgumentException if exception is caught in creation of 
   *                                  testCourse and deriving name and number of students
   */
  private static boolean testCourseHelperTrue() {
    try {
    //creates testCourse with valid parameters
      Course testCourse = new Course("Artistic Jumping", 5);
      //checks if name and number of students for testCourse returns correct values
      if (!(testCourse.getName().equals("Artistic Jumping"))
          && (testCourse.getNumStudents() != 5)) {
        System.out.println("Exception in testCourse");
        return false; //returns false if name and number of students returns incorrectly
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Exception in testCourse()");
      return false;
    }
    return true;
  }

  /**
   * Checks to ensure null parameters for mySched Schedule Object throws NullPointerException
   * 
   * @return true if null pointer exception is caught
   * @throws NullPointerException if exception is caught in mySched with null parameters
   */
  private static boolean nullCheckerTestScheduleAccessors() {
    try {
      //creates Schedule object with null parameters
      Schedule mySched = new Schedule(null, null);
    } catch (NullPointerException e) {
      System.out.println("Schedule(course,room) is working");
      return true; //returns true if null exception is properly caught
    }
    return false;
  }


  /**
   * Checks the various methods of Schedule and ensures they are working properly
   * 
   * @return true if the Schedule methods are working fine
   * @throws IllegalArgumentException if errors are found in any of the Schedule methods
   */
  public static boolean testScheduleAccessorsTests() {

    //creates rooms and courses arrays to test Schedule methods 
    Room[] rooms = new Room[] {new Room("Setting", 9)}; 
    Course[] courses = new Course[] {new Course("CS300", 4)}; 

    //creates Schedule object with created arrays
    Schedule testSched = new Schedule(rooms, courses);

    //creates actual and expected Strings for testSched
    String actualTestSched = String.valueOf(testSched);
    String expectedTestSched = "{CS300: Unassigned}";
    
    //creates actual and expected Strings for testSched's number of courses
    String actualNumCourses = String.valueOf(testSched.getNumCourses());
    String expectedNumCourses = "1";
    
    //creates actual and expected Strings for testSched's number of rooms
    String actualNumRooms = String.valueOf(testSched.getNumRooms());
    String expectedNumRooms = "1";

    //creates actual and expected Strings for assignCourse method to testSched
    String actualAssigned = String.valueOf(testSched.assignCourse(0, 0));
    String expectedAssigned = "{CS300: Setting}";

    //creates actual and expected Strings for whether testSched is complete
    String actualComplete = String.valueOf(testSched.isComplete());
    String expectedComplete = "false";

    //creates actual and expected Strings for if course at index 0 is assigned to a room
    String actualIsAssigned = String.valueOf(testSched.isAssigned(0));
    String expectedIsAssigned = "false";

    //creates actual and expected Strings for toString 
    String actualCourse = 
        String.valueOf(testSched.assignCourse(0, 0).toString());
    String expectedCourse = "{CS300: Setting}";

    //creates actual and expected Strings for testing getLocation
    String actualLocation = 
        String.valueOf(testSched.assignCourse(0, 0).getRoom(0).getLocation());
    String expectedLocation = "Setting";

    //creates actual and expected Strings for testing getCapacity
    String actualCapacity = 
        String.valueOf(testSched.assignCourse(0, 0).getRoom(0).getCapacity());
    String expectedCapacity = "5";

    //creates actual and expected Strings for testing getName
    String actualGetName = 
        String.valueOf(testSched.assignCourse(0, 0).getCourse(0).getName());
    String expectedGetName = "CS300";

    //creates actual and expected Strings for testing getNumStudents
    String actualGetNumStudents =
        String.valueOf(testSched.assignCourse(0, 0).getCourse(0).getNumStudents());
    String expectedGetNumStudents = "4";

    //creates actual and expected Strings for testing getLocation with getAssignment
    String actualGetLocation =
        String.valueOf(testSched.assignCourse(0, 0).getAssignment(0).getLocation());
    String expectedGetLocation = "Setting";

    //creates actual and expected Strings for testing getCapacity with getAssignment
    String actualGetCapacity =
        String.valueOf(testSched.assignCourse(0, 0).getAssignment(0).getCapacity());
    String expectedGetCapacity = "5";

    //tests all of the actual and expected values 
    try {
      if (actualTestSched.equals(expectedTestSched) 
          && actualNumCourses.equals(expectedNumCourses)
          && actualNumRooms.equals(expectedNumRooms) 
          && (actualAssigned).equals(expectedAssigned)
          && actualComplete.equals(expectedComplete) 
          && actualIsAssigned.equals(expectedIsAssigned)
          && actualCourse.equals(expectedCourse) 
          && actualLocation.equals(expectedLocation)
          && actualCapacity.equals(expectedCapacity) 
          && actualGetName.equals(expectedGetName)
          && actualGetNumStudents.equals(expectedGetNumStudents)
          && actualGetLocation.equals(expectedGetLocation)
          && actualGetCapacity.equals(expectedGetCapacity)) {
      }
    } catch (IllegalArgumentException e) {
      System.out.println("testScheduleAccessors() is not working");
      return false;
    } catch (Exception e) {
      System.out.println("testScheduleAccessors() is not working");
      return false;
    }
    System.out.println("testScheduleAccessors() is working");
    return true; //returns true if actual values are same as expected values 
  }

  /**
   * Tests the assignCourse method to ensure it is working properly
   * 
   * @return true if assignCourse() is working properly
   */
  public static boolean testAssignCourse() {
    //creates rooms and courses arrays to test assignCourse method 
    Room[] rooms = new Room[] 
        {new Room("Setting", 1), new Room("CS Building", 10)};
    Course[] courses = new Course[] 
        {new Course("CS300", 4), new Course("Computer Science", 4)};

    //expected result of assignCourse method used with provided arrays and values
    String expected = "{CS300: CS Building, Computer Science: Unassigned}";

    Schedule actual = new Schedule(rooms, courses).assignCourse(0, 1);
    String convertedActual = String.valueOf(actual);

    //checks to ensure expected result is same as actual result
    if (expected.equals(convertedActual)) {
      System.out.println("assignCourseTest() is working");
      return true;
    } else {
      System.out.println("assignCourseTest() is not working");
      return false;
    }
  }

  /**
   * Tests the helper methods of the testCourse() 
   * method to ensure the tests are passing correctly
   * 
   * @return true if the tests are passing
   */
  public static boolean testCourse() {
    //checks if helper methods for testCourse() return true
    if (testCourseHelperFalse() == true 
        && testCourseHelperTrue() == true) {
      return true;
    }
    return false;
  }

  /**
   * Tests the helper methods of the testRoom() 
   * method to ensure the tests are passing correctly
   * 
   * @return true if the tests are passing
   */
  public static boolean testRoom() {
    //checks if helper methods for testRoom() return true
    if (testRoomHelperFalse() == true 
        && testRoomHelperTrue() == true) {
      return true;
    }
    return false;
  }

  /**
   * Tests the helper methods of the testScheduleAccessors() 
   * method to ensure the tests are passing
   * correctly
   * 
   * @return true if the tests are passing
   */
  public static boolean testScheduleAccessors() {
    //checks if helper methods for testScheduleAccessors() return true
    if ((testScheduleAccessorsTests() == true) 
        && (nullCheckerTestScheduleAccessors() == true)) {
      return true;
    }
    return false;
  }
}