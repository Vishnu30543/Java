import java.util.*;

public class Rat_In_Maze {

    public static void main(String[] args) {
        int n = 4;
        int[][] grid = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        System.out.println(findPath(grid, n));
    }

    public static List<String> findPath(int[][] grid, int n) {
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        // Check if starting cell is valid
        // Start backtracking from (0,0)
        // Set Direction Arrays     DLRU (Lexicographical)

        int di[] = {1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        if(grid[0][0] == 1) solve(0, 0, grid, n, visited, "", ans, di, dj);
        return ans;
    }

    private static void solve(int i, int j, int[][] grid, int n,
                              boolean[][] visited, String path, List<String> ans, int di[], int dj[]) {
        // If destination (n-1, n-1) is reached, add path to answer
        // Mark current cell as visited
        // Try all 4 possible directions in order (D, L, R, U)
        // Check boundary, visited, and valid cell conditions
        // Recurse with updated path
        // Unmark current cell (backtrack)
        if(i == n-1 && j == n-1){
            ans.add(path);
            return;
        }
        String dir = "DLRU";
        // Loop all Directions
        for(int d=0; d<di.length; d++){
            int nexti = i + di[d];
            int nextj = j + dj[d];
            if(isSafe(nexti, nextj, grid, n, visited)){
                visited[i][j] = true;
                solve(nexti, nextj, grid, n, visited, path+dir.charAt(d), ans, di, dj);
                visited[i][j] = false;
            }
        }
    }

    private static boolean isSafe(int i, int j, int[][] grid, int n, boolean[][] visited) {
        // Check bounds
        // Check if cell is not visited
        // Check if cell value is 1
        if(i < 0 || j < 0 || i >= n || j >= n) return false;
        if(visited[i][j] == true) return false;
        if(grid[i][j] == 0) return false;
        return true;
    }
}
