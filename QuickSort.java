import java.util.*;

public class QuickSort{
  public static void main(String args[]){
      
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    
    int arr[] = new int[n];
    System.out.println("Enter the elements in the array: ");
    for(int i=0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    quickSort(arr, 0, n-1);
    display(arr);
  }
  
  public static void quickSort(int arr[], int low, int high){
    
     if(low < high){
        
        int partitionIdx = partition(arr, low, high);
        quickSort(arr, low, partitionIdx-1);
        quickSort(arr, partitionIdx+1, high);
     }
  }
  
  public static int partition(int arr[], int low, int high){
      int pivot = arr[low];
      int i = low;
      int j = high;
      
      while(i < j){
          while(arr[i] <= pivot && i <= high-1){
            i++;
          }
          
           while(arr[j] >= pivot && j >= low+1){
             j--;
          }
          if(i < j){
              swap(arr, i, j);
          }
      }
      swap(arr, low, j);
      return j;
  }
  
  public static void swap(int arr[], int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
  
  public static void display(int arr[]){
      for(int num: arr){
          System.out.print(num+" ");
      }
  }
}
