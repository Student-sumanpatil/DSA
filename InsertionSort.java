import java.util.*;

public class InsertionSort{
  public static void main(String args[]){
      
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    
    int arr[] = new int[n];
    System.out.println("Enter the elements in the array: ");
    for(int i=0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    insertionSort(arr, n);
    display(arr);
  }
  
  public static void insertionSort(int arr[], int n){
      for(int i=0; i < n; i++){
         int j = i;
         
         while(j > 0 && arr[j-1] > arr[j]){
             int temp = arr[j-1];
             arr[j-1] = arr[j];
             arr[j] = temp;
             j--;
         }
      }
  }
  
  public static void display(int arr[]){
      for(int num: arr){
          System.out.print(num+" ");
      }
  }
}
