package Shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class MainClassGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private User currentUser;
    private UserAuthentication userAuthentication;
    private ShoppingCart shoppingCart;
    private Catalog catalog;

    public MainClassGUI() {
        super("Online Shopping System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        userAuthentication = new UserAuthentication();
        shoppingCart = new ShoppingCart();
        catalog = new Catalog();

        catalog.addProducts(ProductLoader.loadProducts());

        createGUIComponents();

        setVisible(true);
    }

    private void createGUIComponents() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 20, 120, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationDialog();
            }
        });
        panel.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 20, 120, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog();
            }
        });
        panel.add(loginButton);

        JButton browseProductsButton = new JButton("Browse Products");
        browseProductsButton.setBounds(20, 70, 260, 30);
        browseProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductList();
            }
        });
        panel.add(browseProductsButton);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(20, 120, 120, 30);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddToCartDialog();
            }
        });
        panel.add(addToCartButton);

        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.setBounds(160, 120, 120, 30);
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCart();
            }
        });
        panel.add(viewCartButton);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(20, 170, 260, 30);
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        panel.add(placeOrderButton);

        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.setBounds(160, 170, 120, 30);
        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromCartDialog();
            }
        });
        panel.add(removeFromCartButton);

        // Add Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(160, 220, 120, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        add(panel);
    }

    private void showRegistrationDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField emailField = new JTextField();

        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField,
                "Email:", emailField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Registration", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            if (userAuthentication.registerUser(username, password, email)) {
                JOptionPane.showMessageDialog(null, "User registered successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "User registration failed. Please check your details.");
            }
        }
    }

    private void showLoginDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            currentUser = userAuthentication.login(username, password);
            if (currentUser != null) {
                JOptionPane.showMessageDialog(null, "Login successful. Welcome, " + currentUser.getUsername() + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");
            }
        }
    }

    private void showProductList() {
        List<ProductFactory> products = catalog.getAllProducts();

        if (!products.isEmpty()) {
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (ProductFactory product : products) {
                String productInfo = product.getName() + " - $" + product.getPrice()
                        + "\n Description: " + product.getDescription()
                        + "\n Quantity in Stock: " + product.getQuantityInStock() + "\n";
                listModel.addElement(productInfo);
            }

            JList<String> productListJList = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(productListJList);

            JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No products available in the catalog.", "Product List", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showAddToCartDialog() {
        if (currentUser != null) {
            JTextField productNameField = new JTextField();

            Object[] message = {
                    "Enter the product name to add to the cart:", productNameField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Add to Cart", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                String productName = productNameField.getText();
                ProductFactory selectedProduct = findProductByName(catalog.getAllProducts(), productName);

                if (selectedProduct != null) {
                    shoppingCart.addItem(selectedProduct, 1);
                    JOptionPane.showMessageDialog(null, "Product added to the cart.");
                } else {
                    JOptionPane.showMessageDialog(null, "Product not found in the catalog.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You need to log in to add products to the cart.");
        }
    }

    private void removeFromCartDialog() {
        if (currentUser != null) {
            Map<ProductFactory, Integer> cartItems = shoppingCart.getItems();

            if (!cartItems.isEmpty()) {
                JTextField productNameField = new JTextField();

                Object[] message = {
                        "Enter the product name to remove from the cart:", productNameField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Remove from Cart", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String productName = productNameField.getText();
                    ProductFactory productToRemove = findProductByName(catalog.getAllProducts(), productName);

                    if (productToRemove != null) {
                        shoppingCart.removeItem(productToRemove);
                        JOptionPane.showMessageDialog(null, "Product removed from the cart.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Product not found in the cart.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Remove from Cart", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You need to log in to remove products from the cart.");
        }
    }

    private void showCart() {
        Map<ProductFactory, Integer> cartItems = shoppingCart.getItems();

        if (!cartItems.isEmpty()) {
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (Map.Entry<ProductFactory, Integer> entry : cartItems.entrySet()) {
                ProductFactory item = entry.getKey();
                int quantity = entry.getValue();
                String itemInfo = item.getName() + " - $" + item.getPrice() + " (Quantity: " + quantity + ")";
                listModel.addElement(itemInfo);
            }

            JList<String> cartItemList = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(cartItemList);

            double totalPrice = shoppingCart.getTotalAmount();
            String totalPriceMessage = "Total Price: $" + totalPrice;

            JOptionPane.showMessageDialog(null, new Object[]{scrollPane, totalPriceMessage}, "Shopping Cart", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void placeOrder() {
        if (currentUser != null) {
            double totalPrice = shoppingCart.getTotalAmount();

            // Show payment method options
            String[] paymentMethods = {"Credit Card", "Debit Card", "Cash", "Applepay", "Samsungpay", "Googlepay"};
            String paymentMethod = (String) JOptionPane.showInputDialog(null, "Select payment method:",
                    "Payment", JOptionPane.QUESTION_MESSAGE, null, paymentMethods, paymentMethods[0]);

            if (paymentMethod != null) {
                boolean paymentSuccess = new PaymentProcessor(FileLogger.getInstance()).processPayment(totalPrice, paymentMethod);

                if (paymentSuccess) {
                    JOptionPane.showMessageDialog(null, "Order placed successfully. Payment received.");
                    shoppingCart.clearCart();
                } else {
                    JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Payment was not completed.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You need to log in to place an order.");
        }
    }

    private ProductFactory findProductByName(List<ProductFactory> products, String productName) {
        for (ProductFactory product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainClassGUI();
            }
        });
    }
}
