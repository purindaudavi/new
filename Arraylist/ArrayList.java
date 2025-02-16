package ArrayListt;

import java.util.NoSuchElementException;

public class ArrayList {
    private int[] array; // hold the list elements
    private int noOfElements; // size of the list
    public ArrayList(int capacity) {
        array = new int[capacity];
        noOfElements = 0;
    }

    // Add an element to the back
    public void add(int value) {
        if (noOfElements == array.length) {
            resize(); // Resizing if the array is full
        }
        array[noOfElements++] = value;
    }

    // Insert an element at an index
    public void insert(int index, int value) {
        if (index < 0 || index > noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (noOfElements == array.length) {
            resize();
        }
        for (int i = noOfElements; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        noOfElements++;
    }

    // Delete an element in a index
    public void delete(int index) {
        if (index < 0 || index >= noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < noOfElements - 1; i++) {
            array[i] = array[i + 1];
        }
        noOfElements--;
    }

    // Get an element at a  index
    public int get(int index) {
        if (index < 0 || index >= noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    // Update an element at an  index
    public void update(int index, int value) {
        
        if (index < 0 || index >= noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        array[index] = value;
    }

    // Finding an element by its value
    public int find(int value) {
        for (int i = 0; i < noOfElements; i++) {
            
            if (array[i] == value) {
                return i;
            }
        }
        throw new NoSuchElementException("Value not found.");
    }

    // List display
    public void display() {
        if (noOfElements == 0) {
            
            System.out.println("List is empty");
            
        } else {
            for (int i = 0; i < noOfElements; i++) {
                
                System.out.print(array[i] + " ");
                
                
            }
            System.out.println();
        }
    }

    // Checking if the list is empty
    public boolean isEmpty() {
        return noOfElements == 0;
    }

    // Get the size of the list
    public int size() {
        return noOfElements;
    }

    //  resize the array
    private void resize() {
        int[] newArray = new int[array.length * 2]; // Double the capacity
        for (int i = 0; i < noOfElements; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

  
    public static void main(String[] args) {
        ArrayList list = new ArrayList(5); // Assigned 5

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60); // This will trigger a resize

        System.out.println("List after adding elements:");
        list.display();

        // Inserting an element at index 2
        list.insert(2, 25);
        System.out.println("List after inserting 25 at index 2:");
        
        list.display();

        // Deleting an element at index 3
        list.delete(3);
        System.out.println("List after deleting element at index 3:");
        
        list.display();

        // Getting an element at index 4
        System.out.println("Element at index 4: " + list.get(4));

        // Updating an element at index 2
        list.update(2, 35);
        System.out.println("List after updating element at index 2 to 35:");
        
        list.display();

        // Finding the index of value 50
        try {
            System.out.println("Index of value 50: " + list.find(50));
            
        } catch (NoSuchElementException e) {
            
            System.out.println(e.getMessage());
        }

        // Checking if the list is empty
        System.out.println("Is the list empty? " + list.isEmpty());

        // Getting the size of the list
        System.out.println("Size of the list is : " + list.size());
    }
}



