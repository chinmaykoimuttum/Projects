/**
 * This class, ShoppingCart, essentially uses the
 * input of a user and allows the user to perform
 * various tasks. The class contains String[][] marketItems,
 * which essentially holds the item names,
 * id numbers, and costs of the market items.
 * The class allows users to look up a product by name
 * and check whether a match exists for it.
 * The class also allows users to look up an item by id
 * number and find its name.
 * The class also allows users to get product price with the name of the
 * item itself.
 * The class also allows users to generate and get a full deep copy of their cart and
 * its items.
 * The class also allows users to add and remove items from the cart, and also check the
 * occurrences of the item within the cart.
 * The class also allows users to check whether a cart
 * contains at least one occurrence of a given item.
 * The class also allows users to checkout and
 * receive the total cost of their items including tax.
 * The class also allows users to empty cart.
 * The class also allows users to get the cart summary.
 *
 * @author Chinmay Koimuttum
 */
public class ShoppingCart {

    private static final double TAX_RATE = 0.05; // sales tax

    private static String[][] marketItems =
        new String[][] {{"4390", "Apple", "$1.59"}, {"4046", "Avocado", "$0.59"},
            {"4011", "Banana", "$0.49"}, {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
            {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"}, {"4017", "Carrot", "$1.19"},
            {"3240", "Cereal", "$3.69"}, {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
            {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"},
            {"4232", "Cucumber", "$0.79"}, {"3033", "Eggs", "$3.09"}, {"4770", "Grape", "$2.29"},
            {"3553", "Ice Cream", "$5.39"}, {"3117", "Milk", "$2.09"},
            {"3437", "Mushroom", "$1.79"}, {"4663", "Onion", "$0.79"}, {"4030", "Pepper", "$1.99"},
            {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"}, {"3044", "Spinach", "$3.09"},
            {"4688", "Tomato", "$1.79"}, null, null, null, null};

    /**
     * This method uses String name in order to find and returns the appropiate item name, id, and
     * price.
     *
     * @param name (name of the item the user is inputting)
     * @return String lookupProductByName returns item name, id, and price if it exists or returns
     * "No match found" if it does not exist.
     */
    public static String lookupProductByName(String name) {
        for (int i = 0; i < marketItems.length; i++) {
            if ((marketItems[i] != null) && marketItems[i][1].equals(name)) {
                String itemID = marketItems[i][0];
                String itemName = marketItems[i][1];
                String itemPrice = marketItems[i][2];
                String marketList = itemID + " " + itemName + " " + itemPrice;
                return marketList;
            } else if (marketItems[i] == null) {
                String noMatch = "No match found";
                return noMatch;
            } else if (i == marketItems.length - 1 && !(marketItems[i][1].equals(name))) {
                String noMatch = "No match found";
                return noMatch;
            }
        }
        return ""; // default statement added to allow this code to compile
    }

    /**
     * The method returns a string representation of the item whose id is provided as input if a
     * match was found.
     *
     * @param id (id of the item the user is inputting)
     * @return String lookupProductByID returns item name, id, and price if it exists or returns "No
     * match found" if it does not exist.
     */
    public static String lookupProductById(int id) {
        for (int i = 0; i < marketItems.length; i++) {
            if ((marketItems[i] != null) && Integer.parseInt(marketItems[i][0]) == id) {
                String itemID = marketItems[i][0];
                String itemName = marketItems[i][1];
                String itemPrice = marketItems[i][2];
                String marketList = itemID + " " + itemName + " " + itemPrice;
                return marketList;
            } else if (marketItems[i] == null) {
                String noMatch = "No match found";
                return noMatch;
            } else if (i == marketItems.length - 1 && !marketItems[i][1].equals(id)) {
                String noMatch = "No match found";
                return noMatch;
            }
        }
        return ""; // default statement added to allow this code to compile
    }

    /**
     * This method returns the price in dollars (a double value) of a market item by using its name
     * which the user inputs.
     *
     * @param name (name of the item the user is inputting)
     * @return double getProductPrice returns item price of the item if it exists or returns -1.0 if
     * it does not exist.
     */
    public static double getProductPrice(String name) {
        for (int i = 0; i < marketItems.length; i++) {
            if ((marketItems[i] != null) && marketItems[i][1].equals(name)) {
                double itemPrice = Double.parseDouble(marketItems[i][2].substring(1));
                return itemPrice;
            } else if (marketItems[i] == null) {
                return -1.0;
            } else if (i == marketItems.length - 1 && !marketItems[i][1].equals(name)) {
                return -1.0;
            }
        }
        return 0.0; // default statement added to allow this code to compile
    }

    /**
     * The method returns a deep copy of the marketItems array found above which contains the item
     * names, prices, and ids of all available items.
     *
     * @return getCopyOfMarketItems returns a deep copy of the marketItems array
     */
    public static String[][] getCopyOfMarketItems() {
        String[][] deepCopy = new String[marketItems.length][];
        for (int i = 0; i < marketItems.length; i++) {

            deepCopy[i] = marketItems[i];
        }
        return deepCopy; // default statement added to allow this code to compile
    }

    /**
     * The method appends an item to a given cart, and if the cart is already full, the item will
     * not be added to the cart.
     *
     * @param item (name of the item the user is inputting)
     * @param cart (array of strings which contains the names of items in the cart)
     * @param size (number of items in the cart)
     * @return addItemToCart returns the size of the array cart after attempting to add an item to
     * the cart.
     */
    public static int addItemToCart(String item, String[] cart, int size) {
        if (size == cart.length) {
            return size;
        }
        //if (size != cart.length) {
        else {
            for (int i = 0; i < cart.length; i++) {
                if (cart[i] == null) {
                    cart[i] = item;
                    size++;
                    return size;
                }
            }
        }
        return size;
    }

    /**
     * The method returns the number of occurrences of a given item within the cart.
     *
     * @param item (name of the item the user is inputting)
     * @param cart (array of strings which contains the names of items in the cart)
     * @param size (number of items in the cart)
     * @return nbOccurrences returns the number of occurrences of the item within the cart array.
     */
    public static int nbOccurrences(String item, String[] cart, int size) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (cart[i].equals(item)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * The method checks whether a cart contains at least one occurrence of a given item.
     *
     * @param item (name of the item the user is inputting)
     * @param cart (array of strings which contains the names of items in the cart)
     * @param size (number of items in the cart)
     * @return
     */
    public static boolean contains(String item, String[] cart, int size) {
        for (int i = 0; i < size; i++) {
            if (cart[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method returns the total value in dollars of the cart including the tax rate.
     *
     * @param cart (array of strings which contains the names of items in the cart)
     * @param size (the number of items in the cart)
     * @return checkout returns the total item price
     */
    public static double checkout(String[] cart, int size) {
        double totalItemPrice = 0.0;

        for (int i = 0; i < size; i++) {
            if (marketItems[i][1].equals(cart[i])) {
                double temp1 = Double.parseDouble(marketItems[i][2].substring(1));
                totalItemPrice = totalItemPrice + (temp1 * (TAX_RATE + 1.0));
            }
        }
        return totalItemPrice;
    }

    /**
     * The method removes one occurrence of the inputted item from a given cart
     *
     * @param cart (array of strings which contains the names of items in the cart)
     * @param item (name of the item the user is inputting)
     * @param size (the number of items in the cart)
     * @return removeItem returns the size of the oversize array cart after attempting to remove
     * item from the cart.
     */
    public static int removeItem(String[] cart, String item, int size) {
        if (size != cart.length) {

            for (int i = 0; i < size; i++) {
                if ((cart[i] != null) && (cart[i].equals(item))) {
                    cart[i] = null;
                    break;
                }
            }
            size--;
            return size;
        } else if (size == cart.length) {
            return size;
        }
        return size;
    }

    /**
     * The method removes all items from a given cart so that the cart is left empty.
     *
     * @param cart (array of strings which contains the names of items in the cart)
     * @param size (the number of items in the cart)
     * @return emptyCart returns the size of the cart after removing all its items.
     */
    public static int emptyCart(String[] cart, int size) {
        for (int i = 0; i <= size; i++) {
            cart[i] = null;
            size--;
        }
        return size;
    }

    /**
     * The method returns a string representation of the summary of the contents of a given cart
     * including the occurrences of duplicate items within the cart
     *
     * @param cart (array of strings which contains the names of items in the cart)
     * @param size (the number of items in the cart)
     * @return getCartSummary returns a string representation of the summary of the contents of the
     * cart
     */
    public static String getCartSummary(String[] cart, int size) {
        if (size == 0) {
            return "";
        }
        String finalSummary = "";
        int counter = 0;
        for (int i = 0; i < size; i++) {
            counter = nbOccurrences(cart[i], cart, size);
            if (!finalSummary.contains(cart[i])) {
                finalSummary = finalSummary + "(" + counter + ") " + cart[i] + "\n";
            }
        }
        return finalSummary;
    }
}


