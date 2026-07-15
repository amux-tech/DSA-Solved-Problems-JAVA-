import java.util.Scanner;

/**
 * The SelectionSort class provides an interactive command-line interface 
 * to sort an array of integers using the Selection Sort algorithm.
 * 
 * It supports both Ascending ('a') and Descending ('d') sorting orders.
 * Time Complexity: O(n^2) - Best, Average, and Worst Case
 * Space Complexity: O(1) - Auxiliary Space (In-place sorting)
 * 
 * @author RAJVENKADAM S
 */
public class SelectionSort {

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
                // Selection Sort logic for Ascending Order
                for (int i = 0; i < range - 1; i++) {
                    int minValueIndex = i;
                    for (int j = i + 1; j < range; j++) {
                        if (nums[j] < nums[minValueIndex]) {
                            minValueIndex = j;
                        }
                    }
                    int temp = nums[i];
                    nums[i] = nums[minValueIndex];
                    nums[minValueIndex] = temp;
                }
                
                // Displaying sorted array in a clean format
                System.out.print("Sorted Array (Ascending): ");
                for (int i = 0; i < range; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println(); // Prints a clean new line at the end
                break;

            case 'd':
                // Selection Sort logic for Descending Order
                for (int i = 0; i < range - 1; i++) {
                    int maxValueIndex = i;
                    for (int j = i + 1; j < range; j++) {
                        if (nums[j] > nums[maxValueIndex]) {
                            maxValueIndex = j;
                        }
                    }
                    int temp = nums[i];
                    nums[i] = nums[maxValueIndex];
                    nums[maxValueIndex] = temp;
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
