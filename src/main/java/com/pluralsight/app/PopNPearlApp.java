package com.pluralsight.app;

import com.pluralsight.menu.*;
import com.pluralsight.order.Order;
import com.pluralsight.order.Receipt;
import com.pluralsight.toppings.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.app.PopNPearlApp.ConsoleColors.*;

public class PopNPearlApp {
    public static int orderCounter = 1;

    //Secret sauce ooOoO Makes everything preeeetyyyyyy :P
    public class ConsoleColors {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String BLUE = "\u001B[34m";
        public static final String ORANGE = "\u001B[93m";
        public static final String MAGENTA = "\u001B[95m";
        public static final String PINK = "\u001B[38;5;211m";
    }
    //==============================SIZE===============================================
    public static String getValidSize(Scanner scanner) {
        while (true) {
            System.out.print("Enter size (Small/Medium/Large): ");
            String size = scanner.nextLine().trim();

            if (size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("Large")) {
                return size.substring(0, 1).toUpperCase() + size.substring(1).toLowerCase(); // Format nicely
            } else {
                System.out.println("❌ Invalid size! Please enter Small, Medium, or Large.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> items = new ArrayList<>();

        System.out.println( MAGENTA + "__        __     _                                _            \n" +
                "\\ \\      / /___ | |  ___  ___   _ __ ___    ___  | |_  ___     \n" +
                " \\ \\ /\\ / // _ \\| | / __|/ _ \\ | '_ ` _ \\  / _ \\ | __|/ _ \\    \n" +
                "  \\ V  V /|  __/| || (__| (_) || | | | | ||  __/ | |_| (_) |   \n" +
                " __\\_/\\_/  \\___||_| \\___|\\___/ |_|_|_| |_| \\___|  \\__|\\___/  _ \n" +
               PINK + "|  _ \\  ___   _ __   | \\ | |( ) |  _ \\  ___   __ _  _ __ | || |\n" +
                "| |_) |/ _ \\ | '_ \\  |  \\| ||/  | |_) |/ _ \\ / _` || '__|| || |\n" +
                "|  __/| (_) || |_) | | |\\  |    |  __/|  __/| (_| || |   | ||_|\n" +
                "|_|    \\___/ | .__/  |_| \\_|    |_|    \\___| \\__,_||_|   |_|(_)\n" +
                "             |_|                                               " + RESET );

        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣴⣶⣶⣦⣤⣤⣤⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠉⣉⠉⠉⠹⣿⠀⠀⠀⠀⠀⠈⠉⠉⣉⠉⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢿⡇⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⢸⡿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡆⠘⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣷⠀⢻⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⡄⠸⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣧⠀⢿⣿⣿⡟⢻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡿⣿⠉⢻⡀⢸⡏⢉⡗⢺⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣄⣼⠛⢻⣇⣀⡟⢉⣷⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣧⣼⣷⣾⣅⣹⣿⣿⣤⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

        //=======Ask for name and phone number============

        String customerName;
        while (true) {
            System.out.print(GREEN + " [Please enter your name] : " + RESET);
            customerName = scanner.nextLine().trim();

            if (!customerName.isEmpty()) {
                break;
            } else {
                System.out.println(RED + "❌ Name cannot be empty!"+ RESET);
            }
        }

        //==========Ask for phone number=================
        String phoneNumber;
        while(true) {
            System.out.print(GREEN + "[Please enter your phone number] : " + RESET);
            phoneNumber = scanner.nextLine().trim();

            boolean valid = true;
            for (char c : phoneNumber.toCharArray()) {
                if (!Character.isDigit(c)) {
                    valid = false;
                    break;
                }
            }

            if (valid && !phoneNumber.isEmpty()) {
                break;
            } else {
                System.out.println(RED + "❌ Invalid phone number! Only digits are allowed." + RESET);
            }
        }

        System.out.println("\nThank you, " + customerName + "!");
        System.out.println("Your phone number: " + phoneNumber);
        System.out.println("Let's start your order!\n");

        //=================Start menu==================

        showMainMenu(scanner, items, customerName);
    }

    public static void showMainMenu(Scanner scanner, List<MenuItem> items, String customerName) {
        boolean ordering = true;

        while (ordering) {
            System.out.println(PINK + "\n-._,-'\"`-._,-' MAIN MENU -._,-'\"`-._,-'" + RESET);
            System.out.println("1. Milk Tea 🧋");
            System.out.println("2. Signature Milk Tea ✨🧋");
            System.out.println("3. Drink 🥤");
            System.out.println("4. Side 🍗");
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
                        System.out.println(RED + "❌ Invalid choice! Please enter a number 1-6." + RESET);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "❌ Invalid input! Please enter a number (1-6)." + RESET);
            }
        }

        //=================Display order summary=====================

        System.out.println(PINK + "\n-._,-'\"`-._,-' YOUR ORDER -._,-'\"`-._,-'" + RESET);
        if (items.isEmpty()) {
            System.out.println("No items ordered.");
        } else {
            for (MenuItem item : items) {
                System.out.println(item);
            }

            //===========Create order and print receipt====================

            Order order = new Order(items);
            Receipt receipt = new Receipt(order);
            receipt.printReceipt();
        }

        System.out.println("\n✅ Order complete! Thank you!");
        System.out.println("🎉 Your order number is " + orderCounter + " 🎉");
        orderCounter++; //order counter, increments for the next order
        scanner.close();
    }

    //================Display full menu========================

    public static void displayFullMenu() {
        System.out.println(PINK +"\n╔════════════════════════════════════════════╗");
        System.out.println("║          🧋 POP N' PEARL MENU 🧋          ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        System.out.println("\n--- MILK TEA ---");
        System.out.println("Build your own custom milk tea!");
        System.out.println("Base Options: Black Tea, Oolong Tea, Green Tea, Almond Milk");
        System.out.println("Flavor Options: Classic Milk Tea, Taro, Thai Tea, , ");
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
        System.out.println("Available Signature Drinks: ");
        System.out.println("1. House Special - Mango Breeze! 🍹");
        System.out.println("2. Brown Sugar Milk Tea");
        System.out.println("3. Matcha Latte");
        System.out.println("4. Taro Dream");

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

    //=======================Show topping menu=====================================

    public static void showToppingMenu() {
        System.out.println("\n-._,-'\"`-._,-' Available Toppings ---");
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

    //===================Create your own milk tea==========================

    public static MilkTea createMilkTea(Scanner scanner) {
        System.out.println("\n--- Build Your Milk Tea ---");
        System.out.println("Tea Base Options: Black, Oolong, Green, Almond Milk");
        System.out.println("Flavor Options: Classic Milk Tea, Taro, Thai Tea, , ");
        System.out.print("Enter tea base: ");
        String baseType = scanner.nextLine();

        System.out.print("Enter tea flavor: ");
        String flavor = scanner.nextLine();

        System.out.print("Enter size (Small/Medium/Large): ");
        String size = getValidSize(scanner);

        //  ICE LEVEL

        System.out.println("\nChoose ice level:");
        System.out.println("1. No Ice");
        System.out.println("2. Less Ice");
        System.out.println("3. Regular Ice");
        System.out.println("4. Extra Ice");
        System.out.print("Enter your choice: ");
        int iceChoice = Integer.parseInt(scanner.nextLine());
        String iceLevel = switch (iceChoice) {
            case 1 -> "No Ice";
            case 2 -> "Less Ice";
            case 3 -> "Regular Ice";
            case 4 -> "Extra Ice";
            default -> "Regular Ice";
        };

        //  SUGAR LEVEL

        System.out.println("\nChoose sugar level:");
        System.out.println("1. 0%");
        System.out.println("2. 25%");
        System.out.println("3. 50%");
        System.out.println("4. 75%");
        System.out.println("5. 100%");
        System.out.print("Enter your choice: ");
        int sugarChoice = Integer.parseInt(scanner.nextLine());
        String sugarLevel = switch (sugarChoice) {
            case 1 -> "0%";
            case 2 -> "25%";
            case 3 -> "50%";
            case 4 -> "75%";
            case 5 -> "100%";
            default -> "100%";
        };


        MilkTea milkTea = new MilkTea(flavor + " Milk Tea", size, baseType);

        // Store ice & sugar

        milkTea.setIceLevel(iceLevel);
        milkTea.setSugarLevel(sugarLevel);

        //==============================toppings==========================

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
    //==========================Signature Milk Tea==============================

    public static SignatureMilkTea createSignatureMilkTea(Scanner scanner) {
        System.out.println("\n--- Signature Milk Tea ---");

        String name = "";

        System.out.println("Available Signature Drinks: ");
        System.out.println("1. Seasonal Special - Peppermint Matcha Latte");
        System.out.println("2. Brown Sugar Milk Tea");
        System.out.println("3. Mango Breeze");
        System.out.println("4. Taro Dream");
        System.out.println("Enter the number of your choice (or 'B' to go back) ");

        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("B")) {
            return null; //go back to main menu
        }

        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    name = "Seasonal Special - Peppermint Matcha Latte:";
                    break;
                case 2:
                    name = "Brown Sugar Milk Tea";
                    break;
                case 3:
                    name = "Mango Breeze";
                    break;
                case 4:
                    name = "Taro Dream";
                    break;
                default:
                    System.out.println("❌ Invalid choice, Please enter 1-4.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Enter a number 1-4 or 'B' to go back. ");
        }
        System.out.print("Enter size (Small/Medium/Large): ");
        String size = getValidSize(scanner);

        return new SignatureMilkTea(name, size);
    }
    // ====================OTHER DRINKS===============================

    public static Drink createDrink(Scanner scanner) {
        System.out.println("\n--- Drinks Menu ---");
        System.out.println("Popular: Lemonade, Fruit Tea, Smoothie");
        System.out.print("Enter drink name: ");

        String name = scanner.nextLine();

        System.out.print("Enter size (Small/Medium/Large): ");
        String size = getValidSize(scanner);

        return new Drink(name, size, 3.00, 4.00, 5.00);
    }
    //==================SIDES=================================

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
