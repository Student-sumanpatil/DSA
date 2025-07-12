import java.util.*;

public class MergeSort{
  public static void main(String args[]){
      
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    
    int arr[] = new int[n];
    System.out.println("Enter the elements in the array: ");
    for(int i=0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    mergeSort(arr, 0, n-1);
    display(arr);
  }
  
  public static void mergeSort(int arr[], int low, int high){
     if(low == high){
         return;
     }
     int mid = (low+high)/2;
     mergeSort(arr, low, mid);
     mergeSort(arr, mid+1, high);
     merge(arr, low, mid, high);
  }
  
  public static void merge(int arr[], int low, int mid, int high){
      int temp[] = new int[10];
      int k = low;
      int i = low;
      int j = mid+1;
      
      while(i <= mid && j <= high){
          if(arr[i] < arr[j]){
              temp[k] = arr[i];
              i++; k++;
          }
          else{
              temp[k] = arr[j];
              k++; j++;
          }
      }
      
      while(i <= mid){
          temp[k] = arr[i];
          k++; i++;
      }
      while(j <= high){
          temp[k] = arr[j];
          k++; j++;
      }
      for(int l = low;l <= high; l++){
          arr[l] = temp[l];
      }
  }
  
  
  
  public static void display(int arr[]){
      for(int num: arr){
          System.out.print(num+" ");
      }
  }
}
