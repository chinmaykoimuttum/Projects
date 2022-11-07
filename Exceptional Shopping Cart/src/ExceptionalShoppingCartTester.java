import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;

/**
 * The class executes various test methods in order to ensure 
 * that the methods of the class ExceptionalShoppingCart
 * are working effectively
 * 
 * @author Chinmay Koimuttum
 *
 */
public class ExceptionalShoppingCartTester {
  
  /**
   * testName method tests lookupProductByName
   * 
   * @return true if lookupProductByName is working
   */
  private static boolean testName() {
    //tests if lookupProductByName works properly
    try {
      ExceptionalShoppingCart.lookupProductByName("Donut");
      return false;
    }
    catch (NoSuchElementException e) {
      System.out.println("lookupProductByName is working");
    } catch (Exception e) {
      System.out.println("lookupProductByName is not working");
      return false;
    }
    return true;
  }

  /**
   * testId tests lookupProductById
   * 
   * @return true if lookupProductById is working
   */
  private static boolean testId() {
  //tests if lookupProductById works properly
    try {
      ExceptionalShoppingCart.lookupProductById(123456);
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("lookupProductById is working");
    } catch (Exception e) {
      System.out.println("lookupProductById is not working");
      return false;
    }
    return true;
  }

  /**
   * Executes runAllTests, which in turn runs every tester method
   * created within ExceptionalShoppingCartTester
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    runAllTests();
  }

  /**
   * testLookupMethods checks whether lookupProductById and 
   * lookupProductByName work 
   * 
   * @return true if lookupProductById and 
   * lookupProductByName work 
   */
  public static boolean testLookupMethods() {
    //tests if lookupProductById and lookupProductByName work 
    if (testId() && testName() == true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * testMarketCatalog tests if addItemToMarketCatalog is working
   * 
   * @return true if addItemToMarketCatalog is working 
   */
  public static boolean testMarketCatalog() {
    //tests if addItemToMarketCatalog is working properly 
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4390", "Apple", "$1.59");
    } catch (IllegalArgumentException e) {
      System.out.println("addItemToMarketCatalog is not working");
      return false;
    } catch (Exception e) {
      System.out.println("addItemToMarketCatalog is not working");
      return false;
    }
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("232 112", "Donut", "$12222");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("addItemToMarketCatalog is working");
    } catch (Exception e) {
      System.out.println("addItemToMarketCatalog is not working");
      return false;
    }
    return true;
  }
  
  /**
   * testParseCart tests the parseCartSummaryLine method
   * 
   * @return true if parseCartSummaryLine works properly
   */
  public static boolean testParseCart() {
    // makes test arrays to verify if parseCartSummaryLine works properly
    String[] test = {"whatever"};
    String[] test1 = {"Milk", null, null, null, null};
    // tests if parseCartSummaryLine works properly
    try {
      if (ExceptionalShoppingCart.parseCartSummaryLine("( 3 ) Milk ", test1, 1) != 4) {
        System.out.println("parseCartSummary is not working3");
        return false;
      }
    } catch (IllegalArgumentException e) {
      System.out.println("parseCartSummary is not working2");
      e.printStackTrace();
      return false;
    } catch (Exception e) {
      System.out.println("parseCartSummary is not working1");
      e.printStackTrace();
      return false;
    }
    try {
      ExceptionalShoppingCart.parseCartSummaryLine("(33 )donuts", test, 235);
      return false;
    } catch (DataFormatException e) {
      System.out.println("parseCartSummaryLine is working");

    } catch (IllegalArgumentException e) {
      System.out.println("parseCartSummaryLine is working");

    }
    catch (Exception e) {
      System.out.println("parseCartSummaryLine is not working");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * testLoadCartSummary tests the 
   * loadCartSummary method
   * 
   * @return true if loadCartSummary is working
   */
  public static boolean testLoadCartSummary() {
    // creates test.txt file to test if loadCartSummary 
    // works properly
    File fileTest = new File("test.txt");
    FileWriter fileWriter = null;
    // assigns wrong values to fileTest
    try {
      fileWriter = new FileWriter(fileTest);
      fileWriter.write("(3)Donuts \n ( one) Ranch");
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    String[] test = {"whatever"};
    File fileTest1 = new File("test1.txt");
    FileWriter fileWriter1 = null;
    // creates another file and array to test correct values for
    // loadCartSummary 
    try {
      fileWriter1 = new FileWriter(fileTest1);
      fileWriter1.write("( 3 ) Milk \n ( 2 ) Apple");
      fileWriter1.flush();
      fileWriter1.close();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    // tests if loadCartSummary is working properly with correct values
    String[] test1 = {null, null, null, null, null, null};
    try {
      if (ExceptionalShoppingCart.loadCartSummary(fileTest1, test1, 0) != 5) {
        System.out.println("loadCartSummary is not working1");
        return false;
      }
    } catch (IllegalArgumentException e) {
      System.out.println("loadCartSummary is not working2");
      return false;
    } catch (Exception e) {
      System.out.println("loadCartSummary is not working3");
      e.printStackTrace();
      return false;
    }
    // tests if loadCartSummary is working properly with incorrect values
    try {
      ExceptionalShoppingCart.loadCartSummary(fileTest, test, -3);
      System.out.println("loadCartSummary is not working");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("loadCartSummary is working");
    }
    catch (Exception e) {
      System.out.println("loadCartSummary is not working");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * testSaveCartSummary tests saveCartSummary method
   * 
   * @return true if saveCartSummary works 
   */
  public static boolean testSaveCartSummary() {
    // creates expected actual file and tester file to test
    // if saveCartSummary works properly 
    File actualFile = new File("actualFile.txt");
    File testerFile = new File("testerFile.txt");
    String[] test = {"Milk", "Apple"};
    try {
      // assigns correct values to actualFile
      FileWriter filewriter = new FileWriter(actualFile);
      filewriter.write("( 1 ) Milk \\n ( 2 ) Apple");
      filewriter.close();
      // uses actualFile and testFile to determine if saveCartSummary
      // fails in executing properly 
      ExceptionalShoppingCart.saveCartSummary(test, 2, testerFile);
      Scanner actualScanner = new Scanner(actualFile);
      Scanner testScanner = new Scanner(testerFile);
      while (actualScanner.hasNextInt()) {
        if (!(actualScanner.nextLine().equals(testScanner.nextLine()))) {
          System.out.println("saveCartSummary) Error found: unable to properly save file");
          return false;
        }
      }
    } catch (IOException e) {
      System.out.println("saveCartSummary is not working");
      e.printStackTrace();
      return false;
    } catch (Exception e) {
      System.out.println("saveCartSummary is not working");
      e.printStackTrace();
      return false;
    }
    System.out.println("saveCartSummary is working");
    return true;
  }

  /**
   * runAllTests runs all of the test methods created in
   * ExceptionalShoppingCartTester
   * 
   * @return true if testLookupMethods, testMarketCatalog,
   * testParseCart, testLoadCartSummary, and 
   * testSaveCartSummary is working
   */
  public static boolean runAllTests() {
    // runs all of the test methods created in ExceptionalShoppingCartTester.java
    if (testLookupMethods() == false || testMarketCatalog() == false || testParseCart() == false
        || testLoadCartSummary() == false || testSaveCartSummary() == false) {
      return false;
    }
    return true;
  }
}