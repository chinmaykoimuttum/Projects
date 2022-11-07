import java.util.ArrayList;

public class BackendDeveloperTest {

  /**
   * tests every tester method which tests the methods from BookMapperBackend
   * 
   * @param args
   */
  public static void main (String args[]) {
    System.out.println("test1(): " + test1());
    System.out.println("test2(): " + test2());
    System.out.println("test3(): " + test3());
    System.out.println("test4(): " + test4());
    System.out.println("test5(): " + test5());
    //test1();
    //test2();
    //test3();
    //test4();
    //test5();
  }
  
  /**
   * checks if addBook() and getNumberOfBooks() methods work
   * 
   * @return true if addBook() method and getNumberOfBooks() method works
   */
  public static boolean test1() { /* test code here */ 
    
    BookMapperBackend<String, IBook> test = new BookMapperBackend<String, IBook>();
    IBook testBook = new Book("Bill Bryson's African Diary", "Bill Bryson", "9780767915069");
    test.addBook(testBook);
    if (test.getNumberOfBooks() == 1) {
      //System.out.println("addBook() method works");
      //System.out.println("getNumberOfBooks() method works");
      return true;
    }
    else {
      return false;
    }

  }
  
  /**
   * checks if getByISBN() method works
   * 
   * @return true if getByISBN() method works
   */
  public static boolean test2() { 
    
    BookMapperBackend<String, IBook> test = new BookMapperBackend<String, IBook>();
    IBook testBook = new Book("Bill Bryson's African Diary", "Bill Bryson", "9780767915069");
    test.addBook(testBook);
    
    IBook returnBook = test.getByISBN("9780767915069");
    if (returnBook.getISBN13().equals("9780767915069")) {
      //System.out.println("getByISBN() method works");
      return true;
    }
    else {
      return false;
    }
    }
  
  /**
   * checks if setAuthorFilter() and getAuthorFilter works
   * 
   * @return true if setAuthorFilter() and getAuthorFilter works
   */
  public static boolean test3() { 
    
    BookMapperBackend<String, IBook> test = new BookMapperBackend<String, IBook>();
    IBook testBook = new Book("Bill Bryson's African Diary", "Bill Bryson", "9780767915069");
    IBook testBook2 = new Book("In a Sunburned Country", "Bill Bryson", "9780767903868");
    test.addBook(testBook);
    test.addBook(testBook2);
    
    test.setAuthorFilter("Bill Bryson");
    if (test.getAuthorFilter().equals("Bill Bryson")) {
      //System.out.println("setAuthorFilter() method works");
      //System.out.println("getAuthorFilter() method works");
      return true;
    }
    else {
      System.out.println("setAuthorFilter() method does not work");
      System.out.println("getAuthorFilter() method does not work");
      return false;
    }
    
  }
  
  /**
   * checks if resetAuthorFilter() method works
   * 
   * @return true if resetAuthorFilter() method works
   */
  public static boolean test4() { 
    
    BookMapperBackend<String, IBook> test = new BookMapperBackend<String, IBook>();
    IBook testBook = new Book("Bill Bryson's African Diary", "Bill Bryson", "9780767915069");
    IBook testBook2 = new Book("In a Sunburned Country", "Bill Bryson", "9780767903868");
    test.addBook(testBook);
    test.addBook(testBook2);
    
    test.resetAuthorFilter();
    if (test.getAuthorFilter() != null) {
      System.out.println("resetAuthorFilter() method does not work");
      return false;
    }
    else {
      //System.out.println("resetAuthorFilter() method works");
      return true;
    }
  }
  
  /**
   * checks if searchByTitleWord() works
   * 
   * @return true if searchByTitleWord() works
   */
  public static boolean test5() { 
    BookMapperBackend<String, IBook> test = new BookMapperBackend<String, IBook>();
    IBook testBook = new Book("Bill Bryson's African Diary", "Bill Bryson", "9780767915069");
    IBook testBook2 = new Book("In a Sunburned Country", "Bill Bryson", "9780767903868");
    test.addBook(testBook);
    test.addBook(testBook2);

    
    if(test.searchByTitleWord("Sunburned").get(0).getTitle().equals("In a Sunburned Country")) {
      //System.out.println("searchByTitleWord() method works");
      return true;
    }
    else {
      System.out.println("searchByTitleWord() method does not work");
      return false;
    }
    
    
    
  }
  
}
