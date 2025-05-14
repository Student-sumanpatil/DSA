import java.util.*;

class PrimsAlgorithm{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        System.out.println("Enter the number of edges: ");
        int e =  sc.nextInt();
        
        int[][] adj = new int[n][n];
        for(int i=0; i < n; i++){
            Arrays.fill(adj[i], 0);
        }
        for(int i=0; i < e; i++){
            System.out.println("Enter the edge(u, v, wt): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            adj[u][v] = wt;
            adj[v][u] = wt;
        }
        
        System.out.println("\nAdjacency matrix: ");
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
        
        int[][] costmatrix = new int[n][n];
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(adj[i][j] == 0){
                    costmatrix[i][j] = Integer.MAX_VALUE;
                }
                else{
                    costmatrix[i][j] = adj[i][j];
                }
            }
        }
        
        System.out.println("\nCostmatrix: ");
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(costmatrix[i][j] == Integer.MAX_VALUE){
                    System.out.print("INX" +" ");
                }
                else{
                    System.out.print(costmatrix[i][j]+" ");
                }
            }
            System.out.println();
        }
        
        System.out.println("\nEnter the starting vertex: ");
        int st = sc.nextInt();
        
        prims(costmatrix, st, n);
    }
    
    public static void prims(int[][] costmatrix, int st, int n){
        int dist[] = new int[n];
        int vis[] = new int[n];
        int from[] = new int[n];
        
        for(int i=0; i < n; i++){
            dist[i] = costmatrix[st][i];
            vis[i] = 0;
            from[i] = 0;
        }
        vis[st]=1;
        int mst = 0;
        int noe = 0;
        
        while(noe < n-1){
            int mindist = Integer.MAX_VALUE;
            int u = -1;
            
            for(int i=0; i < n; i++){
                if(vis[i] == 0 && mindist > dist[i]){
                    mindist = dist[i];
                    u = i;
                }
            }
            
            vis[u] = 1;
            mst += mindist;
            noe++;
            
            for(int i=0; i<n; i++){
                if(vis[i] == 0 && dist[i] > costmatrix[u][i] && costmatrix[u][i] != Integer.MAX_VALUE){
                    dist[i] = costmatrix[u][i];
                    from[i] = u;
                }
            }
        }
        
        System.out.println("\nMST: "+ mst);
        
        System.out.println("\nPath: ");
        for(int i=0; i < n; i++){
            if(i < n-1){
                System.out.print(i + " -> "+ from[i]+", ");
            }
            else{
                System.out.print(i+" -> "+ from[i]);
            }
        }
    }
}
