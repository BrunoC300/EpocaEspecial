import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartItemTest {
    CartItem ci1;
    CartItem ci2 ;
    CartItem ci3 ;
    CartItem ci4 ;

    @BeforeEach
    public void setUp() {
        ci1 = new CartItem("Nome1", 1, 11.5);
        ci2 = new CartItem("Nome2", 1, 12.5);
        ci3 = new CartItem("Nome3", 1, 13.5);
        ci4 = new CartItem("Nome4", 1, 14.5);

    }

    @Test
    public void getNameTest(){

        assertEquals(ci1.getName(),"Nome1");
        assertEquals(ci1.getName(),"Nome2");

    }

    @Test
    public void getQuantityTest(){
        assertEquals(ci3.getQuantity(),1);
        assertEquals(ci4.getQuantity(),1);

    }

    @Test
    public void getunitpriceTest(){
        assertEquals(ci1.getUnitPrice(),12.5);
        assertEquals(ci1.getUnitPrice(),11.5);
    }
}
