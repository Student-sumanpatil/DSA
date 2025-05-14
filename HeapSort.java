import java.util.*;
class Main{
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    
    public static void heapify(Student arr[], int idx, int size){
        int max = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;
        
        if(left< size && arr[left].compareTo(arr[max])>0){
            max = left;
        }
        if(right < size && arr[right].compareTo(arr[max]) > 0){
            max = right;
        }
        Student temp = arr[max];
        arr[max] = arr[idx];
        arr[idx] = temp;
        
        if(idx != max){
            heapify(arr, max, size);
        }
    }
    
    public static void heapSort(Student arr[]){
        int n = arr.length;
        
        //build max heap
        for(int i= (n/2)-1; i >= 0; i--){
            heapify(arr, i, n);
        }
        
        for(int i= n-1; i > 0; i--){
            Student temp = arr[0];
            arr[0]= arr[i];
            arr[i] = temp;
            heapify(arr,0, i);
        }
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        Student students[]= new Student[n];
        for(int i=0; i < n; i++){
            System.out.println("Enter the student name: ");
            String name = sc.nextLine();
            
            System.out.println("Enter the student rank: ");
            int rank = sc.nextInt();
            sc.nextLine();
            
            students[i] = new Student(name, rank);
        }
        
       heapSort(students);
        
        for(int i=0; i < n; i++){
            System.out.println("Student: "+ students[i].name+ ", Rank: "+ students[i].rank);
        }
        
    }
}
