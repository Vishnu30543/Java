public class M_Coloring_Problem {

    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        int E = 5;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {0, 2}
        };

        System.out.println(graphColoring(N, edges, M));
    }

    public static boolean graphColoring(int N, int[][] edges, int M) {
        int[][] graph = new int[N][N];
        int[] color = new int[N];
        // Build adjacency matrix from edge list
        // Initialize color array
        // Start recursive coloring from node 0
        for(int e[] : edges){
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
        }
        return solve(0, graph, color, M, N);
    }

    private static boolean solve(int node, int[][] graph, int[] color, int M, int N) {
        // If all nodes are colored, return true
        // Try colors from 1 to M
        // Check if assigning a color is safe
        // Assign color and recurse for next node
        // If recursion fails, remove the color (backtrack)

        if(node == N) return true;
        
        for(int c=1; c<=M; c++){     // color array
            if(isSafe(node, graph, color, c, N)){
                color[node] = c;
                if(solve(node+1, graph, color, M, N) == true)
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, int[][] graph, int[] color, int c, int N) {
        // Check all adjacent nodes
        // If any adjacent node has the same color, return false
        // Return true if color can be assigned
        for(int i=0; i<N; i++){
            if(graph[node][i] == 1 && color[i] == c) return false;
        }
        return true;
    }
}
