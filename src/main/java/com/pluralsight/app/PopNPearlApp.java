package com.pluralsight.app;

import com.pluralsight.menu.*;
import com.pluralsight.order.Order;
import com.pluralsight.order.Receipt;
import com.pluralsight.toppings.Topping;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PopNPearlApp {
    public static int orderCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> items = new ArrayList<>();

        // Display welcome screen

        UserInterface.displayWelcome();

        //=======Ask for name and phone number============

        String customerName = UserInterface.getNameInput(scanner);
        String phoneNumber = UserInterface.getPhoneInput(scanner);

        UserInterface.displayCustomerWelcome(customerName, phoneNumber);

        //=================Start menu==================

        showMainMenu(scanner, items, customerName);
    }

    public static void showMainMenu(Scanner scanner, List<MenuItem> items, String customerName) {
        boolean ordering = true;

        while (ordering) {
            UserInterface.displayMainMenu();

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
                        UserInterface.displayFullMenu();
                        break;
                    case 6:
                        ordering = false;
                        break;
                    default:
                        System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice! Please enter a number 1-6." + UserInterface.ConsoleColors.RESET);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please enter a number (1-6)." + UserInterface.ConsoleColors.RESET);
            }
        }

        //=================Display order summary=====================

        UserInterface.displayOrderSummaryHeader();

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

        UserInterface.displayOrderComplete(orderCounter);
        orderCounter++; //order counter, increments for the next order
        scanner.close();
    }

    //===================Create your own milk tea==========================
    public static MilkTea createMilkTea(Scanner scanner) {
        System.out.println("\n--- Build Your Milk Tea ---");
        System.out.println("Tea Base Options: Black, Oolong, Green, Almond Milk");
        System.out.println("Flavor Options: Classic Milk Tea, Taro, Thai Tea, , ");
        System.out.print("Enter tea base: ");
        String baseType = scanner.nextLine();

        System.out.print("Enter tea flavor: ");
        String flavor = scanner.nextLine();

        String size = UserInterface.getValidSize(scanner);

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
            UserInterface.showToppingMenu();
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
                            System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid topping choice! Please enter 1-8." + UserInterface.ConsoleColors.RESET);
                    }

                    if (topping != null) {
                        milkTea.addTopping(topping);
                        System.out.println("✅ Added " + topping.getName());
                    }
                } catch (NumberFormatException e) {
                    System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please enter a number (1-8)." + UserInterface.ConsoleColors.RESET);
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
                    System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice, Please enter 1-4." + UserInterface.ConsoleColors.RESET);
            }
        } catch (NumberFormatException e) {
            System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Enter a number 1-4 or 'B' to go back. " + UserInterface.ConsoleColors.RESET);
        }

        String size = UserInterface.getValidSize(scanner);

        return new SignatureMilkTea(name, size);
    }

    // ====================OTHER DRINKS===============================

    public static Drink createDrink(Scanner scanner) {
        System.out.println("\n--- Drinks Menu ---");
        System.out.println("Popular: Lemonade, Fruit Tea, Smoothie");
        System.out.print("Enter drink name: ");
        String name = scanner.nextLine();

        String size = UserInterface.getValidSize(scanner);

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
                    System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice, defaulting to Fries" + UserInterface.ConsoleColors.RESET);
                    return new Side("Fries", 2.50);
            }
        } catch (NumberFormatException e) {
            System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Defaulting to Fries." + UserInterface.ConsoleColors.RESET);
            return new Side("Fries", 2.50);
        }
    }
}

