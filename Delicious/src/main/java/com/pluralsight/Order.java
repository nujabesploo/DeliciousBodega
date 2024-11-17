package com.pluralsight;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

    // Add a sandwich to the order
    public void addSandwich(Scanner in) {
        Sandwich sandwich = new Sandwich();
        sandwich.customize(in);
        sandwiches.add(sandwich);
    }

    // Add a drink to the order
    public void addDrink(Scanner in) {
        Drink drink = new Drink();
        drink.customize(in);
        drinks.add(drink);
    }

    // Add chips to the order
    public void addChips(Scanner in) {
        Chips chip = new Chips();
        chip.customize(in);
        chips.add(chip);
    }

    // Calculate the total price of the order
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chips c : chips) total += c.getPrice();
        return total;
    }

    // Display the order summary
    public void displayOrder() {
        System.out.println("Your Order:");
        sandwiches.forEach(System.out::println);
        drinks.forEach(System.out::println);
        chips.forEach(System.out::println);
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    // Save the order receipt to a file
    public void saveReceipt() {
        try {
            File receiptsDir = new File("receipts");
            if (!receiptsDir.exists()) receiptsDir.mkdirs();  // Create directory if necessary

            String fileName = "receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("Order Receipt\nDate: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\nItems Ordered:\n");
                writeItems(writer, "NYC Sandwiches", sandwiches);
                writeItems(writer, "Gas Station Drinks", drinks);
                writeItems(writer, "Around the block Chips", chips);
                writer.write("\nTotal Price: $" + String.format("%.2f", calculateTotalPrice()) + "\nThank you for your order!\n");

                System.out.println("Receipt saved as: " + fileName);
            }
        } catch (IOException e) {
            System.out.println("You're Wilding! Error saving receipt: " + e.getMessage());
        }
    }

    // Helper method to write items to the receipt
    private <T> void writeItems(FileWriter writer, String itemType, List<T> items) throws IOException {
        if (!items.isEmpty()) {
            writer.write("\n" + itemType + ":\n");
            for (T item : items) writer.write(item.toString() + "\n");
        }
    }


}