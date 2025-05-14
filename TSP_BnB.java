import java.util.*;

class TSP_BnB {
    private static int N;
    private static int minCost = Integer.MAX_VALUE;
    private static List<Integer> bestPath = new ArrayList<>();

    static void tspBnB(int[][] graph, int currPos, int cost, boolean[] visited, List<Integer> path) {
        // If all cities are visited
        if (path.size() == N) {
            int finalCost = cost + graph[currPos][0]; // Returning to the starting city
            if (finalCost < minCost) {
                minCost = finalCost;
                bestPath = new ArrayList<>(path);
            }
            return;
        }

        // Try visiting all cities
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(i);
                tspBnB(graph, i, cost + graph[currPos][i], visited, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cities:");
        N = sc.nextInt();
        int[][] graph = new int[N][N];

        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = sc.nextInt();

        boolean[] visited = new boolean[N];
        visited[0] = true; // Start from city 0
        
        List<Integer> path = new ArrayList<>();
        path.add(0);

        tspBnB(graph, 0, 0, visited, path);

        // Output the best path and cost
        System.out.println("Optimal path: " + bestPath + " -> 0");
        System.out.println("Minimum cost: " + minCost);
    }
}
