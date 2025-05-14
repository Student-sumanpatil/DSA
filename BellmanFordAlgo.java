import java.util.*;

class BellmanFordAlgo{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        System.out.println("Enter the number of edges: ");
        int e =  sc.nextInt();
        
        int[][] adj = new int[n][n];
        
        ArrayList<Edge> adjList = new ArrayList<>();
        
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
            adjList.add(new Edge(u, v, wt));
        }
        
        System.out.println("\nAdjacency list: ");
        for(Edge edge: adjList){
            System.out.println(edge.src+" -> "+ edge.dest+" (Weight: "+ edge.wt+ ")");
        }
      
       System.out.println("Enter the starting point: ");
       int st = sc.nextInt();
        bellmanFord(adjList, n, st);
    }

    public static void bellmanFord(ArrayList<Edge> adjList, int n, int st){
        int dist[] = new int[n];
        int parent[] = new int[n];
        
        for(int i=0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        dist[st] = 0;
        
        for(int i=0; i < n; i++){
            for(Edge edge: adjList){
                if(dist[edge.dest] > dist[edge.src]+edge.wt && dist[edge.src] != Integer.MAX_VALUE){
                    dist[edge.dest] = dist[edge.src]+ edge.wt;
                    parent[edge.dest] = edge.src;
                }
            }
        }
        
        for(Edge edge: adjList){
            if(dist[edge.dest] > dist[edge.src]+ edge.wt && dist[edge.src] != Integer.MAX_VALUE){
                System.out.println("Negatice weight cycle contains");
                return;
            }
        }
        
        for(int i=0 ; i< n; i++){
            if(i != st){
                System.out.print(st +" -> "+ i +" = "+ dist[i]+", ");
                int j = i;
                System.out.print(j + " -> "+ parent[j]);
                j = parent[j];
                while(j != st){
                    System.out.print(" -> "+ parent[j]);
                    j = parent[j];
                }
                System.out.println();
            }
        }
    }
}



class Edge{
    int src, dest, wt;
    Edge(int src, int dest, int wt){
        this.src= src;
        this.dest = dest;
        this.wt = wt;
    }
}
    
