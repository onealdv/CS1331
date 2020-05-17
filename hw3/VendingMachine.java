import java.util.Random;
/**
* @author onealdv
* @version 2.1
*/

public class VendingMachine {

    private VendingItem[][][] shelf;
    private static double totalSales;
    private Random rand;
    private int luckyChance;

    /**
    * Constructor for VendingMachine object and initializes shelf
    * Runs restock() when a VendingMachine object is created
    */
    public VendingMachine() {
        shelf = new VendingItem[6][3][5];
        restock();

    }
    /**
    * Takes in a user input to dispense a VendingItem object from the shelf
    *
    * @param code is a User Input refering to item location in shelf
    * @return VendingItem object from the index in the 3D Array shelf
    * and null if input is invalid
    *
    */
    public VendingItem vend(String code) {
        if (code.length() > 2 || code.length() < 0) {
            return null;
        }
        char row = code.charAt(0);
        char col = code.charAt(1);
        int r = Character.getNumericValue(row) - 10;
        int c = Character.getNumericValue(col) - 1;
        if ((r > 6 || r < 0) || (c < 0 || c > 2)) {
            System.out.println("Please choose a valid item");
            return null;
        } else {
            if (shelf[r][c][0] == null) {
                System.out.println("Your item is out of stock.");
                return null;
            } else {
                VendingItem dispensed = shelf[r][c][0];
                if (free()) {
                    System.out.println("Congratulations, your item is free!");
                } else {
                    double saleval = shelf[r][c][0].getPrice();
                    totalSales += saleval;
                }
                for (int i = 0; i < 4; i++) {
                    shelf[r][c][i] = shelf[r][c][i + 1];
                }
                shelf[r][c][4] = null;
                return dispensed;
            }
        }
    }
    /**
    * Determines a boolean value of true if random integer in luckyChance
    * probability
    *
    * @return boolean value if true or false
    */
    private boolean free() {
        rand = new Random();
        if (rand.nextInt(100) < luckyChance) {
            luckyChance = 0;
            return true;
        } else {
            luckyChance += 1;
            return false;
        }
    }
    /**
    * Populates the shelf array with random VendingItem objects
    */
    public void restock() {
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    rand = new Random();
                    shelf[i][j][k] = VendingItem.values()
                                    [rand.nextInt(VendingItem.values().length)];
                }
            }
        }
    }
    /**
    * @return value of totalSales
    */
    public static double getTotalSales() {
        return totalSales;
    }
    /**
    * @return number of items in shelf that is not null
    */
    public int getNumberOfItems() {
        int itemcount = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        itemcount += 1;
                    }
                }
            }
        }
        return itemcount;
    }
    /**
    * @return total price of items in shelf that are not null
    */
    public double getTotalValue() {
        double totalval = 0.0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        totalval += shelf[i][j][k].getPrice();
                    }
                }
            }
        }
        return totalval;
    }
    /**
    * @return luckyChance value for testing
    */
    public int getLuckyChance() {
        return luckyChance;
    }
    /**
    * @return string visualization of the shelf
    */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));
        // s.append(String.format("Lucky Chance on vending machines "
        //     + "is now: %s%n", getLuckyChance()));
        return s.toString();
    }
}
