package supermarket.inventory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// This is the activity class represents an action performed on a product
// it also records details quantity changed,timeStamp, product id and type of activity


public class Activity {
  // quantity involved in the activity
    private int quantity;
    // the name of the type of activity
    private String name;
    // time when the activity occurred
    private LocalDateTime TimeStamp;
    //id of the product the activity belongs to
    private String id;

    // the constructor  that initializes the activity object
    public Activity(int quantity, String name, LocalDateTime TimeStamp, String id) {
        // set activity quantity
        this.quantity = quantity;
        // set the timestamp
        this.TimeStamp = TimeStamp;
        //set activity name
        this.name = name;
        // set the  product id associated with this activity
        this.id = id;

    }
    // this is the getter method for ID
    public String getId() {
        return id;
    }


    //this is the getter method for activity name
    public String getName() {
        return name;
    }

    //this is the getter method for activity quantity
    public int getQuantity() {
        return quantity;

    }

    //this is the getter method for the TimeStamp
    public LocalDateTime getTimeStamp() {
        return TimeStamp;
    }

    //this is the setter method for activity name
    public void setName(String name) {
        this.name = name;
    }

    // this is the setter method for activity quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // this is the setter method for  the timeStamp
    public void setTimeStamp(LocalDateTime timeStamp) {
        TimeStamp = timeStamp;
    }


    // this is the setter method for  ID
    public void setId(String id) {
        this.id = id;
    }

    // method to add quantity to stock and record an add to stock activity
    public void AddToStock(int value) {
        // check out for positive values
        if (value > 0) {

            // increase quantity
            quantity += value;
            // set the name of the activity
            name = "addToStock";
            // set the new timestamp
            TimeStamp = LocalDateTime.now();
        }
    }

    // method to remove quantity to stock and record a  remove from stock activity
    public void RemoveFromStock(int value) {

        // check out for positive removal and there is non-negative stock
        if (value > 0 && quantity >= 0) {
            // decrease quantity
            quantity -= value;
            // set  the name of the activity
            name = "Remove from stock ";
            // set the new timestamp
            TimeStamp = LocalDateTime.now();

        } else {
            // print out a message if there is an insufficient stock ,
            System.out.println(" there is not enough stock to remove or the stock is empty");
        }


    }

    //  override toString method to format activity details when printed
    @Override
    public String toString() {

        // Displays the date and time in the appropriate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' hh:mm:ss a");


        return "Activity {" +
                "ID = '" + id + '\'' + // display product id
                ", Action Name = " + name + // display name
                ", Quantity = " + quantity + // display quantity
                ", Date = " + TimeStamp.format(formatter) + // display date and timeStamp
                '}';
    }

}