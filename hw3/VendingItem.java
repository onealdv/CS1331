/**
* @author onealdv
* @version 1.0
*/
public enum VendingItem {
    Lays (1.50),
    Doritos (1.50),
    Coke (2.50),
    Ramblin_Reck_Toy (180.75),
    Rubiks_Cube (30.00),
    Rat_Cap (15.00),
    FASET_Lanyard (10.00),
    Graphing_Calculator (120.00),
    UGA_Diploma (0.10),
    Pie (3.14),
    Clicker (55.55),
    Cheetos (1.25),
    Sprite (2.50),
    Red_Bull (4.75),
    Ramen (3.15),
    Cold_Pizza (0.99);

    private final double price;

    VendingItem(double price) {
        /**
         * @param constructor to assign price as object's price
         */
        this.price = price;
    }

    /**
     * @return price of object
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return string representation of price in $xx.xx format
     */
    public String toString() {
        return this.name() + ": $" + price;
    }
}
