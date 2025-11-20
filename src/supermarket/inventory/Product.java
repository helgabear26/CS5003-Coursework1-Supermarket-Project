package supermarket.inventory;

import supermarket.management.CustomLinkedList;

import java.time.LocalDateTime;

// This class represents a single product in the supermarket system
// Each product has:
// - a product ID
// - a name
// - The date it was added to the system
// - A quantity (current stock)
// Alist of the last 4 activities using the custom linked list

public class Product {

    // A unique string that identifies this product
    private int quantity;

    // The product's name
    private String name;

    // Date and time when this product was created and added to the system
    private LocalDateTime TimeStamp;

    // The number of items currently in stock
    private String id;

    // A linked list that stores the last four activities objects performed for this product.
    private CustomLinkedList activities = new CustomLinkedList();

    // Constructor: Creates a new Product object

    public Product( int quantity, String name, String id){

        // Sets the ID from the value passed to the constructor
        this.id = id;

        // Sets the product name
        this.name = name;

        // Sets the initial quantity
        this.quantity = quantity;

        // Sets the entry date to the right now
        this.TimeStamp = LocalDateTime.now(); // Captures the exact date and time the object was created
    }

     // Method: addActivity(Activity activity) adds a new activity to the list and ensures only four remain
    public void addActivity(Activity activity) {

        // Add the new activity to the end of the linked list
        activities.add(activity);

        // If more than four activities are stored
        if (activities.size() > 4) {

            // Removes the first oldest activity
            activities.removeFirstElement();
        }
    }

    // Method: updateQuantity(int amount, String activityType) updates the quantity based on AddToStock and RemoveFromStock

    public void update_Quantity(int amount, String activityType){

        // Checks if items are being added to stock
        if(activityType.equalsIgnoreCase("AddToStock")){
            quantity += amount; // increases stock

            // Check if items are being removed from stock
        } else if (activityType.equalsIgnoreCase("RemoveFromStock")) {

            // Prevents negative stock number
            if (quantity - amount < 0) {
                System.out.println("ERROR: Not enough stock. ");
                return;
            }

            // Removes items from stock
            quantity -= amount;
        }
    }

    // Getters return the linked list of activities

    public String getId(){
        return id;
    }

    public String name(){
        return name;
    }

    public LocalDateTime TimeStamp(){
        return TimeStamp;
    }

    public int getQuantity(){
        return quantity;
    }


    public CustomLinkedList getActivities(){

        return activities;
    }


    // Method: toString() returns a text version of the product to print product details


    @Override
    public String toString(){
        return "Product{" +
                "ID= '" + id + "/'" +
                ", TimeStamp= " + TimeStamp +
                ", quantity= " + quantity +
                '}';
    }

}
