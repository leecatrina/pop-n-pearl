package com.pluralsight.order;

import com.pluralsight.menu.MenuItem;

import java.text.DecimalFormat;

public class Receipt {
    private Order order;

    public Receipt(Order order){
        this.order = order;
    }
    public void printReceipt(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("========== RECEIPT ==========");

        for(MenuItem item: order.getItems()){
            System.out.println(item.getName() + " - $" + df.format(item.calculatePrice()));
        }
        System.out.println("-----------------------------");
        System.out.println("TOTAL: $" + df.format(order.calculateTotal()));
        System.out.println("=============================");
    }
}
