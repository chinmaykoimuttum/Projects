/**
 * The ShoppingCartTester tests the various methods of ShoppingCart and ensures that the
 * methods are all working correctly.
 *
 * @author Chinmay Koimuttum
 */
public class ShoppingCartTester {

    /**
     * Main method
     * @param args input arguments if any
     */
    public static void main(String[] args) {
        System.out.println("testLookupMethods(): " + testLookupMethods());
        System.out.println("runAllTests(): " + runAllTests());
        System.out.println("testAddItemToCartContainsNbOccurrences(): " + testAddItemToCartContainsNbOccurrences());
        System.out.println("testGetProductPrice(): " + testGetProductPrice());
        System.out.println("testLookupMethods(): " + testLookupMethods());
        System.out.println("testRemoveItem(): " + testRemoveItem());
        System.out.println("testCheckoutGetCartSummary(): " + testCheckoutGetCartSummary());
    }

    /**
     * Checks whether ShoppingCart.lookupProductByName() and
     * ShoppingCart.lookupProductById() methods work as expected.
     * @return true when this test verifies a correct functionality,
     *        and false otherwise
     */
    public static boolean testLookupMethods() {

        // 1. The item to find is at index 0 of the marketItems array
        {
            String expectedOutput = "4390 Apple $1.59";
            //System.out.println(ShoppingCart.lookupProductById(4390));
            if (!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductById() method " + "failed" + " to return the expected output when passed the id " + "of Apple as input");
                return false;
            }
            if (!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductByName() method " + "failed to return the expected output when passed Apple as input");
                return false;
            }
        }
        {
            String expectedOutput = "4688 Tomato $1.79";
            if (!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductByName() method " + "failed " + "to return the expected output when passed Tomato as input");
                return false;
            }
            if (!ShoppingCart.lookupProductById(4688).equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductById() method " + "failed" + " to return the expected output when passed the id " + "of Tomato as input");
                return false;
            }
        }
        // 3. The item to find is at an arbitrary position of the
        // middle of the marketItems array
        {
            String expectedOutput = "4363 Cookie $9.5";
            if (!ShoppingCart.lookupProductByName("Cookie").equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductByName() method " +
                    "failed " + "to return the expected output when passed Cookie as input");
                return false;
            }
            if (!ShoppingCart.lookupProductById(4363).equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductById() method " + "failed" + " to return the expected output when passed the id " + "of Cookie as input");
                return false;
            }
        }
        // 4. The item to find is not found in the market
        {
            String expectedOutput = "No match found";
            if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductByName() method " + "failed to return the expected output when passed the name of " + "a product not found in the market.");
                return false;
            }
            if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
                System.out.println("Problem detected: Your lookupProductById() method " + "failed to return the expected output when passed the identifier" + "of a product not found in the market.");
                return false;
            }
            // You may add other test scenarios
            return true; // NO BUGS detected by this tester method
        }
    }

    /**
     * Checks the correctness of ShoppingCart.getProductPrice() method
     * @return true when this test verifies a correct functionality,
     *        and false otherwise
     */
    public static boolean testGetProductPrice() {
        // first test scenario: get the price of Apple
        {
            double expectedPrice = 1.59; // price of the product Apple in the market
            // Note that we do not use the == operator to check whether two
            // floating-point numbers (double or float) in java are equal.
            // Two variables a and b of type double are equal if the absolute
            // value of their difference is less or equal to a small threshold epsilon.
            // For instance, if Math.abs(a - b) <= 0.001, then a equals b

            if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
                // print feedback to report the detected bug
                System.out.println("Error: getProductPrice() method failed to "
                    + "get product price of Apple");
                return false;
            }
        }
        //test case 2 with "Tomato"
        {
            double expectedPrice = 1.79;
            if (Math.abs(ShoppingCart.getProductPrice("Tomato") - expectedPrice) > 0.001) {
                // print feedback to report the detected bug
                System.out.println("Error: getProductPrice() method failed to get product price " +
                    "of Tomato");
                return false;
            }
        }
        //test case 3 with "Cookie"
        {
            double expectedPrice = 9.5;
            if (Math.abs(ShoppingCart.getProductPrice("Cookie") - expectedPrice) > 0.001) {
                // print feedback to report the detected bug
                System.out.println("Error: getProductPrice() method failed to get product price " +
                    "of Cookie");
                return false;
            }
        }
        return true; // No bug detected. The ShoppingCart.getProductPrice()
        // passed this tester.
    }

    /**
     * This test method checks the correctness of addItemToCart, contains, and nbOccurrences
     * methods defined in the ShoppingCart class
     *
     * @return true if the test verifies that the three methods are working properly
     */
    public static boolean testAddItemToCartContainsNbOccurrences() {
        int expected = 5;
        String[] cart1 = new String[]{"Milk", "Apple", "Banana", "Pizza",null};
        if (ShoppingCart.addItemToCart("Eggs", cart1, 4 ) != expected) {
            System.out.println("Error: addItemToCart() method failed");
            return false;
        }
        return true;
    }

    /**
     * This tester method checks the correctness of removeItem() method which is defined
     * in the ShoppingCart class
     *
     * @return true if the testRemoveItem method properly removes the item from the cart and
     * returns the appropiate size value
     */
    public static boolean testRemoveItem() {
        int expected = 4;
        String[] cart2 = new String[]{"Milk", "Apple", "Banana",
            "Apple", "Pizza", null, null};
        if (ShoppingCart.removeItem(cart2, "Milk", 5 ) != 4) {
            System.out.println("Error: testRemoveItem() method failed");
            return false;
        }
        return true;
    }

    /**
     * This tester method checks the correctness of checkout and getCartSummary()
     * methods defined in the ShoppingCart class
     *
     * @return true if the methods are verified to be working appropiately
     */
    public static boolean testCheckoutGetCartSummary() {

        String expected = "";
        String[] cart1 = new String[]{null, null};
        if (ShoppingCart.getCartSummary(cart1, 0) != expected ){
            System.out.println("Cart Summary checker 1 failed");
            return false;
        }
        int value = 1;
        String expectedTest2 = "(1) Milk" + "\n" +
            "(1) Apple" + "\n";
        String[] cart2 = new String[]{"Milk", "Apple", null, null};
        if (!(ShoppingCart.getCartSummary(cart2, 2).equals(expectedTest2)) ){
            //System.out.println("tester one:");
            //System.out.println(expected2);
            System.out.println("Cart Summary checker 2 failed");
            return false;
        }
        int value1 = 1;
        int value2 = 2;
        String expectedTest3 = "(2) Milk" + "\n" +
            "(1) Apple" + "\n";
        String[] cart3 = new String[]{"Milk", "Apple", "Milk", null};
        if (!(ShoppingCart.getCartSummary(cart3, 3).equals(expectedTest3)) ){
            System.out.println("Cart Summary checker 3 failed");
            //System.out.println("tester one:");
            //System.out.println(expected3);
            return false;
        }
        double expected1 = ((2.09 + 1.59)*1.05);
        String[] cartCheckout = new String[]{"Milk", "Apple"};
        if (ShoppingCart.checkout(cartCheckout, 2) - expected1 > 0.01) {
            System.out.println("Error: checkout() method failed");
            return false;
        }
        return true;
    }

    /**
     * This tester runs all the tester methods defined in this tester class and ensures all
     * the methods are working properly
     *
     * @return true if all the methods are working correctly.
     */
    public static boolean runAllTests() {
        if (testCheckoutGetCartSummary() == true && testRemoveItem()==true &&
            testAddItemToCartContainsNbOccurrences()==true && testGetProductPrice()==true
            && testLookupMethods()==true) {
            return true;
        }
        return false;
    }
}

