package Shopping;

import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    public static List<ProductFactory> loadProducts() {
        List<ProductFactory> products = new ArrayList<>();

        Appliances Refrigerators = new Appliances("Refrigerators", 1499.99, "whirlpool", 10);
        Appliances Dishwasher = new Appliances("Dishwashers", 1199.99, "Bosch", 15);
        Appliances Washingmachine = new Appliances("Washing Machine", 1699.99, "Top Load Washers", 12);
        Appliances Microwave = new Appliances("Microwave", 799.99, "Counter Top Microwave", 17);

        Kids Baskets = new Kids("Baskets", 109.99, "Nike", 13);
        Kids CricketBat = new Kids("CricketBat", 1000, "SS", 10);
        Kids Balls = new Kids("Balls", 299.99, "Rocket", 10);

        Groceries Rice = new Groceries("Rice", 30, "Swad", 10);
        Groceries WheatFlour = new Groceries("WheatFlour", 22, "Freshfarm", 7);
        Groceries Oil = new Groceries("Oil", 17, "Sun Flower", 20);

        Accessories Bands = new Accessories("Bands", 19, "Silk", 10);
        Accessories Pins = new Accessories("Pins", 29, "Plastic", 15);
        Accessories Bag = new Accessories("Bag", 150, "OldNavy", 9);

        Stationary Pens = new Stationary("Pens", 79, "Cello", 20);
        Stationary Pencils = new Stationary("Pencils", 49.99, "Apsara", 30);

        products.add(Refrigerators);
        products.add(Dishwasher);
        products.add(Washingmachine);
        products.add(Microwave);
        products.add(Baskets);
        products.add(CricketBat);
        products.add(Balls);
        products.add(Rice);
        products.add(WheatFlour);
        products.add(Oil);
        products.add(Bands);
        products.add(Pins);
        products.add(Bag);
        products.add(Pens);
        products.add(Pencils);

        return products;
    }
}
