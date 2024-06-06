package Shopping;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CatalogTest {
    @Test
    public void testAddProduct() {
        Catalog catalog = new Catalog();
        ProductFactory Bands = new Accessories("Bands", 19, "Silk", 10);
        catalog.addProduct(Bands);
        assertEquals(1, catalog.getAllProducts().size());
    }

    @Test
    public void testAddProducts() {
        Catalog catalog = new Catalog();
        List<ProductFactory> newProducts = new ArrayList<>();
        ProductFactory Rice = new Groceries("Rice", 30, "Swad", 10);
        newProducts.add(Rice);
        catalog.addProducts(newProducts);
        assertEquals(1, catalog.getAllProducts().size());
    }

    @Test
    public void testGetProductByName() {
        Catalog catalog = new Catalog();
        ProductFactory Pens = new Stationary("Pens", 79, "Cello", 20);
        catalog.addProduct(Pens);
        assertEquals(Pens, catalog.getProductByName("Pens"));
        assertNull(catalog.getProductByName("NonexistentProduct"));
    }
}
