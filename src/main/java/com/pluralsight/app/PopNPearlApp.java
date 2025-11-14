package com.pluralsight.app;

import com.pluralsight.menu.*;
import com.pluralsight.order.Order;
import com.pluralsight.order.Receipt;
import com.pluralsight.toppings.Topping;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.ui.UserInterface.ConsoleColors.*;


public class PopNPearlApp {
    public static int orderCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
        List<MenuItem> items = new ArrayList<>();

        // Display welcome screen

        UserInterface.displayWelcome();

        //=======Ask for name and phone number============

        String customerName = UserInterface.getNameInput(scanner);
        String phoneNumber = UserInterface.getPhoneInput(scanner);
        UserInterface.displayCustomerWelcome(customerName, phoneNumber);

        //=================Start menu==================

        showMainMenu(scanner, items, customerName);

            System.out.print("\nWould you like to place another order? (yes/no): ");
            String anotherOrder = scanner.nextLine().trim().toLowerCase();
            if (!anotherOrder.equals("yes") && !anotherOrder.equals("y")) {
                break;  // Exit the loop and end program
            }
        }

        scanner.close();
        System.out.println("👋 Thank you for Pop N' by!~~");

    }

    public static void showMainMenu(Scanner scanner, List<MenuItem> items, String customerName) {
        boolean ordering = true;

        while (ordering) {
            UserInterface.displayMainMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        MilkTea milkTea = createMilkTea(scanner);
                        if (milkTea != null) {
                            items.add(milkTea);
                        }
                        break;
                    case 2:
                        SignatureMilkTea signatureMilkTea = createSignatureMilkTea(scanner);
                        if (signatureMilkTea != null) {
                            items.add(signatureMilkTea);
                        }
                        break;
                    case 3:
                        Drink drink = createDrink(scanner);
                        if (drink != null) {
                            items.add(drink);
                        }
                        break;
                    case 4:
                        Side side = createSide(scanner);
                        if (side != null) {
                            items.add(side);
                        }
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
    }

    //===================Create your own milk tea==========================

    public static MilkTea createMilkTea(Scanner scanner) {

        System.out.println("\n--- Build Your Milk Tea ---");

        // TEA BASE - Multiple Choice
        String baseType = "";
        while (true) {
            System.out.println("\nChoose your tea base:");
            System.out.println("1. Black Tea 🫖");
            System.out.println("2. Oolong Tea 🫖");
            System.out.println("3. Green Tea 🫖");
            System.out.println("4. Almond Milk 🥛");
            System.out.println("5. Back to Main Menu 🔙");
            System.out.print("Enter your choice (1-5): ");

            try {
                int baseChoice = Integer.parseInt(scanner.nextLine());
                switch (baseChoice) {
                    case 1:
                        baseType = "Black Tea";
                        break;
                    case 2:
                        baseType = "Oolong Tea";
                        break;
                    case 3:
                        baseType = "Green Tea";
                        break;
                    case 4:
                        baseType = "Almond Milk";
                        break;
                    case 5:
                        return null;
                    default:
                        System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice! Please enter 1-4." + UserInterface.ConsoleColors.RESET);
                        continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please enter a number 1-4." + UserInterface.ConsoleColors.RESET);
            }
        }

        // FLAVOR - Multiple Choice
        System.out.println("\nChoose your flavor:");
        System.out.println("1. Classic Milk Tea 🧋");
        System.out.println("2. Taro 🍠");
        System.out.println("3. Thai Tea 🧋");
        System.out.println("4. Matcha 🍵");
        System.out.println("5. Honeydew 🍈");
        System.out.print("Enter your choice (1-5): ");

        String flavor = "";
        try {
            int flavorChoice = Integer.parseInt(scanner.nextLine());
            flavor = switch (flavorChoice) {
                case 1 -> "Classic Milk Tea";
                case 2 -> "Taro";
                case 3 -> "Thai Tea";
                case 4 -> "Matcha";
                case 5 -> "Honeydew";
                default -> {
                    System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice, Please select a base" + UserInterface.ConsoleColors.RESET);
                    yield "Classic Milk Tea";
                }
            };
        } catch (NumberFormatException e) {
            System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please select a base." + UserInterface.ConsoleColors.RESET);
        }

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

            System.out.print("\nWould you like to add a topping? (Enter 'yes' to add topping, 'no' to finish): ");
            String addTopping = scanner.nextLine().trim().toLowerCase();

            // Accept multiple ways to say yes/no

            if (addTopping.equals("yes") || addTopping.equals("y") || addTopping.equals("add")) {
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
                            topping = new Topping("Popping Boba", 0.50, 0.75, "Premium", 1.00, true);
                            break;
                        default:
                            System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid topping choice! Please enter 1-8." + UserInterface.ConsoleColors.RESET);
                    }

                    if (topping != null) {
                        milkTea.addTopping(topping);
                        System.out.println("✅ Added " + topping.getName());

                        // add ANOTHER topping

                        System.out.print("Add another topping? (yes/no): ");
                        String another = scanner.nextLine().trim().toLowerCase();

                        if (another.equals("no") || another.equals("n")) {
                            addingToppings = false;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please enter a number (1-8)." + UserInterface.ConsoleColors.RESET);
                }
            } else if (addTopping.equals("no") || addTopping.equals("n") || addTopping.equals("done")) {
                addingToppings = false;
            } else {
                // Check if accidentally entered a topping number
                try {
                    int number = Integer.parseInt(addTopping);
                    if (number >= 1 && number <= 8) {
                        System.out.println(UserInterface.ConsoleColors.RED + "❌ It looks like you entered a topping number. Please type 'yes' first, then enter the number." + UserInterface.ConsoleColors.RESET);
                    } else {
                        System.out.println(UserInterface.ConsoleColors.RED + "❌ Please enter 'yes' or 'no'." + UserInterface.ConsoleColors.RESET);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(UserInterface.ConsoleColors.RED + "❌ Please enter 'yes' or 'no'." + UserInterface.ConsoleColors.RESET);
                }
            }
        }
        System.out.println(UserInterface.ConsoleColors.GREEN + "✅ " + milkTea.getName() + " added to order - $" + milkTea.calculatePrice() + UserInterface.ConsoleColors.RESET);

        return milkTea;
    }

    //==========================Signature Milk Tea==============================

    public static SignatureMilkTea createSignatureMilkTea(Scanner scanner) {
        System.out.println("\n--- Signature Milk Tea ---");

        String name = "";
        while(true) {
            System.out.println("Available Signature Drinks: ");
            System.out.println("1. " + RED + "Seasonal Special - " + RESET + "Peppermint Matcha Latte 🍵❄️");
            System.out.println(GREEN + "{DESC: Green tea latte with minty freshness and cloud-like matcha foam}" + RESET);
            System.out.println("2. Brown Sugar Milk Tea 🧋");
            System.out.println(GREEN + "{DESC: Creamy milk tea with rich brown sugar pearls and caramel drizzle}" + RESET);
            System.out.println("3. Mango Breeze 🍹");
            System.out.println(GREEN + "{DESC: Refreshing mango green tea with fresh mango chunks and coconut jelly}" + RESET);
            System.out.println("4. Ube Dream 🧋🍠");
            System.out.println(GREEN + "{DESC: Velvety ube milk tea with creamy ube pudding}" + RESET);
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
                        name = "Ube Dream";
                        break;
                    default:
                        System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice, Please enter 1-4." + UserInterface.ConsoleColors.RESET);
                        continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Enter a number 1-4 or 'B' to go back. " + UserInterface.ConsoleColors.RESET);
            }
        }
        String size = UserInterface.getValidSize(scanner);
        SignatureMilkTea signatureMilkTea = new SignatureMilkTea(name, size);

        // ADD TOPPINGS FOR SIGNATURE DRINKS

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
                            topping = new Topping("Popping Boba", 0.50, 0.75, "Premium", 1.00, true);
                            break;
                        default:
                            System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid topping choice! Please enter 1-8." + UserInterface.ConsoleColors.RESET);
                    }

                    if (topping != null) {
                        signatureMilkTea.addTopping(topping);
                        System.out.println("✅ Added " + topping.getName());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input! Please enter a number (1-8).");
                }
            } else if (addTopping.equalsIgnoreCase("no")) {
                addingToppings = false;
            } else {
                System.out.println(UserInterface.ConsoleColors.RED + "❌ Please enter 'yes' or 'no'." + UserInterface.ConsoleColors.RESET);
            }
        }
        System.out.println(UserInterface.ConsoleColors.GREEN + "✅ " + signatureMilkTea.getName() + " added to order - $" + signatureMilkTea.calculatePrice() + UserInterface.ConsoleColors.RESET);

        return signatureMilkTea;
    }

    // ====================OTHER DRINKS===============================

    public static Drink createDrink(Scanner scanner) {
        System.out.println("\n--- Drinks Menu ---");

        String name = "";
        while (true) {
            System.out.println("Available Drinks:");
            System.out.println("1. Lemonade 🍋");
            System.out.println("2. Fruit Tea 🍉");
            System.out.println("3. Smoothie 🍍");
            System.out.println("4. Iced Coffee ☕");
            System.out.println("5. Back to Main Menu 🔙");
            System.out.print("Enter your choice (1-5): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        name = "Lemonade";
                        break;
                    case 2:
                        name = "Fruit Tea";
                        break;
                    case 3:
                        name = "Smoothie";
                        break;
                    case 4:
                        name = "Iced Coffee";
                        break;
                    case 5:
                        return null;
                    default:
                        System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid choice! Please enter 1-5." + UserInterface.ConsoleColors.RESET);
                        continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please enter a number 1-5." + UserInterface.ConsoleColors.RESET);
            }
        }
        String size = UserInterface.getValidSize(scanner);
        Drink drink = new Drink(name, size, 3.00, 4.00, 5.00);

        // ADD CONFIRMATION MESSAGE
        System.out.println(UserInterface.ConsoleColors.GREEN + "✅ " + drink.getName() + " added to order - $" + drink.calculatePrice() + UserInterface.ConsoleColors.RESET);

        return drink;
    }

    //==================SIDES=================================

    public static Side createSide(Scanner scanner) {
        System.out.println("\n--- Sides Menu ---");
        System.out.println("1. Popcorn Chicken 🍗 - $4.50");
        System.out.println("2. Spring Rolls - $3.50");
        System.out.println("3. Takoyaki 🐙 - $4.50");
        System.out.println("4. Fries 🍟- $2.50");
        System.out.println("5. Back to Main Menu 🔙");

        while (true) {
            System.out.print("Enter side number (1-5): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                Side side = null;

                switch (choice) {
                    case 1:
                        side = new Side("Popcorn Chicken", 4.50);
                        break;
                    case 2:
                        side = new Side("Spring Rolls", 3.50);
                        break;
                    case 3:
                        side = new Side("Takoyaki", 4.50);
                        break;
                    case 4:
                        side = new Side("Fries", 2.50);
                        break;
                    case 5:
                        System.out.println("↩️ Returning to Main Menu...");
                        return null;
                    default:
                        System.out.println(UserInterface.ConsoleColors.RED + "Invalid choice! Please enter a number 1-5." + UserInterface.ConsoleColors.RESET);
                        continue;
                }

                System.out.println(UserInterface.ConsoleColors.GREEN + "✅ " + side.getName() + " added to order - $" + side.calculatePrice() + UserInterface.ConsoleColors.RESET);
                return side;

            } catch (NumberFormatException e) {
                System.out.println(UserInterface.ConsoleColors.RED + "❌ Invalid input! Please enter a number (1-4)." + UserInterface.ConsoleColors.RESET);
            }
        }
    }
}

