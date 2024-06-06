package Shopping;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void testGetTotalAmount() {
        List<ProductFactory> products = ProductLoader.loadProducts();
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(products.get(0), 2);
        cart.addItem(products.get(1), 1);
        cart.addItem(products.get(6), 3);
        cart.addItem(products.get(9), 1);

        double expectedTotalAmount = (products.get(0).getPrice() * 2) + products.get(1).getPrice()
                + (products.get(6).getPrice() * 3) + products.get(9).getPrice();
        assertEquals(expectedTotalAmount, cart.getTotalAmount(), 0.01);
    }

    @Test
    public void testAddItem() {
        List<ProductFactory> products = ProductLoader.loadProducts();
        ShoppingCart cart = new ShoppingCart();
        ProductFactory product = products.get(2);

        cart.addItem(product, 2);
        assertEquals(2, (int) cart.getItems().get(product));
    }

    @Test
    public void testRemoveItem() {
        List<ProductFactory> products = ProductLoader.loadProducts();
        ShoppingCart cart = new ShoppingCart();
        ProductFactory product = products.get(3);

        cart.addItem(product, 1);
        cart.removeItem(product);

        assertEquals(0, cart.getItems().size());
    }
}
