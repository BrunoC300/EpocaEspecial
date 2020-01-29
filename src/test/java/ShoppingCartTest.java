import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    ShoppingCart sp;
    Vector<CartItem> listaCompras;

    @BeforeEach
    public void setUp() {
        CartItem ci1 = new CartItem("Nome1", 1, 11.5);
        CartItem ci2 = new CartItem("Nome2", 1, 12.5);
        CartItem ci3 = new CartItem("Nome3", 1, 13.5);
        CartItem ci4 = new CartItem("Nome4", 1, 14.5);

        sp = new ShoppingCart();
        sp.addItem(ci1);
        sp.addItem(ci2);
        sp.addItem(ci3);
        sp.addItem(ci4);
    }

    @AfterEach
    public void tearDown() {
        sp.emptyCart();
    }

    @Test
    public void testGetItems() {
        listaCompras = new Vector<CartItem>();
        CartItem ci5 = new CartItem("Arroz",10,12.5);
        CartItem ci6 = new CartItem("azeite",10,12.5);
        listaCompras.add(ci5);
        ShoppingCart sp2 = new ShoppingCart();
        sp2.addItem(ci5);
        //Falha
        assertEquals(sp2.getItems(),listaCompras);
        /*Aceita
        sp2.addItem(ci5);
        assertEquals(sp2.getItems(),listaCompras);*/

    }
    @Test
    public void getNumItems() {
        assertEquals(sp.getNumItems(),4);
    }

    @Test
    public void getTotalCostTest() {
        assertEquals(sp.getTotalCost(),52);
    }
}