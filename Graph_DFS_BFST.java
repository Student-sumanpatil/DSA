import java.util.*;

class Main{
    public static void main(String ags[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        
        int[][] adj = new int[n][n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i < n; i++){
            adjList.add(new ArrayList<>());
            Arrays.fill(adj[i], 0);
        }
        
        for(int i=0; i <e; i++){
            System.out.println("Enter the edges(v, u): ");
            int v = sc.nextInt();
            int u = sc.nextInt();
            adj[v][u] = 1;
            adj[u][v] = 1;
            adjList.get(v).add(u);
            adjList.get(u).add(v);
        }
        
        System.out.println("\nAdjacency matrix: ");
        for(int i=0; i < n; i++){
            for(int j=0; j< n; j++){
                System.out.print(adj[i][j] +" ");
            }
            System.out.println();
        }
        
        System.out.println("\nAdjacency list: ");
        for(int i=0; i < adjList.size(); i++){
            System.out.print(i + " -> ");
            for(int neighbor: adjList.get(i)){
                System.out.print(neighbor +" ");
            }
            System.out.println();
        }
        int vis[] = new int[n];
        System.out.println("\nDFS traversal ");
        dfs(adjList, 0, vis);
        
        System.out.println("\nBFS traversal ");
        bfs(adjList, 0, n);
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adjList, int node, int vis[]){
        vis[node] = 1;
        System.out.print(node+" ");
        
        for(int neighbor: adjList.get(node)){
            if(vis[neighbor] == 0){
                dfs(adjList, neighbor, vis);
            }
        }
    }
    
    public static void bfs(ArrayList<ArrayList<Integer>> adjList, int node, int n){
        
        int vis[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;
        
        while(!q.isEmpty()){
            node = q.poll();
            System.out.print(node+" ");
            
            for(int neighbor: adjList.get(node)){
                if(vis[neighbor] == 0){
                    vis[neighbor] = 1;
                    q.add(neighbor);
                }
            }
        }
    }
}
