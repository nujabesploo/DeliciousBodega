package com.pluralsight;

import java.util.Scanner;

public class Chips {

    private String type;

    public void customize(Scanner in)
    {
        System.out.println("You're Bugging! You're a munch! Select your type of chips be out (e.g., Plain, BBQ, Sour Cream & Onion, Salt & Vinegar): ");
        type = in.nextLine().trim();
    }

    public double getPrice() {
        return 1.50; // Fixed price for chips
    }

    @Override
    public String toString() {
        return "Chips - Type: " + type + " - $" + String.format("%.2f", getPrice());
    }

    // Additional methods for pricing can be added here if necessary
    }


