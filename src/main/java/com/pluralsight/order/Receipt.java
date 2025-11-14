package com.pluralsight.order;

import com.pluralsight.menu.MenuItem;
import com.pluralsight.menu.MilkTea;
import com.pluralsight.toppings.Topping;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    private Order order;

    public Receipt(Order order){
        this.order = order;
    }

    public void printReceipt(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("========== RECEIPT ==========");

        for(MenuItem item: order.getItems()){
            // Print the main item
            System.out.println(item.getName() + " - $" + df.format(item.calculatePrice()));

            // If it's a MilkTea, print toppings with prices
            if (item instanceof MilkTea) {
                MilkTea milkTea = (MilkTea) item;
                for (Topping topping : milkTea.getToppings()) {
                    double toppingPrice = topping.getPrice(milkTea.getSize());
                    System.out.println("  + " + topping.getName() + " - $" + df.format(toppingPrice));
                }
            }
        }
        System.out.println("-----------------------------");
        System.out.println("TOTAL: $" + df.format(order.calculateTotal()));
        System.out.println("=============================");

        // Automatically save to file
        saveReceiptToFile();
    }

    private void saveReceiptToFile() {
        try {
            // Create filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
            String filename = "receipts/" + timestamp + ".txt";

            // Create receipts directory if it doesn't exist
            new File("receipts").mkdirs();

            // Write receipt to file
            FileWriter writer = new FileWriter(filename);
            writer.write(generateReceiptText());
            writer.close();

            System.out.println("📄 Receipt saved to: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error saving receipt: " + e.getMessage());
        }
    }

    private String generateReceiptText() {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder receiptText = new StringBuilder();

        receiptText.append("========== RECEIPT ==========\n");

        for(MenuItem item: order.getItems()){
            receiptText.append(item.getName()).append(" - $").append(df.format(item.calculatePrice())).append("\n");

            if (item instanceof MilkTea) {
                MilkTea milkTea = (MilkTea) item;
                for (Topping topping : milkTea.getToppings()) {
                    double toppingPrice = topping.getPrice(milkTea.getSize());
                    receiptText.append("  + ").append(topping.getName()).append(" - $").append(df.format(toppingPrice)).append("\n");
                }
            }
        }

        receiptText.append("-----------------------------\n");
        receiptText.append("TOTAL: $").append(df.format(order.calculateTotal())).append("\n");
        receiptText.append("=============================\n");

        return receiptText.toString();
    }
}
