// --== CS400 Project One File Header ==--
// Name: Chinmay Koimuttum
// CSL Username: chinmay
// Email: koimuttum@wisc.edu 
// Lecture #: <002 @2:30pm>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;

public class HashtableMapTests {
  public static void main(String args[]) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }


  /**
   * test1() tests the put() method
   * 
   * @return true if the put() method works as it should and 
   *         false if it doesn't 
   */
  public static boolean test1() {
    {
    
    HashtableMap<Integer, Integer> test = new HashtableMap<Integer, Integer>(10);
    
    Integer key = 2;
    Integer val = 4;
    
    test.put(key, val);
    int index = Math.abs(key.hashCode()) % 10;
    
    if (!test.containsKey(key)) {
      System.out.println("put() method does not work");
      return false;
    }
    
    for (int i = 0; i < test.hashTable[index].size(); i++) {
      if (test.hashTable[index].get(i).getKey().equals(key) && 
          test.hashTable[index].get(i).getValue().equals(val)) {
        System.out.println("put() method works");
        return true;
      }
      else {
        System.out.println("put() method does not work");
        return false;
      }
    }
    
    try {
    test.put(3, 6);
    } catch (NoSuchElementException e) {
      System.out.println("NoSuchElementException error for put() method");
    } catch (Exception e) {
      System.out.println("Exception error for put() method");
    }
    
    if (test.get(3) == 6){
      System.out.println("put() method works");
      return true;
    }
    else {
      System.out.println("put() method does not work");
      return false;
    }
    }
    
    
  }

  /**
   * test1() tests the remove() method
   * 
   * @return true if the remove() method works as it should and 
   *         false if it doesn't 
   */
  public static boolean test2() {
    HashtableMap<Integer, Integer> test = new HashtableMap<Integer, Integer>(10);

    test.put(1, 3);

    test.remove(1);

    if (test.size() == 0) {
      System.out.println("remove() method works");
      return true;
    } else {
      System.out.println("remove() method does not work");
      return false;
    }

  }

  /**
   * test1() tests the size() and clear() method
   * 
   * @return true if the size() and clear() methods work as it should and 
   *         false if it doesn't 
   */
  public static boolean test3() {

    HashtableMap<Integer, Integer> test = new HashtableMap<Integer, Integer>(10);

    test.put(2, 3);
    test.put(3, 6);
    
    if (test.size()==2) {
      System.out.println("size() method works");
    }
    else {
      System.out.println("size() method does not work");
    }
    
    test.clear();
    
    if (test.size()==0) {
      System.out.println("clear() method works");
      return true;
    }
    else {
      System.out.println("clear() method does not work");
      return false;
    }

  }

  /**
   * test1() tests the containKey() method
   * 
   * @return true if the containsKey() method works as it should and 
   *         false if it doesn't 
   */
  public static boolean test4() {
    
    HashtableMap<Integer, Integer> test = new HashtableMap<Integer, Integer>(10);
    
    test.put(2, 3);
    test.put(3, 6);
    
    if (test.containsKey(2)==true && test.containsKey(3)==true) {
      System.out.println("containsKey() method works");
      return true;
    }
    else {
      System.out.println("containsKey() method does not work");
    }
      
    return false;

  }

  /**
   * test1() tests the get() method
   * 
   * @return true if the get() method works as it should and 
   *         false if it doesn't 
   */
  public static boolean test5() {
    HashtableMap<Integer, Integer> test = new HashtableMap<Integer, Integer>(10);
    
    test.put(2, 3);
    test.put(3, 6);
    
    if (test.get(2)==3 && test.get(3)==6) {
      System.out.println("get() method works");
      return true;
    }
    else {
      System.out.println("get() method does not work");
      return false; 
      
    }

  }
}
