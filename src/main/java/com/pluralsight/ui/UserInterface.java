package com.pluralsight.ui;

import com.pluralsight.menu.*;
import com.pluralsight.order.Order;
import com.pluralsight.order.Receipt;
import com.pluralsight.toppings.Topping;

import java.util.Scanner;

public class UserInterface {

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
    //==============================DISPLAY METHODS===============================================

    public static void displayWelcome() {
        System.out.println(ConsoleColors.MAGENTA + "__        __     _                                _            \n" +
                "\\ \\      / /___ | |  ___  ___   _ __ ___    ___  | |_  ___     \n" +
                " \\ \\ /\\ / // _ \\| | / __|/ _ \\ | '_ ` _ \\  / _ \\ | __|/ _ \\    \n" +
                "  \\ V  V /|  __/| || (__| (_) || | | | | ||  __/ | |_| (_) |   \n" +
                " __\\_/\\_/  \\___||_| \\___|\\___/ |_|_|_| |_| \\___|  \\__|\\___/  _ \n" +
                ConsoleColors.PINK + "|  _ \\  ___   _ __   | \\ | |( ) |  _ \\  ___   __ _  _ __ | || |\n" +
                "| |_) |/ _ \\ | '_ \\  |  \\| ||/  | |_) |/ _ \\ / _` || '__|| || |\n" +
                "|  __/| (_) || |_) | | |\\  |    |  __/|  __/| (_| || |   | ||_|\n" +
                "|_|    \\___/ | .__/  |_| \\_|    |_|    \\___| \\__,_||_|   |_|(_)\n" +
                "             |_|                                               " + ConsoleColors.RESET); // uhh this looks like computer throw up.. #trust the process

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
    }

    //===================INPUT==================================================

    public static String getNameInput(Scanner scanner) {
        while (true) {
            System.out.print(ConsoleColors.GREEN + " [Please enter your name] : " + ConsoleColors.RESET);
            String customerName = scanner.nextLine().trim();

            if (!customerName.isEmpty()) {
                return customerName;
            } else {
                System.out.println(ConsoleColors.RED + "❌ Name cannot be empty!" + ConsoleColors.RESET);
            }
        }
    }

    public static String getPhoneInput(Scanner scanner) {
        while (true) {
            System.out.print(ConsoleColors.GREEN + "[Please enter your phone number] : " + ConsoleColors.RESET);
            String phoneNumber = scanner.nextLine().trim();

            boolean valid = true;
            for (char c : phoneNumber.toCharArray()) {
                if (!Character.isDigit(c)) {
                    valid = false;
                    break;
                }
            }

            if (valid && !phoneNumber.isEmpty()) {
                return phoneNumber;
            } else {
                System.out.println(ConsoleColors.RED + "❌ Invalid phone number! Only digits are allowed." + ConsoleColors.RESET);
            }
        }
    }

    public static String getValidSize(Scanner scanner) {
        while (true) {
            System.out.print("Enter size (Small/Medium/Large): ");
            String size = scanner.nextLine().trim();

            if (size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("Large")) {
                return size.substring(0, 1).toUpperCase() + size.substring(1).toLowerCase(); // Format nicely
            } else {
                System.out.println(ConsoleColors.RED + "❌ Invalid size! Please enter Small, Medium, or Large." + ConsoleColors.RESET);
            }
        }
    }

    //==============================MENU DISPLAYS===============================================

    public static void displayCustomerWelcome(String customerName, String phoneNumber) {
        System.out.println("\nThank you, " + customerName + "!");
        System.out.println("Your phone number: " + phoneNumber);
        System.out.println("Let's start your order!\n");
    }

    public static void displayMainMenu() {
        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' MAIN MENU -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("1. Milk Tea 🧋");
        System.out.println("2. Signature Milk Tea ✨🧋");
        System.out.println("3. Drink 🥤");
        System.out.println("4. Side 🍗");
        System.out.println("5. View Full Menu 📃");
        System.out.println("6. Checkout 💳");
        System.out.println("0. Cancel Order ❌");
        System.out.print("Enter choice: ");
    }

    public static void displayFullMenu() {
        System.out.println(ConsoleColors.PINK + "\n╔════════════════════════════════════════════╗");
        System.out.println("║          🧋 POP N' PEARL MENU 🧋          ║");
        System.out.println("╚════════════════════════════════════════════╝" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' MILK TEA -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("Build your own custom milk tea!");
        System.out.println("Base Options: Black Tea, Oolong Tea, Green Tea, Almond Milk");
        System.out.println("Flavor Options: Classic Milk Tea, Taro, Thai Tea, Honeydew");
        System.out.println("Sizes: Small ($4.00) | Medium ($5.00) | Large ($6.00)");

        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' AVAILABLE TOPPING -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("Regular (Free):");
        System.out.println("  • Boba (Tapioca Pearls)");
        System.out.println("  • Jelly");
        System.out.println("  • Pudding");
        System.out.println("  • Aloe Vera");
        System.out.println("\nPremium (+$0.50-$1.00):");
        System.out.println("  • Crystal Boba");
        System.out.println("  • Cheese Foam");
        System.out.println("  • Brown Sugar Boba");
        System.out.println("  • Popping Boba");

        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' SIGNATURE MILK TEA -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("Available Signature Drinks: ");
        System.out.println("1. Seasonal Special - Peppermint Matcha Latte ❄️ ");
        System.out.println("2. Brown Sugar Milk Tea 🧋");
        System.out.println("3. Mango Breeze 🍹");
        System.out.println("4. Ube Dream 🧋");
        System.out.println("Sizes: Small ($5.00) | Medium ($6.00) | Large ($7.00)");

        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' OTHER DRINKS -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("Fresh Lemonade🍋, Fruit Tea🍉, Smoothies🍍, etc.");
        System.out.println("Sizes: Small ($3.00) | Medium ($4.00) | Large ($5.00)");

        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' SIDES -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("Popcorn Chicken🍗 - $4.50");
        System.out.println("Spring Rolls - $3.50");
        System.out.println("Takoyaki 🐙- $4.50");
        System.out.println("Fries 🍟- $2.50");
        System.out.println("\n================================================");
    }

    public static void showToppingMenu() {
        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-'TOPPINGS -._,-'\"`-._,-'" + ConsoleColors.RESET);
        System.out.println("Regular (Free):");
        System.out.println("  1. Boba");
        System.out.println("  2. Jelly");
        System.out.println("  3. Pudding");
        System.out.println("  4. Aloe Vera");
        System.out.println("\nPremium (+$0.50-$1.00):");
        System.out.println("  5. Crystal Boba (+$0.50/0.75/1.00)");
        System.out.println("  6. Cheese Foam (+$0.75/1.00/1.25)");
        System.out.println("  7. Brown Sugar Boba (+$0.50/0.75/1.00)");
        System.out.println("  8. Popping Boba (+$0.50/0.75/1.00)");
    }

    public static void displayOrderSummaryHeader() {
        System.out.println(ConsoleColors.PINK + "\n-._,-'\"`-._,-' YOUR ORDER -._,-'\"`-._,-'" + ConsoleColors.RESET);
    }

    public static void displayOrderComplete(int orderCounter) {
        System.out.println("\n✅ Order complete! Thank you!");
        System.out.println("🎉 Your order number is " + orderCounter + " 🎉");
    }
}