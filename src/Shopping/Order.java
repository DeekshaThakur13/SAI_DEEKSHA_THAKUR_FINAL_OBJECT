package Shopping;

import java.util.Map;

public class Order {
    private User customer;
    private ShoppingCart cart;
    private String status;

    public Order(User customer, ShoppingCart cart) {
        this.customer = customer;
        this.cart = cart;
        this.status = "Pending";
    }

    public void placeOrder() {
        if (status.equals("Pending")) {
            System.out.println("Placing order for User: " + customer.getUsername());
            System.out.println("Order Details:");
            for (Map.Entry<ProductFactory, Integer> entry : cart.getItems().entrySet()) {
                ProductFactory product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product.getName() + " - Quantity: " + quantity + ", $" + product.getPrice());
            }
            System.out.println("Total Amount: $" + cart.getTotalAmount());
            this.status = "Placed";
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order has already been placed.");
        }
    }

    public User getCustomer() {
        return customer;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public String getStatus() {
        return status;
    }
}
