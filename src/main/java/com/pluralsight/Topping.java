package com.pluralsight;

public class Topping {
    private String name;
    private String category; // Regular or Premium
    private double priceSmall;
    private double priceMedium;
    private double priceLarge;
    private boolean isExtra; // true if it's an extra topping

    //Constructor for premium toppings (extra charge $$)

    public Topping(String name, double priceSmall, double priceMedium, String category, double priceLarge, boolean isExtra) {
        this.name = name;
        this.priceSmall = priceSmall;
        this.priceMedium = priceMedium;
        this.category = category;
        this.priceLarge = priceLarge;
        this.isExtra = isExtra;
    }
    //constructor for regular toppings (free)

    public Topping(String name, String category) {
        this.name = name;
        this.category = category;
        this.priceSmall = 0.0;
        this.priceMedium = 0.0;
        this.priceLarge = 0.0;
        this.isExtra = false;
    }
    //get price based on size

    public double getPrice(String size) {
        switch (size.toLowerCase()){
            case "small":
                return priceSmall;
            case "medium":
                return priceMedium;
            case "large":
                return priceLarge;
            default:
                return 0.0;
        }
    }
    //getters

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPriceSmall() {
        return priceSmall;
    }

    public double getPriceMedium() {
        return priceMedium;
    }

    public double getPriceLarge() {
        return priceLarge;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String toString() {
        return name + "(" + category + ")";
    }
}
