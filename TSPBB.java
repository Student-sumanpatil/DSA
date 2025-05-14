import java.util.*;

class TSPBB{
    static int n;
    static int mincost = Integer.MAX_VALUE;
    static List<Integer> bestpath = new ArrayList<>();
    
    public static void tsp(int graph[][], int currpos, int cost, boolean[] vis, List<Integer> path){
        
        if(path.size() == n){
            int finalcost = cost + graph[currpos][0];
            if(finalcost < mincost){
                mincost = finalcost;
                bestpath = new ArrayList<>(path);
            }
        }
        
        for(int i=0; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                path.add(i);
                tsp(graph, i, cost+graph[currpos][i], vis,path);
                vis[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
    
    
    public static void main(String agrs[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        boolean[] vis= new boolean[n];
        tsp(graph, 0, 0, vis, bestpath);
        System.out.println("\nBest path: "+ bestpath);
        System.out.println("\nMin cost: "+ mincost);
    }
}
