
import java.io.Serializable;
import java.util.Vector;

public class ShoppingCart implements Serializable {
    private Vector items;
    public ShoppingCart() {
        items = new Vector();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }
    public Vector getItems() {
        return items;
    }

    public int getNumItems() {
        return items.size();
    }

    public void emptyCart() {
        items.clear();
    }

    public double getTotalCost() {
        double cost = 0.0;
        for (int i=0; i<items.size(); i++) {
            CartItem item = (CartItem)items.get(i);
            cost += item.getUnitPrice() * item.getQuantity();
        }

        return cost;
    }
}
