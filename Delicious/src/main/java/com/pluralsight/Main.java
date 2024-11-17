package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Initialize the scanner
        int choice;

        OrderMenu orderManager = new OrderMenu();

        // Run the application loop
        while(true) {
            System.out.println("----Welcome to Tife Delicious Bodega (Jenny from the block) -----");
            System.out.println("Yerr!! Could you Press 1 for a new order");
            System.out.println("Ight bet! Press 2 to exit this application");
            System.out.print("Facts! Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();  // Consume the newline left by nextInt()

            if(choice == 1) {
                // Code for new order (this block can be expanded later)
                System.out.println("Wait! Damn! New order started...");
                orderManager.createOrder(in);
                // Add your code for a new order here
            }
            else if(choice == 2) {
                System.out.println("Thank you for visiting my NYC Bodega!");
                break;  // Exit the loop when choice is 2
            }
            else {
                System.out.println("Hurt! Thank you come again! Invalid choice. Please try again.");
            }
        }

        in.close();  // Close the scanner after exiting the loop
    }

}


