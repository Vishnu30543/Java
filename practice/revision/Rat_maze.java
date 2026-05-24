import java.util.ArrayList;
import java.util.List;

public class Rat_maze {
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
    static List<String> findPath(int grid[][], int n){
        // String path = "DLRU";
        int di[] = {1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        boolean visited[][] = new boolean[n][n];
        List<String> ans = new ArrayList<>();

        if(grid[0][0] == 0) return ans;
        solve(0,0, grid, n, di, dj, "", visited, ans);
        return ans;
    }
    static void solve(int i, int j, int[][] grid, int n, int di[], int dj[], String path, boolean visited[][], List<String> ans){

        if(i == n-1 && j == n-1){
            ans.add(path);
            return;
        }

        visited[i][j] = true;
        String dir = "DLRU";
        for(int d=0; d<4; d++){
            int nexti = i + di[d];
            int nextj = j + dj[d];
            if(isSafe(nexti, nextj, grid, n, d, visited)){
                solve(nexti, nextj, grid, n, di, dj, path+dir.charAt(d), visited, ans);
            }
        }
        visited[i][j] = false;
    }
    static boolean isSafe(int i, int j, int grid[][], int n, int d, boolean visited[][]){
        if(i < 0 || j < 0 || i >= n || j >= n) return false;
        if(grid[i][j] == 0) return false;
        if(visited[i][j] == true) return false;

        return true;
    }
}
