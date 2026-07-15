import java.util.Arrays;
import java.util.Scanner;

/**
 * The BinarySearch class provides an interactive command-line interface 
 * to look up the index of a target element in an array using Binary Search.
 * 
 * NOTE: The input array must be sorted for Binary Search to work correctly.
 * Time Complexity: 
 *   - Best Case: O(1) (Target is exactly at the middle on the first check)
 *   - Worst/Average Case: O(log n) (Search space is divided by 2 each step)
 * Space Complexity: O(1) - Auxiliary Space (Iterative approach)
 * 
 * @author RAJVENKADAM S
 */
public class BinarySearch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 1. Prompt user for array size
        System.out.print("Enter the number of elements: ");
        int range = scan.nextInt();
        
        // 2. Initialize array and prompt for inputs
        int[] nums = new int[range];
        System.out.println("Enter " + range + " sorted integers (or unsorted, we will sort it for you):");
        for (int i = 0; i < range; i++) {
            nums[i] = scan.nextInt();
        }
        
        // Ensure the array is sorted before running Binary Search
        Arrays.sort(nums);
        System.out.print("Array used for search (auto-sorted): ");
        System.out.println(Arrays.toString(nums));
        
        // 3. Prompt user for the target element to search
        System.out.print("Enter the target element to search for: ");
        int target = scan.nextInt();
        
        // 4. Binary Search Logic
        int low = 0;
        int high = range - 1;
        int resultIndex = -1; // -1 means target not found by default
        
        while (low <= high) {
            // Find the middle element safely to prevent integer overflow
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                resultIndex = mid; // Target found!
                break;             // Exit the loop immediately
            } 
            else if (nums[mid] < target) {
                low = mid + 1;     // Target is in the right half, discard left half
            } 
            else {
                high = mid - 1;    // Target is in the left half, discard right half
            }
        }
        
        // 5. Output the result
        if (resultIndex != -1) {
            System.out.println("Success: Target " + target + " found at sorted index " + resultIndex + ".");
        } else {
            System.out.println("Result: Target " + target + " was not found in the array.");
        }
        
        // Close resources to prevent potential memory leaks
        scan.close();
    }
}
