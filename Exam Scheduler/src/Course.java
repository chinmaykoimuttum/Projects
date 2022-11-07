import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 
 * The class Course can be used to derive the number of students enrolled in the course, and the
 * name of the course itself.
 *
 */
public class Course {

  private String name; // the name of the course, e.g. “CS300”
  private int numStudents; // the number of students enrolled in the course, e.g. 250

  /**
   * Constructs name and numStudents
   * 
   * @param name        - name of the course
   * @param numStudents - number of students enrolled in the course
   * @throws IllegalArgumentException when number of students is less than zero
   */
  public Course(String name, int numStudents) {
    // Checks if number of students is less than 0
    if (numStudents < 0) {
      throw new IllegalArgumentException("what demon class is this");
    }
    // sets name and numStudents
    this.name = name;
    this.numStudents = numStudents;
  }

  /**
   * Gets the name of the course
   * 
   * @return name
   */
  public String getName() {
    // getter method for name
    return this.name;
  }

  /**
   * Gets the number of students enrolled in the course
   * 
   * @return numStudents
   */
  public int getNumStudents() {
    // getter method for numStudents
    return this.numStudents;
  }

}