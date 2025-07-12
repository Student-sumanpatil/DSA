import java.util.*;

public class SelectionSort{
  public static void main(String args[]){
      
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    
    int arr[] = new int[n];
    System.out.println("Enter the elements in the array: ");
    for(int i=0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    selectionSort(arr, n);
    display(arr);
  }
  
  public static void selectionSort(int arr[], int n){
      for(int i=0; i < n-2; i++){
          int min = i;
          for(int j=i; j < n-1; j++){
              if(arr[j] < arr[min]){
                  min = j;
              }
          }
          int temp = arr[i];
          arr[i] = arr[min];
          arr[min] = temp;
      }
  }
  
  public static void display(int arr[]){
      for(int num: arr){
          System.out.print(num+" ");
      }
  }
}
