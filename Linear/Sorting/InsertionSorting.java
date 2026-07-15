import java.util.Scanner;

/**
 * The InsertionSort class provides an interactive command-line interface 
 * to sort an array of integers using the Insertion Sort algorithm.
 * 
 * It supports both Ascending ('a') and Descending ('d') sorting orders.
 * Time Complexity: 
 *   - Best Case: O(n) (When the input array is already fully sorted)
 *   - Average/Worst Case: O(n^2) (When the array is random or reversed)
 * Space Complexity: O(1) - Auxiliary Space (In-place sorting routine)
 * 
 * @author RAJVENKADAM S
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 1. Prompt user for array size
        System.out.print("Enter the number of elements: ");
        int range = scan.nextInt();
        
        // 2. Initialize array and prompt for inputs
        int[] nums = new int[range];
        System.out.println("Enter " + range + " integers space-separated or line-by-line:");
        for (int i = 0; i < range; i++) {
            nums[i] = scan.nextInt();
        }
        
        // Clear the scanner buffer safely
        scan.nextLine(); 
        
        // 3. Prompt user for the sorting order strategy
        System.out.print("Choose sorting order - Ascending (a) or Descending (d): ");
        char choice = scan.nextLine().toLowerCase().trim().charAt(0);
        
        // 4. Execute selected sorting strategy
        switch (choice) {
            case 'a':
                // Insertion Sort logic for Ascending Order
                for (int i = 1; i < range; i++) {
                    int key = nums[i];
                    int j = i - 1;
                    
                    // Shift larger elements forward to create a pocket for the key
                    while (j >= 0 && nums[j] > key) {
                        nums[j + 1] = nums[j];
                        j--;
                    }
                    nums[j + 1] = key;
                }
                
                // Displaying sorted array in a clean format
                System.out.print("Sorted Array (Ascending): ");
                for (int i = 0; i < range; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println(); // Prints a clean new line at the end
                break;

            case 'd':
                // Insertion Sort logic for Descending Order
                for (int i = 1; i < range; i++) {
                    int key = nums[i];
                    int j = i - 1;
                    
                    // Shift smaller elements forward to create a pocket for the key
                    while (j >= 0 && nums[j] < key) {
                        nums[j + 1] = nums[j];
                        j--;
                    }
                    nums[j + 1] = key;
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
