import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 
 * The class uses recursive methods in order to return valid Schedules 
 * provided given set of rooms and courses
 *
 */
public class ExamScheduler {

  /**
   * The method uses the findScheduleHelper to return the valid Schedule 
   * based on given set of rooms and courses
   * 
   * @param roomArray   - array of Room objects
   * @param courseArray - array of the Course objects
   * @return valid Schedule for the given set of rooms and courses
   * @throws IllegalStateException if no such schedule exists
   */
  public static Schedule findSchedule(Room[] roomArray, Course[] courseArray) {
    return findScheduleHelper(new Schedule(roomArray, courseArray), 0);
  }

  /**
   * Recursive helper method to aid findSchedule
   * 
   * @param sched - Schedule Object
   * @param index - specific index
   * @return
   * @throws IllegalStateException if sched is incomplete
   * @throws IllegalStateException if no rooms left to assign
   */
  private static Schedule findScheduleHelper(Schedule sched, int index) {

    // check to make sure the provided index is equal to the number of courses
    if (index == sched.getNumCourses()) {
      if (sched.isComplete() == true) {
        return sched;
      } else {
        throw new IllegalStateException("sched is not incomplete");
      }
    }
    // executes if provided index corresponds to a course that 
    //has already been assigned to a room
    if (sched.isAssigned(index) == true) {
      // recursively assign the courses
      return findScheduleHelper(sched, index + 1);
    }
    // executes if provided index corresponds to a course that has
    // NOT already been assigned to a room
    if (sched.isAssigned(index) == false) {
      // recursively assigns the courses at the following indexes
      for (int i = 0; i < sched.getNumRooms(); i++) {
        try {
          return findScheduleHelper(sched.assignCourse(index, i), index + 1);
        } catch (IllegalStateException e) {
          // catches IllegalStateException
        } catch (IllegalArgumentException e) {
          // catches IllegalArgumentException
        } catch (Exception e) {
          // catches Exception
        }
      }
      throw new IllegalStateException("There are no rooms left to assign");
    }
    return sched;

  }

  /**
   * The method uses the findAllScheduleHelper helper method to 
   * derive the ArrayList containing all
   * possible Schedules for the given set of rooms and courses
   * 
   * @param roomArray   - array of Room objects
   * @param courseArray - array of the Course objects
   * @return ArrayList containing all possible Schedules for the given set of rooms and courses
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] roomArray, Course[] courseArray) {
    Schedule sched = new Schedule(roomArray, courseArray);
    return findAllSchedulesHelper(sched, 0);
  }

  /**
   * The private recursive helper method assigns all unassigned courses in a Schedule in all
   * possible ways
   * 
   * 
   * @param sched - Schedule Object
   * @param index - specific, given index
   * @return newArrayList with updated values
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule sched, int index) {

    // creates new ArrayList
    ArrayList<Schedule> newArrayList = new ArrayList<Schedule>();

    // checks if the provided index is equal to the number of courses
    if (index == sched.getNumCourses()) {
      if (sched.isComplete()) {
        newArrayList.add(sched);
        return newArrayList;
      }
    }

    // executes if provided index corresponds to a course that 
    //has already been assigned to a room
    if (sched.isAssigned(index) == true) {
      newArrayList.addAll(findAllSchedulesHelper(sched, index + 1));
    }

    // executes if provided index corresponds to a course that has not been assigned to a room
    if (sched.isAssigned(index) == false) {
      for (int i = 0; i < sched.getNumRooms(); i++) {
        try {
          newArrayList.addAll(findAllSchedulesHelper(sched.assignCourse(index, i), index + 1));
        } catch (IllegalStateException e) {
          // catches IllegalStateException
        } catch (IllegalArgumentException e) {
          // catches IllegalArgumentException
        } catch (Exception e) {
          // catches Exception
        }
      }
    }
    return newArrayList;
  }
}