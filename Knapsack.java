import java.util.*;

class Knapsack{
    static int wt[];
    static int pt[];
    static int capacity;
    static int n;
    static int maxpt = 0;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
    
        wt = new int[n];
        pt = new int[n];
        
        System.out.println("Enter weights: ");
        for(int i=0; i < n; i++){
            wt[i] = sc.nextInt();
        }
        
        System.out.println("Enter profits: ");
        for(int i=0; i < n; i++){
            pt[i] = sc.nextInt();
        }
        
        System.out.println("Enter capacity: ");
        capacity = sc.nextInt();
        
        knapsack(0,0, 0);
        System.out.println("Maximum profit: "+ maxpt);
    }
    
    public static void knapsack(int idx, int currwt, int currpt){
        if(currwt > capacity){
            return;
        }
        
        if(idx == n){
            if(maxpt < currpt ){
                maxpt = currpt;
            }
            return;
        }
        
        knapsack(idx+1, currwt+wt[idx], currpt+ pt[idx]);
        
        knapsack(idx+1, currwt, currpt);
    }
}
    
