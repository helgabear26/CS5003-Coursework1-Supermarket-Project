package supermarket.ui;

import supermarket.inventory.Activity;
import supermarket.inventory.Product;
import supermarket.management.CustomLinkedList;
import supermarket.management.SupermarketManager;

import java.util.Scanner;

public class ConsoleUI {

    private final SupermarketManager manager = new SupermarketManager();
    private Scanner inventory = new Scanner(System.in);

    int choice;

    public void run() {
        while(true) {
            System.out.println("******************************");
            System.out.println("\n==== SUPERMARKET SYSTEM ====");
            System.out.println("1. Add a Product ");
            System.out.println("2. Display Products ");
            System.out.println("3. Delete a Product ");
            System.out.println("4. Add an Activity ");
            System.out.println("5. Show Last 4 Sorted Activities ");
            System.out.println("6. Exit ");
            System.out.println("******************************");

            System.out.println("Enter your choice (1-6): ");

            if(!inventory.hasNextInt()) {
                System.out.println("Invalid Input. Enter a valid number. ");
                inventory.nextLine();
                continue;
            }

            choice = inventory.nextInt();
            inventory.nextLine();


            switch (choice) {
                case 1 -> addProduct();
                case 2 -> manager.listproducts();
                case 3 -> deleteProduct();
                case 4 -> {
                    System.out.println("Enter product id: ");
                    String id = inventory.nextLine();

                    System.out.println("Enter a quantity: ");
                    int quantity = inventory.nextInt();
                    inventory.nextLine();

                    System.out.println("Enter a product name: ");
                    String name = inventory.nextLine();

                    System.out.println("Enter an action (add / delete)");
                    String action = inventory.nextLine();

                    System.out.println("Action performed successfully! ");

                    manager.addactivitytoproduct(id, quantity, name, action);
                }

                case 5 -> {
                    System.out.println("Enter product id");
                    String id = inventory.nextLine();

                    CustomLinkedList<Activity> result = manager.lastFourSortedBYQuantity(id);

                    if (result == null) {
                        System.out.println("Product not found. ");
                    } else {
                        System.out.println("Last four activities sorted by quantity");
                        for (int i = 0; i < result.size(); i++) {
                            System.out.println(result.get(i));
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Exiting the program. ");
                    inventory.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again. ");
            }
        }
    }

    private void addProduct() {
        System.out.println("Enter Product id: ");
        String id = inventory.nextLine();

        System.out.println("Enter Product name: ");
        String name = inventory.nextLine();

        System.out.println("Enter a Quantity: ");
        int quantity = inventory.nextInt();
        inventory.nextLine();

        Product product = new Product(quantity, name, id);
        manager.addProduct(product);
        System.out.println("Product added successfully! ");

    }

    private void deleteProduct() {

        System.out.println("Enter product id to delete: ");
        String id = inventory.nextLine();

        manager.deleteproducts(id);

    }

    private void addactivitytoproduct() {
        System.out.println("Enter product id: ");
        String id = inventory.nextLine();

        System.out.println("Enter the quantity of the product: ");
        int quantity = inventory.nextInt();
        inventory.nextLine();

        System.out.println(" Enter product name: ");
        String name = inventory.nextLine();

        System.out.println("Enter an action: ");
        String action = inventory.nextLine();

        manager.addactivitytoproduct(id, quantity, name, action);
    }

    private void lastFourSortedBYQuantity() {

        System.out.println("Enter product id: ");
        String id = inventory.nextLine();

        CustomLinkedList<Activity> sortedActivites = manager.lastFourSortedBYQuantity(id);

        if (sortedActivites == null) {
            System.out.println("Product not found. ");
        } else {
            System.out.println("Last four activities sorted by quantity: ");
            for (int i = 0; i < sortedActivites.size(); i++) {
                System.out.println(sortedActivites.get(i));
            }
        }

    }


}