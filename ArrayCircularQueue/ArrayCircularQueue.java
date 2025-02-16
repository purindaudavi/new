package ArrayCircularQueue1;

import java.util.NoSuchElementException;

//Circular Queue implementation in Java
public class ArrayCircularQueue {
	int SIZE = 5; // Size of Circular Queue
	int front, rear;
	int items[] = new int[SIZE];

	ArrayCircularQueue() {
		 front = -1;
		 rear = -1;
	}

	// Check if the queue is full
	boolean isFull() {
		return (front == 0 && rear == SIZE - 1) || front == rear + 1;
	}

	// Check if the queue is empty
	boolean isEmpty() {
		 return front == -1;
	}

	// Adding an element
	void enQueue(int element) {
		 if (isFull()) {
			 System.out.println("Queue is full");
		 } 
		 else {
			   if (front == -1)
				   front = 0;
			   
			   rear = (rear + 1) % SIZE;
			   items[rear] = element;
			   System.out.println("Inserted: " + element);
		 }
	}

// element remove
	int deQueue() {
		 int element;
		 
		 if (isEmpty()) {
			 throw new NoSuchElementException("Queue is empty!");
		 } 
		 else {
			   element = items[front];
			   
			   if (front == rear) {
				   front = -1;
				   rear = -1;
		   } /* Queue has only one element,after deleting the queue will be resetted. */
		   else {
			   front = (front + 1) % SIZE;
		   }
		 return (element);
		 }
	}

void display() {
	 /* Function to display status of Circular Queue */
	 int i;
	 
	System.out.print("Items: [");
		 
	for (i = front; i != rear; i = (i + 1) % SIZE)
	      System.out.print(items[i] + " ");
		   
	      System.out.println(items[i] + "]");
		 
	      System.out.print("Indexes: ");
	      for (i = front; i != rear; i = (i + 1) % SIZE) {
	          System.out.print(i + " ");
	      }
	      System.out.println(i); // Print the last index

	
}


public static void main(String[] args) {

	ArrayCircularQueue q = new ArrayCircularQueue();

	 // Fails because front = -1
	 q.deQueue();
	
	 q.enQueue(1);
	 q.enQueue(2);
	 q.enQueue(3);
	 q.enQueue(4);
	 q.enQueue(5);
	
	 // Fails to enqueue because front == 0 && rear == SIZE - 1
	 q.enQueue(6);
	
	 q.display();
	
	 int element = q.deQueue();
	
	 if (element != -1) {
	   System.out.println("Deleted Element is " + element);
	 }
	 
	 q.display();
	
	 q.enQueue(7);
	
	 q.display();
	
	 // Fails to enqueue because front == rear + 1
	 q.enQueue(9);

	}

}
