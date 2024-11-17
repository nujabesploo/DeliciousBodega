package com.pluralsight;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenu {
    private List<Order> orders = new ArrayList<>();

    public void createOrder(Scanner in) {
        Order order = new Order();  // Create a new order
        int choice;

        while (true) {
            // Display the menu
            System.out.println("---- Order Menu ----");
            System.out.println("Press 1 to Add Sandwich");
            System.out.println("Don't forget the Bev, Press 2 to Add Drink");
            System.out.println("Press 3 to Add Chips");
            System.out.println("Press 4 to Checkout");
            System.out.println("Press 0 to Cancel Order");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();  // Read user input
            in.nextLine();  // Consume the newline character left by nextInt()

            // Perform the action based on user choice
            if (choice == 1) {
                order.addSandwich(in);  // Add a sandwich
            } else if (choice == 2) {
                order.addDrink(in);  // Add a drink
            } else if (choice == 3) {
                order.addChips(in);  // Add chips
            } else if (choice == 4) {
                checkoutOrder(order); // Proceed to checkout
            } else if (choice == 0) { // Cancel Order
                System.out.println("Order canceled.");
                break;  // Exit loop if order is canceled
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
    


    private void checkoutOrder(Order order) {
        // Display order details
        order.displayOrder();

        // Prompt for confirmation
        Scanner in = new Scanner(System.in);
        System.out.println("Its dumb brick outside! you want to confirm the order? (yes/no): ");
        String userInput = in.nextLine().trim().toLowerCase();

        if ("yes".equals(userInput)) {
            // Proceed with saving the receipt and adding to orders
            System.out.println("Order confirmed!");
            order.saveReceipt();
            orders.add(order);

        } else {
            System.out.println("Order canceled.");
        }
    }

}
