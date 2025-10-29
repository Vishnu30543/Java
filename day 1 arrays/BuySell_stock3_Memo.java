import java.util.Arrays;

public class BuySell_stock3_Memo {          // Recursion -> Gives TLE
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int limit = 3;
        int dp[][][] = new int[a.length][2][limit+1];
        for(int[][] i : dp){
            for(int[] j : i)
                Arrays.fill(j, -1);
        }
        System.out.println(track(0,1,a,a.length,dp,limit));
        // Index, canbuy?, array, length, dp, limit
    }
    static int track(int ind, int buy, int a[], int n, int dp[][][], int limit){
        if(ind == n || limit == 0) return 0;
        if(dp[ind][buy][limit] != -1) return dp[ind][buy][limit];
        if(buy == 1){
            dp[ind][buy][limit] = Math.max(-a[ind] + track(ind+1, 0, a, n, dp, limit),
                                            0+track(ind+1, 1, a, n, dp, limit));
        }
        else{
            dp[ind][buy][limit] = Math.max(a[ind] + track(ind+1, 1, a, n, dp, limit-1),
                                            0+track(ind+1, 0, a, n, dp, limit));
        }
        return dp[ind][buy][limit];
    }
}
