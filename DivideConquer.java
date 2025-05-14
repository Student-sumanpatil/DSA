import java.util.*;

class MinMax {
    // Function to find the min and max using Divide & Conquer
    public static int[] findMinMax(int[] arr, int low, int high) {
        // Base Case: If there's only one element
        if (low == high) {
            return new int[]{arr[low], arr[low]}; // Min and Max both are same
        }

        // Base Case: If there are only two elements
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                return new int[]{arr[high], arr[low]}; // Min = arr[high], Max = arr[low]
            } else {
                return new int[]{arr[low], arr[high]}; // Min = arr[low], Max = arr[high]
            }
        }

        // Divide the array into two halves
        int mid = (low + high) / 2;
        int[] leftMinMax = findMinMax(arr, low, mid);
        int[] rightMinMax = findMinMax(arr, mid + 1, high);

        // Combine results
        int finalMin = Math.min(leftMinMax[0], rightMinMax[0]);
        int finalMax = Math.max(leftMinMax[1], rightMinMax[1]);

        return new int[]{finalMin, finalMax};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array from user
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Finding min and max using Divide & Conquer
        int[] result = findMinMax(arr, 0, n - 1);

        // Display results
        System.out.println("Minimum element: " + result[0]);
        System.out.println("Maximum element: " + result[1]);

        scanner.close();
    }
}
