import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + " (" + category + ") - ₹" + price;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 55000, "Electronics"),
                new Product("Smartphone", 25000, "Electronics"),
                new Product("TV", 40000, "Electronics"),
                new Product("Shirt", 1200, "Clothing"),
                new Product("Jeans", 1800, "Clothing"),
                new Product("Blender", 3500, "Home Appliances"),
                new Product("Microwave", 8000, "Home Appliances")
        );

        // Group products by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Grouped Products by Category:");
        grouped.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        // Find most expensive product in each category
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensive.forEach((category, product) -> {
            System.out.println(category + ": " + product.get().getName() + " - ₹" + product.get().getPrice());
        });

        // Calculate average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage Price of All Products: ₹" + avgPrice);
    }
}
