package com.pluralsight.app;

import com.pluralsight.menu.*;
import com.pluralsight.order.Order;
import com.pluralsight.order.Receipt;
import com.pluralsight.toppings.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PopNPearlApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> items = new ArrayList<>();

        System.out.println("__        __     _                                _            \n" +
                "\\ \\      / /___ | |  ___  ___   _ __ ___    ___  | |_  ___     \n" +
                " \\ \\ /\\ / // _ \\| | / __|/ _ \\ | '_ ` _ \\  / _ \\ | __|/ _ \\    \n" +
                "  \\ V  V /|  __/| || (__| (_) || | | | | ||  __/ | |_| (_) |   \n" +
                " __\\_/\\_/  \\___||_| \\___|\\___/ |_|_|_| |_| \\___|  \\__|\\___/  _ \n" +
                "|  _ \\  ___   _ __   | \\ | |( ) |  _ \\  ___   __ _  _ __ | || |\n" +
                "| |_) |/ _ \\ | '_ \\  |  \\| ||/  | |_) |/ _ \\ / _` || '__|| || |\n" +
                "|  __/| (_) || |_) | | |\\  |    |  __/|  __/| (_| || |   | ||_|\n" +
                "|_|    \\___/ | .__/  |_| \\_|    |_|    \\___| \\__,_||_|   |_|(_)\n" +
                "             |_|                                               ");
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n======== MAIN MENU ========");
            System.out.println("1. Milk Tea");
            System.out.println("2. Signature Milk Tea");
            System.out.println("3. Drink");
            System.out.println("4. Side");
            System.out.println("5. View Full Menu");
            System.out.println("6. Finish Order");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        items.add(createMilkTea(scanner));
                        break;
                    case 2:
                        items.add(createSignatureMilkTea(scanner));
                        break;
                    case 3:
                        items.add(createDrink(scanner));
                        break;
                    case 4:
                        items.add(createSide(scanner));
                        break;
                    case 5:
                        displayFullMenu();
                        break;
                    case 6:
                        ordering = false;
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please enter a number 1-6.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number (1-6).");
            }
        }

        // Display order summary
        System.out.println("\n======== YOUR ORDER ========");
        if (items.isEmpty()) {
            System.out.println("No items ordered.");
        } else {
            for (MenuItem item : items) {
                System.out.println(item);
            }

            // Create order and print receipt
            Order order = new Order(items);
            Receipt receipt = new Receipt(order);
            receipt.printReceipt();
        }

        System.out.println("\n✅ Order complete! Thank you!");
        scanner.close();
    }

    // Display full menu
    public static void displayFullMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║          🧋 POP N' PEARL MENU 🧋          ║");
        System.out.println("╚════════════════════════════════════════════╝");

        System.out.println("\n--- MILK TEA ---");
        System.out.println("Build your own custom milk tea!");
        System.out.println("Base Options: Black Tea, Oolong Tea, Green Tea");
        System.out.println("Sizes: Small ($4.00) | Medium ($5.00) | Large ($6.00)");

        System.out.println("\n--- AVAILABLE TOPPINGS ---");
        System.out.println("Regular (Free):");
        System.out.println("  • Boba (Tapioca Pearls)");
        System.out.println("  • Jelly");
        System.out.println("  • Pudding");
        System.out.println("  • Aloe Vera");
        System.out.println("\nPremium (+$0.50-$1.00):");
        System.out.println("  • Crystal Boba");
        System.out.println("  • Cheese Foam");
        System.out.println("  • Brown Sugar Boba");
        System.out.println("  • Oreo Crumble");

        System.out.println("\n--- SIGNATURE MILK TEAS ---");
        System.out.println("House Special - Mango Breeze! 🍹");
        System.out.println("Take a sip of sunshine! Our Mango Breeze blends creamy yogurt with juicy, real mango chunks for the perfect tropical smoothie.");
        System.out.println("Topped with a light, velvety cheese foam, it’s a sweet, tangy, and refreshingly smooth treat that feels like a summer getaway in every sip.");
        System.out.println("Sizes: Small ($5.00) | Medium ($6.00) | Large ($7.00)");

        System.out.println("\n--- DRINKS ---");
        System.out.println("Fresh Lemonade, Fruit Tea, Smoothies, etc.");
        System.out.println("Sizes: Small ($3.00) | Medium ($4.00) | Large ($5.00)");

        System.out.println("\n--- SIDES ---");
        System.out.println("Popcorn Chicken - $4.50");
        System.out.println("Spring Rolls - $3.50");
        System.out.println("Edamame - $2.50");
        System.out.println("Fries - $2.50");

        System.out.println("\n================================================");
    }

    // Show topping menu
    public static void showToppingMenu() {
        System.out.println("\n--- Available Toppings ---");
        System.out.println("Regular (Free):");
        System.out.println("  1. Boba");
        System.out.println("  2. Jelly");
        System.out.println("  3. Pudding");
        System.out.println("  4. Aloe Vera");
        System.out.println("\nPremium (+$0.50-$1.00):");
        System.out.println("  5. Crystal Boba (+$0.50/0.75/1.00)");
        System.out.println("  6. Cheese Foam (+$0.75/1.00/1.25)");
        System.out.println("  7. Brown Sugar Boba (+$0.50/0.75/1.00)");
        System.out.println("  8. Oreo Crumble (+$0.50/0.75/1.00)");
    }

    // Methods
    public static MilkTea createMilkTea(Scanner scanner) {
        System.out.println("\n--- Build Your Milk Tea ---");
        System.out.println("Tea Base Options: Black, Oolong, Green");
        System.out.print("Enter tea base: ");
        String baseType = scanner.nextLine();

        System.out.print("Enter size (Small/Medium/Large): ");
        String size = scanner.nextLine();

        MilkTea milkTea = new MilkTea("Custom Milk Tea", size, baseType);

        boolean addingToppings = true;
        while (addingToppings) {
            showToppingMenu();
            System.out.print("\nAdd topping? (yes/no): ");
            String addTopping = scanner.nextLine();

            if (addTopping.equalsIgnoreCase("yes")) {
                System.out.print("Enter topping number (1-8): ");
                try {
                    int toppingChoice = Integer.parseInt(scanner.nextLine());

                    Topping topping = null;
                    switch (toppingChoice) {
                        case 1:
                            topping = new Topping("Boba", "Regular");
                            break;
                        case 2:
                            topping = new Topping("Jelly", "Regular");
                            break;
                        case 3:
                            topping = new Topping("Pudding", "Regular");
                            break;
                        case 4:
                            topping = new Topping("Aloe Vera", "Regular");
                            break;
                        case 5:
                            topping = new Topping("Crystal Boba", 0.50, 0.75, "Premium", 1.00, true);
                            break;
                        case 6:
                            topping = new Topping("Cheese Foam", 0.75, 1.00, "Premium", 1.25, true);
                            break;
                        case 7:
                            topping = new Topping("Brown Sugar Boba", 0.50, 0.75, "Premium", 1.00, true);
                            break;
                        case 8:
                            topping = new Topping("Oreo Crumble", 0.50, 0.75, "Premium", 1.00, true);
                            break;
                        default:
                            System.out.println("❌ Invalid topping choice! Please enter 1-8.");
                    }

                    if (topping != null) {
                        milkTea.addTopping(topping);
                        System.out.println("✅ Added " + topping.getName());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input! Please enter a number (1-8).");
                }
            } else {
                addingToppings = false;
            }
        }

        return milkTea;
    }

    public static SignatureMilkTea createSignatureMilkTea(Scanner scanner) {
        System.out.println("\n--- Signature Milk Tea ---");
        System.out.println("House Special - Premium blend with special toppings");
        System.out.print("Enter size (Small/Medium/Large): ");
        String size = scanner.nextLine();
        return new SignatureMilkTea("House Special", size);
    }

    public static Drink createDrink(Scanner scanner) {
        System.out.println("\n--- Drinks Menu ---");
        System.out.println("Popular: Lemonade, Fruit Tea, Smoothie");
        System.out.print("Enter drink name: ");
        String name = scanner.nextLine();
        System.out.print("Enter size (Small/Medium/Large): ");
        String size = scanner.nextLine();
        return new Drink(name, size, 3.00, 4.00, 5.00);
    }

    public static Side createSide(Scanner scanner) {
        System.out.println("\n--- Sides Menu ---");
        System.out.println("1. Popcorn Chicken - $4.50");
        System.out.println("2. Spring Rolls - $3.50");
        System.out.println("3. Edamame - $2.50");
        System.out.println("4. Fries - $2.50");
        System.out.print("Enter side number (1-4): ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    return new Side("Popcorn Chicken", 4.50);
                case 2:
                    return new Side("Spring Rolls", 3.50);
                case 3:
                    return new Side("Edamame", 2.50);
                case 4:
                    return new Side("Fries", 2.50);
                default:
                    System.out.println("❌ Invalid choice, defaulting to Fries");
                    return new Side("Fries", 2.50);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Defaulting to Fries.");
            return new Side("Fries", 2.50);
        }
    }
}
