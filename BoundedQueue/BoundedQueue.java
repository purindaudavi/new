public class BoundedQueue {
    private final Object[] elements;
    private int size, front, back;
    private final int capacity;

    public BoundedQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be over than 0");
        this.capacity = capacity;
        elements = new Object[capacity];
        size = front = back = 0;
    }

    public void enQueue(Object o) {
        if (o == null)
            throw new NullPointerException("Element cannot be null");
        if (isFull())
            throw new IllegalStateException("Queue is full");
        elements[back] = o;
        back = (back + 1) % capacity;  // Moves back to the next position
        size++;
    }

    public Object deQueue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        Object o = elements[front];
        elements[front] = null;  // Help garbage collection
        front = (front + 1) % capacity;  // Move from front to the next position
        size--;
        return o;
    }

    public boolean isEmpty() {
        
        return size == 0;
    }

    public boolean isFull() {
        
        return size == capacity;
        
    }

    @Override
    public String toString() {
        
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(elements[(front + i) % capacity]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        
        return result.toString();
    }
    
    
    public static void main(String[] args) {
        BoundedQueue queue = new BoundedQueue(5);

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        
        System.out.println(queue);  

        queue.deQueue();
        
        System.out.println(queue);  

        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.println(queue);  

       
    }
}
