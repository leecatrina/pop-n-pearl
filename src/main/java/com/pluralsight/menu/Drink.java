package com.pluralsight.menu;

public class Drink implements MenuItem {
    private String name;
    private String size;
    private double priceSmall;
    private double priceMedium;
    private double priceLarge;

    public Drink(String name, String size, double priceSmall, double priceMedium, double priceLarge) {
        this.name = name;
        this.size = size;
        this.priceSmall = priceSmall;
        this.priceMedium = priceMedium;
        this.priceLarge = priceLarge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(double priceSmall) {
        this.priceSmall = priceSmall;
    }

    public double getPriceMedium() {
        return priceMedium;
    }

    public void setPriceMedium(double priceMedium) {
        this.priceMedium = priceMedium;
    }

    public double getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(double priceLarge) {
        this.priceLarge = priceLarge;
    }

    // implemented from MenuItem
    @Override
    public double calculatePrice() {
        switch (size.toLowerCase()) {
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

    public String toString() {
        return name + " (" + size + ") - $" + String.format("%.2f", calculatePrice());

    }
}
