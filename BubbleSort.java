import java.util.Scanner;

public class BubbleSort {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        int[] numbers = new int[10];
        
        
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        
        bubbleSort(numbers);
        
        
        System.out.println("Sorted numbers:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
    
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
