import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        
        sc.nextLine();
        Student[] students = new Student[n];
        for(int i=0; i < n; i++){
            System.out.println("Enter the name of student: ");
            String name = sc.nextLine();
            System.out.println("Enter the rank of student: ");
            int rank = sc.nextInt();
            sc.nextLine();
            students[i] = new Student(name, rank);
        }
        
        Maxheap mh = new Maxheap(n);
        for(Student student: students){
            mh.insert(student);
        }
        
        Student topper = mh.delete();
        if(topper != null){
            System.out.println("Topper of class: "+ topper.name);
        }
        
        mh.heapSort(students);
        System.out.println("\nStudent sorted by rank");
        for(Student student: students){
            System.out.println("Name: "+ student.name+ ", Rank: "+ student.rank);
        }
    }
    
}

class Maxheap{
    static int capacity;
    static int size;
    static Student[] heap;
    
    Maxheap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Student[capacity];
    }
    
    public static void insert(Student student){
        if(size == capacity){
            System.out.println("Heap is full, cannot insert");
            return;
        }
        heap[size] = student;
        heapifyUp(size);
        size++;
    }
    
    public static void heapifyUp(int idx){
        
        int parent = (idx-1)/2;
        while(idx > 0 && heap[parent].rank < heap[idx].rank){
            swap(parent, idx);
            idx = parent;
            parent = (idx-1)/2;
        }
    }
    
    public static void heapifyDown(int root, int size){
        int max = root;
        int left = 2*max+1;
        int right = 2*max+2;
        
        if(left < size && heap[max].rank < heap[left].rank){
            max = left;
        }
        if(right < size && heap[max].rank < heap[right].rank){
            max = right;
        }
        
        swap(max, root);
        if(max != root){
            heapifyDown(max, size);
        }
    }
    
    public static Student delete(){
        if(size == 0){
            System.out.println("Heap is empty");
            return null;
        }
        Student topper = heap[0];
        swap(0, size-1);
        size--;
        heapifyDown(0, size);
        return topper;
    }
    
    public static void swap(int i, int j){
        Student temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public static void heapSort(Student[] students){
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.rank));
        pq.addAll(Arrays.asList(students));
        int idx = 0;
        
        while(!pq.isEmpty()){
            students[idx++] = pq.poll();
        }
    }
}

class Student{
    String name;
    int rank;
    Student(String name, int rank){
        this.name = name;
        this.rank = rank;
    }
}
