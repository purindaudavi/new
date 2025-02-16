import java.util.Stack;

public class StackQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public StackQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    
    public void enqueue(int value) {
        inputStack.push(value);
    }

    
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.pop();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    
    @Override
    public String toString() {
        StringBuilder queueString = new StringBuilder("[");

        for (int i = 0; i < outputStack.size(); i++) {
            queueString.append(outputStack.get(i));
            if (i < outputStack.size() - 1) queueString.append(", ");
        }

        for (int i = inputStack.size() - 1; i >= 0; i--) {
            if (queueString.length() > 1) queueString.append(", ");
            queueString.append(inputStack.get(i));
        }

        queueString.append("]");
        return queueString.toString();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue after enqueues: " + queue);

        queue.dequeue();
        System.out.println("Queue after the dequeue: " + queue);

        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Queue after some more enqueues: " + queue);

        queue.dequeue();
        System.out.println("Queue after another dequeue: " + queue);
    }
}
