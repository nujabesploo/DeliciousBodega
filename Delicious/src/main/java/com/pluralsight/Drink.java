package com.pluralsight;
import java.util.Scanner;

public class Drink {
    private String size;
    private String flavor;

    public void customize(Scanner scanner) {
        System.out.println("Select drink size (Small, Medium, Large): ");
        size = scanner.nextLine().trim();

        System.out.println("Select drink flavor (e.g., Cola, Lemonade, Root Beer): ");
        flavor = scanner.nextLine().trim();
    }

    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return "Drink - Size: " + size + ", Flavor: " + flavor + " - $" + String.format("%.2f", getPrice());
    }
    // Additional methods for price calculation based on size can be added here
}
