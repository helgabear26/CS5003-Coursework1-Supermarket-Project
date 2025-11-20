package supermarket.inventory;

import java.time.LocalDateTime;


public class Activity {
    private int quantity;
    private String name;
    private LocalDateTime TimeStamp;
    private String id;

    public Activity(int quantity, String name, LocalDateTime TimeStamp, String id) {
        this.quantity = quantity;
        this.TimeStamp = TimeStamp;
        this.name = name;
        this.id = id;

    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;

    }

    public LocalDateTime getTimeStamp() {
        return TimeStamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        TimeStamp = timeStamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void AddToStock(int value) {
        if (value > 0) {
            quantity += value;
            name = "addToStock";
            TimeStamp = LocalDateTime.now();
        }
    }

    public void RemoveFromStock(int value) {
        if (value > 0 && quantity >= 0) {
            quantity -= value;
            name = "Remove from stock ";
            TimeStamp = LocalDateTime.now();

        } else {
            System.out.println(" there is not enough stock to remove or the stock is empty");
        }


    }

    @Override
    public String toString() {
        return "Activity{" +
                "ID = " + id + '\'' +
                ", name= " + name +
                ",Quantity = " + quantity +
                ", data = " + TimeStamp +
                '}';
    }
}