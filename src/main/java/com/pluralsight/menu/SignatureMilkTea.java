package com.pluralsight.menu;

import com.pluralsight.toppings.Topping;

import java.util.ArrayList;

public class SignatureMilkTea extends MilkTea {
    public SignatureMilkTea(String name, String size) {
        super(name, size, getBaseType(name));
    }

    private static String getBaseType(String name) {
        if (name.equalsIgnoreCase("Peppermint Matcha Latte") || name.equalsIgnoreCase("Mango Breeze")) {
            return "Green Tea";
        } else {
            return "Black Tea";
        }
    }

    @Override
    public double calculatePrice() {
        // Signature drinks cost more than regular milk tea
        double basePrice;
        switch (getSize().toLowerCase()) {
            case "small":
                basePrice = 5.00;
                break;
            case "medium":
                basePrice = 6.00;
                break;
            case "large":
                basePrice = 7.00;
                break;
            default:
                basePrice = 5.00;
        }

        // Add topping prices
        double toppingCost = 0.0;
        for (Topping t : getToppings()) {
            toppingCost += t.getPrice(getSize());
        }

        return basePrice + toppingCost;
    }
}
