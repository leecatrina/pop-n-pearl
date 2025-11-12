package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // Premium toppings (extra charge)
        Topping boba = new Topping("Boba", "Premium", 0.50, 1.00, 1.50, true);
        Topping pudding = new Topping("Pudding", "Premium", 0.75, 1.25, 1.75, true);

        // Regular toppings (free)
        Topping jelly = new Topping("Jelly", "Regular");

        // Create a list of toppings
        List<Topping> toppings1 = new ArrayList<>();
        toppings1.add(boba);
        toppings1.add(jelly);

        List<Topping> toppings2 = new ArrayList<>();
        toppings2.add(pudding);

        // Create MilkTea objects
        MilkTea tea1 = new MilkTea("Black Milk Tea", "Small", "Black");
        tea1.setToppings(toppings1);

        MilkTea tea2 = new MilkTea("Oolong Milk Tea", "Medium", "Oolong");
        tea2.setToppings(toppings2);
        tea2.setSpecialized(true);

        MilkTea tea3 = new MilkTea("Oat Milk Tea", "Large", "Oat"); // no toppings

        // Print details and prices
        System.out.println(tea1);
        System.out.println("Price: $" + tea1.calculatePrice());
        System.out.println();

        System.out.println(tea2);
        System.out.println("Price: $" + tea2.calculatePrice());
        System.out.println();

        System.out.println(tea3);
        System.out.println("Price: $" + tea3.calculatePrice());
    }
}
