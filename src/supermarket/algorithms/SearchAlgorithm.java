package supermarket.algorithms;

import supermarket.inventory.Product;
import java.util.List;


// This class performs a binary search by the Product ID in the supermarket system
// The binary search will take the ID from the Product class, and start performing the search
// The search uses variables such as 'left', 'right', and 'mid', to keep track of the search boundaries and the
// midpoint inside the sorted array
// Searching Algorithm coded by Alesha Sangar


public class SearchAlgorithm {

    // Binary search defined by list
    // List consists of ProductIDs from the product class
    public static int binarySearchByID(List<Product> products, String targetID) {


        int left = 0; // First index of list
        int right = products.size() - 1 ; // Last index of list


        // Print starting message
        System.out.println("Searching for product ID: " + targetID);


        // Loop runs while the search range is valid; stops when the product cannot be found
        while (left <= right) {

            int mid = (left + right) / 2; // Midpoint (middle index) defined


            // Retrieves product object located at midpoint
            Product midpoint = products.get(mid);


            // Print what ID you're checking
            System.out.println("Checking index " + mid + "with ID: " + midpoint.getId());


            // Compares the midpoint product's ID with the targetID
            int comparison = midpoint.getId().compareTo(targetID);


            // If they match...
            if (comparison == 0) {
                System.out.println("Product found at index: " + mid);
                return mid; // Found -> index returned
            }

            // If not...
            // Keep searching through list
            else if (comparison < 0) {

                // If midpoint less than target ID, target must be in the right half of list
                left = mid + 1; // Discard left half
            }
            else {

                // If midpoint greater than target ID, target must be in the left half of list
                right = mid - 1; // Discard right half
            }


        }

        // Print not found message
        System.out.println("Product not found");
        return -1; // Not found

    }


}
