package supermarket.ui;

import supermarket.inventory.Activity;
import supermarket.inventory.Product;
import supermarket.management.CustomLinkedList;
import supermarket.management.SupermarketManager;

import java.util.Scanner;

/*
public class ConsoleUI {

    private final SupermarketManager manager = new SupermarketManager();
    private Scanner inventory = new Scanner(System.in);

    int choice;

    public void run() {
        while(true) {
            System.out.println("******************************");
            System.out.println("\n==== SUPERMARKET SYSTEM ====");
            System.out.println("1. Add a Product ");
            System.out.println("2. Display All Products ");
            System.out.println("3. Delete a Product ");
            System.out.println("4. Update Product Activity (Add / Remove Stock) ");
            System.out.println("5. Show Last Four Sorted Activities (Sorted by Quantity) ");
            System.out.println("6. Exit System ");
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
                case 2 -> {
                    System.out.println("\nList of Existing Products:\n");
                    manager.listproducts();
                }
                case 3 -> deleteProduct();
                case 4 -> addactivitytoproduct();

                case 5 -> lastFourSortedBYQuantity();
                case 6 -> exitProgram();

                default -> System.out.println("Invalid choice! Please try again. ");
            }
        }
    }

    private void addProduct() {
        System.out.println("Enter Product ID: ");
        String id = inventory.nextLine();

        System.out.println("Enter Product Name: ");
        String name = inventory.nextLine();

        System.out.println("Enter a Quantity: ");
        int quantity = inventory.nextInt();
        inventory.nextLine();

        Product product = new Product(quantity, name, id);
        manager.addProduct(product);
        System.out.println("\nProduct added Successfully! ");
        System.out.println("Added Product: " + name + " (ID: " + id + "), Quantity: " + quantity + "\n");

    }

    private void deleteProduct() {

        System.out.println("Enter Product ID to Delete: ");
        String id = inventory.nextLine();

        Product deleted = manager.deleteproducts(id);



        if (deleted != null) {
            System.out.println("\nProduct has been removed !");
            System.out.println("Deleted Product: " + deleted.name() +
                    " (ID: " + deleted.getId() + ")\n");
        } else {
            System.out.println("\nNo product found with ID: " + id + "\n");
        }

    }

    private void addactivitytoproduct() {
        System.out.println("Enter Product ID: ");
        String id = inventory.nextLine();

        System.out.println("Enter a Quantity: ");
        int quantity = inventory.nextInt();
        inventory.nextLine();

        System.out.println("Enter a stock action (add / delete)");
        String action = inventory.nextLine();

        System.out.println("Action performed Successfully! ");

        manager.addactivitytoproduct(id, quantity, action);
    }

    private void lastFourSortedBYQuantity() {

        System.out.println("Enter Product ID: ");
        String id = inventory.nextLine();

        CustomLinkedList<Activity> sortedActivites = manager.lastFourSortedBYQuantity(id);

        if (sortedActivites == null) {
            System.out.println("Product not found. ");
        } else {
            System.out.println("\nLast Four Activities sorted by Quantity: \n");
            for (int i = 0; i < sortedActivites.size(); i++) {
                System.out.println(sortedActivites.get(i));
            }
        }

    }

    private void exitProgram() {
        System.out.println("Exiting the program... ");
        inventory.close();
        System.exit(0);
    }


}

 */