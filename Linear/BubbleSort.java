import java.util.Scanner;

/**
 * The BubbleSort class provides an interactive command-line interface 
 * to sort an array of integers using the Bubble Sort algorithm.
 * 
 * It supports both Ascending ('a') and Descending ('d') sorting orders.
 * Time Complexity: O(n^2) - Worst/Average Case
 * Space Complexity: O(1) - Auxiliary Space
 * 
 * @author RAJVENKADAM S
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 1. Prompt user for array size
        System.out.print("Enter the number of elements: ");
        int range = scan.nextInt();
        
        // 2. Initialize array and prompt for inputs
        int[] nums = new int[range];
        System.out.println("Enter " + range + " integers:");
        for (int i = 0; i < range; i++) {
            nums[i] = scan.nextInt();
        }
        
        // Clear the scanner buffer safely
        scan.nextLine(); 
        
        // 3. Prompt user for the sorting order strategy
        System.out.print("Choose sorting order (Ascending (a) or Descending (d)): ");
        char choice = scan.nextLine().toLowerCase().trim().charAt(0);
        
        // 4. Execute selected sorting strategy
        switch (choice) {
            case 'a':
                // Bubble sort logic for Ascending Order
                for (int i = 0; i < range - 1; i++) {
                    for (int j = 0; j < range - 1 - i; j++) {
                        if (nums[j] > nums[j + 1]) {
                            int temp = nums[j];
                            nums[j] = nums[j + 1];
                            nums[j + 1] = temp;
                        }
                    }
                }
                
                // Displaying sorted array in a clean format
                System.out.print("Sorted Array (Ascending): ");
                for (int i = 0; i < range; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println(); // Prints a clean new line at the end
                break;

            case 'd':
                // Bubble sort logic for Descending Order
                for (int i = 0; i < range - 1; i++) {
                    for (int j = 0; j < range - 1 - i; j++) {
                        if (nums[j] < nums[j + 1]) {
                            int temp = nums[j];
                            nums[j] = nums[j + 1];
                            nums[j + 1] = temp;
                        }
                    }
                }
                
                // Displaying sorted array in a clean format
                System.out.print("Sorted Array (Descending): ");
                for (int i = 0; i < range; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println(); // Prints a clean new line at the end
                break;

            default:
                System.out.println("Error: Invalid choice entered. Please restart and choose 'a' or 'd'.");
        }
        
        // Close resources to prevent potential memory leaks
        scan.close();
    }
}
