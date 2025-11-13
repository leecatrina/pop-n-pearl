package com.pluralsight.menu;

public class Side implements MenuItem {
   private String name;
   private double price;

    public Side(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //implement MenuItem methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculatePrice() {
        return price;
    }
    // to string
    public String toString() {
        return name + " ($" + price + ")";
    }
}
