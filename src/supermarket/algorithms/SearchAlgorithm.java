package supermarket.algorithms;

import supermarket.inventory.Product;
import supermarket.management.CustomLinkedList;


// This class performs a linear search by the Product ID in the supermarket system.
// The linear search will take the ID from the Product class, and start performing the search.
// The search will loop through the entire linked list (from CustomLinkedList class) until target ID is found.
// Linear Search will be used as it is the most efficent searching algorithm on linked lists.
// Searching Algorithm coded by Alesha Sangar


public class SearchAlgorithm {

    public static int linearSearchByID(CustomLinkedList<Product> products, String targetID) {

        // Loop through every element in the linked list
        for (int i = 0; i < products.size(); i++) {

            // Get the product at the current position
            Product current = products.get(i);

            // Check if the ID matches the one we are searching for
            if (current.getId().equals(targetID)) {

                // Return the index where the product was found
                return i;
            }
        }

        // Product was not found in the list
        return -1;
    }

}
