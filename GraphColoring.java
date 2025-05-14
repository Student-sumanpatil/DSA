import java.util.*;

class GraphColoring{
    static int x[];
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        System.out.println("Enter the number of edges: ");
        int e =  sc.nextInt();
        
        x = new int[n];
        int[][] adj = new int[n][n];
        
        for(int i=0; i < n; i++){
            Arrays.fill(adj[i], 0);
        }
        
        for(int i=0; i < e; i++){
            System.out.println("Enter the edge(u, v): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        System.out.println("Enter the number of colors: ");
        int m = sc.nextInt();
        
        graphColor(adj, n, m, 0);
    }
    
    public static void graphColor(int[][] adj, int n, int m, int v){
        if(v == n){
            for(int c: x){
                System.out.print(c+1+" ");
            }
            System.out.println();
            return;
        }
        
        for(int col = 0; col < m; col++){
            if(isSafe(adj, v, col)){
                x[v] = col;
                graphColor(adj, n, m, v+1);
            }
        }
    }
    
    public static boolean isSafe(int[][] adj, int v, int col){
        for(int i= 0; i < v; i++){
            if(x[i] == col && adj[v][i] == 1){
                return false;
            }
        }
        return true;
    }
}
    
