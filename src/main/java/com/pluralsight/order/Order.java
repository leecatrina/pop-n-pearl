package com.pluralsight.order;

import com.pluralsight.menu.MenuItem;

import java.util.List;

public class Order {
    private List<MenuItem> items; //stores all items in this order

    //constructor
    public Order(List<MenuItem> items) {
        this.items = items;
    }
    //Add a MenuItem (MilkTea, Drink, Side, etc)
    public void addItem(MenuItem item) {
        items.add(item);
    }
    //Remove an item from the order
    public void removeItem(MenuItem item){
        items.remove(item);
    }
    //Get the list of items
    public List<MenuItem>getItems(){
        return items;
    }
    //Calculate the total price of all items
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.calculatePrice();
        }
        return total;
    }
}