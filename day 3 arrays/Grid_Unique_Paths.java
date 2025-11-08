import java.util.Arrays;

public class Grid_Unique_Paths {        // TC & SC : O(mxn)
    public static void main(String[] args) {
        int m=3, n=2;
        int dp[][] = new int[m][n];
        for(int i[] : dp)
            Arrays.fill(i, -1);
        System.out.println(find(m,n, 0,0,dp));
    }

    static int find(int m, int n, int i, int j, int dp[][]) {
        if(i >= m || j>= n) return 0;
        if(i == m-1 && j == n-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = find(m,n,i+1,j,dp) + find(m, n, i, j+1, dp);
    }
}
