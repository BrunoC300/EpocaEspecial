import java.io.Serializable;
public class CartItem implements Serializable {
    private double unitprice;
    private int quantity;
    private String name;

    public CartItem(String itemname, int itemquant, double price) {
        name = itemname;
        quantity = itemquant;
        unitprice = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitprice;
    }
}
