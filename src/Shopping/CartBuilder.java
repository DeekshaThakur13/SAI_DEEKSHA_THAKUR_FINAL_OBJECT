package Shopping;

import java.util.HashMap;
import java.util.Map;

public class CartBuilder {
    private Map<ProductFactory, Integer> items;

    public CartBuilder() {
        this.items = new HashMap<>();
    }

    public CartBuilder addItem(ProductFactory product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + quantity);
        } else {
            items.put(product, quantity);
        }
        return this;
    }

    public ShoppingCart build() {
        ShoppingCart cart = new ShoppingCart();
        for (Map.Entry<ProductFactory, Integer> entry : items.entrySet()) {
            cart.addItem(entry.getKey(), entry.getValue());
        }
        return cart;
    }
}
