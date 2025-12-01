package supermarket.management;

// This class is an implementation of a custom Linked List
// LinkedLists store nodes in two parts being:
// 1. Data about the object you want to store
// 2. An address which is a link between the nodes in the chain

public class CustomLinkedList<T> {

    // Below is the inner class Node
    // A node represents an element inside a linked list. It contains:
    // 1. data
    // 2. a reference to the next node in the list

    private class Node {

        // This variable stores the data that needs to be kept in the list.
        // It is of type object so it can store any type(e.g. Activity, Product, String)

        T data;

        // This variable stores a reference to the next node in the list
        // If next = null, it means this is the last node

        Node next;

        // Constructor - this method creates a new Node object
        // It takes the argument data which is the thing we want to store

        Node(T data) {

            // Store the passed data inside the node

            this.data = data;

            // Set next to null because when the node is first created it doesn't point to anything yet.

            this.next = null;

        }
    }

    // Linked List state variables

    // Assigns the first node in the linked list
    // If head == null, it means the list is empty

    private Node head;

    // the last node in the list

    private Node tail;

    // States how may nodes are currently available in the list

    private int size;

    // Method: add(ObjectData) adds a new element to the end of the linked list

    public void add(T data) {

        // Creates anew node containing the new data

        Node newNode = new Node(data);

        // Case 1: If the list is empty (head == null), then the new node becomes BOTH the first and last node

        if (head == null) {
            head = newNode;
            tail = newNode;

        // Case 2: List is not empty so a new node is attached to the end of the list as new data is added

        } else {

            // Makes the current last node point to the new node

            tail.next = newNode;

            // Updates the tail reference so it points to the new node
            tail = newNode;
        }

        // Increase the size of the counter because a new node was added
        size++;

    }

    // Method: removeFirst() removes the first element from the linked list which allows only the last four activities to be kept

    public void removeFirstElement() {

        // If head is null, the list is empty, so nothing to remove

        if (head == null)
            return;

        // Moves the head to the next node
        // The old first node gets removed

        head = head.next;

        // Decrease the size counter

        size--;

        // If the list becomes empty after removal the tail must also be set to null

        if (head == null) {
            tail = null;
        }
    }

    // Method get(int index) returns the data object stored at a specific position

    public T get(int index) {

        // If index is invalid (as in less than 0 or greater than the last index), it throws an error to prevent the accessing of memory illegally

        if (index < 0 || index >= size) // uses a logical OR operator
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        // Start at the head of the list

        Node current = head;

        // Move step-by-step until we reach the desired index

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Return the data stored in the node

        return current.data;
    }

    // Updates the elements stored at a specific index in the linked list
    public void set(int index, T data) {
        // Validates the index preventing a node that doesn't exist from updating
        if (index < 0 || index >= size) {
            // If invalid throw an exception with details about the bad index and current list size
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Stars identifying the first node in the list then goes on node by node
        Node current = head;
        // Moves forward until the desired index is reached by moving from the current to the next node
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Reaches the node at the correct index and replaces the data stored with a new value
        current.data = data;

    }



    // Method: getSize() returns the amount of elements there are in the list

    public int size(){

        return size;
    }


}