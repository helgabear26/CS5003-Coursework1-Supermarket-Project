package supermarket.inventory;

import supermarket.management.CustomLinkedList;

import java.time.LocalDateTime;

public class Product {

    private int quantity;
    private String name;
    private LocalDateTime TimeStamp;
    private String id;

    private CustomLinkedList<Activity> activities = new CustomLinkedList<>();

    public Product( int quantity, String name, String id){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.TimeStamp = LocalDateTime.now();
    }

     // Keeps the last 4 activities
    public void addActivity(Activity activity) {
        activities.add(activity);
        if (activities.size() > 4) {
            activities.removeFirst();
        }
    }

    public void update_Quantity(int amount, String activityType){
        if(activityType.equalsIgnoreCase("AddToStock")){
            quantity += amount;
        } else if (activityType.equalsIgnoreCase("RemoveFromStock")) {
            if (quantity - amount < 0) {
                System.out.println("ERROR: Not enough stock. ");
                return;
            }
            quantity -= amount;
        }
    }

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


    public CustomLinkedList<Activity> getActivities(){
        return activities;
    }


    @Override
    public String toString(){
        return "Product{" +
                "ID= '" + id + "/'" +
                ", TimeStamp= " + TimeStamp +
                ", quantity= " + quantity +
                '}';
    }

}
