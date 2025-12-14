package supermarket.management;

import supermarket.algorithms.SearchAlgorithm;
import supermarket.algorithms.SortAlgorithm;
import supermarket.inventory.Product;
import  supermarket.inventory.Activity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

// this is the supermarket class which manages the system
// it in control of products storage, searching for products,
// add/remove products and recording product activities.
public class SupermarketManager
{
    // this the list to store all products in the supermarket
    private final ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product>listproducts()
    {

        // loop through each product object in the products collection
        for (Product value : products)
        {
            // print the current product object
            System.out.println(value);
        }

        //return a copy of the product list
        return new ArrayList<>(products);



    }
    //  this the method to add product to the supermarket
    public  void addProduct(Product value)
    {
        // check if the product with a particular id already exist using the searchAlgorithm
        if ( SearchAlgorithm.binarySearchByID(products,value.getId())>= 0)
        {
            // if  the product already exists, it will not add it again to prevent duplicates
            return;

        }
        //  add the product to the list
        products.add(value);
        //keep product list sorted after adding new product
        SortAlgorithm.insertionSortProductsByID(products);

    }
    // remove a product based on its id
    public Product  deleteproducts(String id)
    {
        // search for the product index using the searchAlgorithm
        int index = SearchAlgorithm.binarySearchByID(products, id);
        // if the index is less than zero which means the id is not the list then do nothing
        if (index < 0) {
            return null;   // product not found
        }

        // get product BEFORE removing it
        Product removedProduct = products.get(index);

        // remove the product from the list
        products.remove(index);

        // print out message inform the actions is done
        System.out.println("Product has been removed !");

        // return the removed product so UI can show details
        return removedProduct;

    }


    // a method to search for a product and returns its index
    public int search(ArrayList<Product> products, String targetID)
    {
        // using the search algorithms to locate the product id at index
        return SearchAlgorithm.binarySearchByID(products,targetID) ;
    }
    // to check if a product already exist
    public boolean Productexists(String id)
    {
        return  SearchAlgorithm.binarySearchByID(products,id) >= 0;
    }

    // the method is to preform an activity (add/ remove stock) on a specific product
    public void addactivitytoproduct(String id,int quantity,String action)
    {
        // find the product index
        int index = SearchAlgorithm.binarySearchByID(products,id);
        // if product is not found, then end the method
        if (index < 0)
        {
            // print out a message informing the user
            System.out.println("Products not found ");
            return;
        }


        // if the products is found then retrieve the selected product
        Product value = products.get(index);


        // if the action is add to stock
        if (action.equalsIgnoreCase("add"))
        {
            // update the Quantity of the products
            value.update_Quantity(quantity, "AddToStock");

            // create new activity  entry
            Activity activity = new Activity(
                    quantity, "ADDED_TO_STOCK",
                    LocalDateTime.now(), value.getId()
            );
            // then save the activity into the product history
            value.addActivity(activity);

            //if the action is to remove from stock
        } else if (action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("delete"))
        {
            // update the quantity of the products
            value.update_Quantity(quantity, "RemoveFromStock");

            //  create a new activity entry
            Activity activity = new Activity(
                    quantity,"REMOVED_FROM_STOCK",
                    LocalDateTime.now(), value.getId()
            );
            //save the activity
            value .addActivity(activity);


        }


    }
    // This method retrieves last four activities for product,
    public CustomLinkedList<Activity> lastFourSortedBYQuantity(String id)
    {
        //  find product
        int index = SearchAlgorithm.binarySearchByID(products,id);

        // if the product is not found d
        if (index< 0)
            return null;

        // is to get the product
        Product values = products.get(index);

        // get the list of activities belong to the product
        CustomLinkedList<Activity> activity= values.getActivities();

        // sort the activities list in order by using the sort Algorithm
        SortAlgorithm.insertionSortActivitiesByQuantity(activity);

        // create a new list to store the sorted activities in reverse order
        CustomLinkedList<Activity> result = new CustomLinkedList<>();

        for(int i = activity.size() -1; i >= 0; i--)
        {
            // then add the activities in to the new List
            result.add(activity.get(i));
        }
        // the return the new list
        return result;




    }

    // this method print out all the  activites that belong to specific product id
    public void printProdcutsactivites(String id)
    {
        // find the product
        int index = SearchAlgorithm.binarySearchByID(products, id);

        // if the products is not found
        if (index < 0)
        {
            // print out an error message
            System.out.println("product not found");
            return;
        }
        // get the product
        Product value = products.get(index);
        // print out a title of the product id
        System.out.println("activities for product "+ id + ":");

        // loop through
        for(int i = 0; i < value.getActivities().size();i++)
        {
            // print each activity
            System.out.println(value.getActivities().get(i));
        }
    }

}
