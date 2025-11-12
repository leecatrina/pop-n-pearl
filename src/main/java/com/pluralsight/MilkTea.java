package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class MilkTea implements MenuItem {
    private String name;
    private String size;
    private String baseType; //black tea, Oolong tea, milk, oat milk
    private List<Topping> toppings;
    private boolean isSpecialized;

    public MilkTea(String name, String size, String baseType) {
        this.name = baseType + "Milk Tea";
        this.size = size;
        this.baseType = baseType;
        this.toppings = new ArrayList<>();
        this.isSpecialized = false;
    }
    //setters and getters

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isSpecialized() {
        return isSpecialized;
    }

    public void setSpecialized(boolean specialized) {
        isSpecialized = specialized;
    }
    //implemented from MenuItem

    @Override
    public String getName() {
        return name;
    }
    // base price

    @Override
    public double calculatePrice() {
        double basePrice;
        switch (size.toLowerCase()) {
            case "small":
                basePrice = 4.00;
                break;
            case "medium":
                basePrice = 5.00;
                break;
            case "large":
                basePrice = 6.00;
                break;
            default:
                basePrice = 0;
        }
        //topping price

        double toppingCost = 0.0;
        for (Topping t : toppings) {
            toppingCost += t.getPrice();
        }
        //extra cost if specialized
        if (isSpecialized) {
            basePrice += 1.00;
        }

        return basePrice + toppingCost;
    }

    //to string

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(size).append(") ");
        if (!toppings.isEmpty()) {
            sb.append("Toppings: ");
            for (Topping t : toppings) {
                sb.append(t.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // remove trailing comma
        }
        if (isSpecialized) {
            sb.append(" [Specialized]");
        }
        return sb.toString();
    }
}


