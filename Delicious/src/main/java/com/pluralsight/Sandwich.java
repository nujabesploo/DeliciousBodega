package com.pluralsight;
import java.util.*;

public class Sandwich {
        private String breadType;
        private int size;
        private List<String> meats = new ArrayList<>();
        private List<String> extraMeats = new ArrayList<>();
        private List<String> cheeses = new ArrayList<>();
        private List<String> extraCheeses = new ArrayList<>();
        private List<String> otherToppings = new ArrayList<>();
        private List<String> sauces = new ArrayList<>();
        private boolean toasted;

        // Customize sandwich
        public void customize(Scanner scanner) {
            System.out.print("Type of bread you feeling: (white, wheat, rye, wrap): ");
            breadType = scanner.nextLine().trim();

            System.out.print("You wanna (4, 8, 12 inches) Pause! No diddy!: ");
            size = scanner.nextInt(); scanner.nextLine(); // consume newline

            addToppings(scanner);

            System.out.print("How you like em? Toasted? (yes/no): ");
            toasted = scanner.nextLine().equalsIgnoreCase("yes");
        }

        // Add toppings like meats, cheeses, sauces
        private void addToppings(Scanner scanner) {
            int choice;
            choice = -1;  // Initialize with a non-zero value to enter the loop
            while (choice != 0) {
                System.out.println("\n1) Add Meats (Pause) \n2) Add Cheeses\n3) Add Other Toppings\n4) Add Sauces\n0) Done");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1: addItems(scanner, "Meats? No funny stuff! Select your type of meat (comma-separated list): steak, ham, salami, roast beef, chicken, bacon", meats, extraMeats); break;
                    case 2: addItems(scanner, "cheese? (comma-separated list): cheddar, mozzarella, swiss, provolone, gouda ", cheeses, extraCheeses); break;
                    case 3: addOtherToppings(scanner); break;
                    case 4: addSauces(scanner); break;
                    case 0: System.out.println("Ayo!!! Finished adding toppings."); break;
                    default: System.out.println("Invalid option.");
                }
            }

        }

        // Add items to lists (e.g., meats, cheeses)
        private void addItems(Scanner scanner, String type, List<String> regular, List<String> extra) {
            System.out.print("Just Enter " + type + " (comma-separated): ");
            String input = scanner.nextLine();
            Collections.addAll(regular, input.split(","));

            System.out.print("Tryna Add extra? " + type + "? (yes/no)>: ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter extra " + type + " (comma-separated): ");
                input = scanner.nextLine();
                Collections.addAll(extra, input.split(","));
            }
        }



    private void addMeats(Scanner scanner) {
        System.out.println("No funny stuff! Select yor type of meat (comma-separated list): steak, ham, salami, roast beef, chicken, bacon");
        String meatInput = scanner.nextLine();
        for (String meat : meatInput.split(",")) {
            meats.add(meat.trim());
        }
    }
    private void addCheese(Scanner scanner) {
        System.out.println("Theres mad cheese? what type you want? (comma-separated list): cheddar, mozzarella, swiss, provolone, gouda");
        String cheeseInput = scanner.nextLine();
        for (String cheese : cheeseInput.split(",")) {
            cheeses.add(cheese.trim());  // Add cheese to the list
        }
    }
    private void addExtraCheese(Scanner scanner) {
        System.out.println("Select extra cheeses (comma-separated list): cheddar, mozzarella, parmesan, feta, blue cheese");
        String extraCheeseInput = scanner.nextLine();
        for (String extraCheese : extraCheeseInput.split(",")) {
            extraCheeses.add(extraCheese.trim());  // Add extra cheese to the list
        }
    }
    private void addExtraMeats(Scanner scanner) {
        System.out.println("Select extra meats (comma-separated list): bacon, pepperoni, sausage, turkey, lamb");
        String extraMeatInput = scanner.nextLine();
        for (String extraMeat : extraMeatInput.split(",")) {
            extraMeats.add(extraMeat.trim());  // Add extra meats to the list
        }
    }

    // Add other toppings (e.g., lettuce, peppers)
        private void addOtherToppings(Scanner scanner) {
            System.out.print("You want other toppings on that my guy(comma-separated): lettuce, peppers, onions: ");
            String input = scanner.nextLine();
            Collections.addAll(otherToppings, input.split(","));

            System.out.print("Add extra toppings? You thought i feeling you? Choose son? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter extra toppings (comma-separated): ");
                input = scanner.nextLine();
                Collections.addAll(otherToppings, input.split(","));
            }
        }

        // Add sauces
        private void addSauces(Scanner scanner) {
            System.out.print("Say no more! Type sauce y'all got (comma-separated): mayo, mustard, ketchup: ");
            String input = scanner.nextLine();
            Collections.addAll(sauces, input.split(","));

            System.out.print("Add extra sauces? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter extra sauces (comma-separated): ");
                input = scanner.nextLine();
                Collections.addAll(sauces, input.split(","));
            }
        }



        // Calculate the sandwich price
        public double getPrice() {
            double basePrice = switch (size) {
                case 4 -> 5.50;
                case 8 -> 7.00;
                case 12 -> 8.50;
                default -> 0.0;
            };

            return basePrice
                    + calculatePrice(meats, 1.00, 2.00, 3.00)
                    + calculatePrice(extraMeats, 0.50, 1.00, 1.50)
                    + calculatePrice(cheeses, 0.75, 1.50, 2.25)
                    + calculatePrice(extraCheeses, 0.30, 0.60, 0.90);
        }

        // Helper to calculate price based on item list and sandwich size
        private double calculatePrice(List<String> items, double small, double medium, double large) {
            double price = 0;
            for (String item : items) {
                price += item.contains("(extra)") ? (size == 4 ? small : size == 8 ? medium : large) : 1.00;
            }
            return price;
        }

        // Display sandwich details
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(size).append("\" ").append(breadType).append(" bread with ");
            appendList(sb, "Meats", meats);
            appendList(sb, "Extra Meats", extraMeats);
            appendList(sb, "Cheeses", cheeses);
            appendList(sb, "Extra Cheeses", extraCheeses);
            appendList(sb, "Other Toppings", otherToppings);
            appendList(sb, "Sauces", sauces);

            if (toasted) sb.append(" (toasted)");

            sb.append(" - Price: $").append(String.format("%.2f", getPrice()));
            return sb.toString();
        }

        // Helper method to append items list to the string
        private void appendList(StringBuilder sb, String label, List<String> items) {
            if (!items.isEmpty()) {
                sb.append(label).append(": ").append(String.join(", ", items)).append(", ");
            }
        }
    }





