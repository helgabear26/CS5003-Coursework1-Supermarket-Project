package supermarket.ui;

import supermarket.inventory.Product;
import supermarket.management.SupermarketManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import java.io.*;


public class SaveMenuBarFunction {

    // Method to save supermarket products to file.
    public void saveActivities(SupermarketManager manager, String SaveActivities) {

        // Tries to open and create a BufferedWriter for writing
        // FileWriter opens the file to overwrite mode
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SaveActivities))) {

            // Retrieves the list of products from the manager
            List<Product> products = manager.listproducts();


            // Loops through each Product object in the list
            for (Product p : products) {

                // Writes the product details to the file with each value being separated by a comma
                bufferedWriter.write(
                        p.getId() + "," +
                                p.getname() + "," +
                                p.getQuantity() + "," +
                                p.getTimeStamp());

                // Adds a new line after each product so each product is on one line
                bufferedWriter.newLine();
            }

            // Prints a message to the console confirming successful save
            System.out.println("Products successfully saved to " + SaveActivities);
        } catch (IOException e) {

            // Catches any file writing errors
            // Prints the full error stack trace for debugging purposes
            e.printStackTrace();
        }
    }
}



