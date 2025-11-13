package com.pluralsight.menu;

import com.pluralsight.toppings.Topping;

import java.util.ArrayList;

public class SignatureMilkTea extends MilkTea{
    public SignatureMilkTea(String name, String size) {

        //Signature drinks have fixed toppings and base type

        super(name, size, "Black Tea", new ArrayList<>());

        if (name.equalsIgnoreCase("Brown Sugar Boba")) {
            getToppings().add(new Topping("Brown Sugar Pearls", "premium"));
        } else if (name.equalsIgnoreCase("Matcha Latte")) {
            getToppings().add(new Topping("Matcha Foam", "premium"));
        } else if (name.equalsIgnoreCase("Taro Dream")) {
            getToppings().add(new Topping("Taro Pudding", "regular"));
        }
    }
}
