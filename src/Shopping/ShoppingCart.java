package Shopping;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<ProductFactory, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public Map<ProductFactory, Integer> getItems() {
        return items;
    }

    public void addItem(ProductFactory item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public void removeItem(ProductFactory item) {
        items.remove(item);
    }

    public void clearCart() {
        items.clear();
    }

    public void setItems(Map<ProductFactory, Integer> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (Map.Entry<ProductFactory, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
