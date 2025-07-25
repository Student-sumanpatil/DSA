package Array;

import java.util.*;

public class WaveSort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i=0; i < n; i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        for(int i=0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
