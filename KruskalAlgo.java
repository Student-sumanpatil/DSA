import java.util.*;

class KruskalAlgo{
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
        
        Collections.sort(adjList, Comparator.comparingInt(e1 -> e1.wt));
        
        System.out.println("\nSorted adjacency list: ");
        for(Edge edge: adjList){
            System.out.println(edge.src+" -> "+ edge.dest+" (Weight: "+ edge.wt+ ")");
        }
      
        kruskalAlgo(adjList, n);
    }
    
    public static void kruskalAlgo(ArrayList<Edge> adjList, int  n){
        int mst= 0;
        int noe= 0;
        ArrayList<Edge> mstEdge = new ArrayList<>();
        Disjoint ds = new Disjoint(n);
        
        for(Edge edge: adjList){
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.wt;
            
            if(ds.findPar(u) != ds.findPar(v)){
                mst += wt;
                noe++;
                mstEdge.add(edge);
                ds.unionByCount(u, v);
                if(noe == n-1)break;
            }
        }
        
        System.out.println("\nMST: "+ mst);
        for(Edge edge: mstEdge){
            System.out.println(edge.src +" -> "+ edge.dest+" (Weight: "+ edge.wt+")");
        }
    }
    
}

class Disjoint{
    static int parent[];
    static int count[];
    
    Disjoint(int n){
        this.parent = new int[n];
        this.count = new int[n];
        for(int i=0; i < n; i++){
            parent[i] = i;
            count[i] = 1;
        }
    }
    
    public static int findPar(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findPar(parent[node]);
    }
    
    public static void unionByCount(int u, int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        
        if(ulp_u == ulp_v)return;
        if(count[ulp_u] > count[ulp_v]){
            parent[ulp_v] = ulp_u;
            count[ulp_u] += count[ulp_v];
        }
        else{
            parent[ulp_u] = ulp_v;
            count[ulp_v] += count[ulp_u];
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
    
