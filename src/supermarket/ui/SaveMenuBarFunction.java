package supermarket.ui;

import supermarket.inventory.Product;
import supermarket.management.CustomLinkedList;
import supermarket.management.SupermarketManager;

import java.io.*;
import java.util.List;

public class SaveMenuBarFunction {

    public void saveActivities(SupermarketManager manager, String SaveActivities) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SaveActivities))) {
            List<Product> products = manager.listproducts();


            for (Product p : products) {
                bufferedWriter.write(
                        p.getId() + "," +
                                p.getname() + "," +
                                p.getQuantity() + "," +
                                p.getTimeStamp());
                bufferedWriter.newLine();
            }
            System.out.println("Products successfully saved to " + SaveActivities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



