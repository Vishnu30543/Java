import java.util.Arrays;

public class BuySell_stock3_Memo_Optimized {        // Recursion takes more time ...
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int limit = 3;
        int dp[][] = new int[a.length][2*limit];
        for(int[] i : dp){
                Arrays.fill(i, -1);
        }
        System.out.println(track(0,0,a,a.length,dp,limit));
        // Index, TransNo, array, length, dp, limit
    }
    static int track(int ind, int transNo, int a[], int n, int dp[][], int limit){
        if(ind == n || transNo == 2*limit) return 0;
        if(dp[ind][transNo] != -1) return dp[ind][transNo];
        if(transNo%2 == 0){
            dp[ind][transNo] = Math.max(-a[ind] + track(ind+1, transNo+1, a, n, dp, limit),
                                            0+track(ind+1, transNo, a, n, dp, limit));
        }
        else{
            dp[ind][transNo] = Math.max(a[ind] + track(ind+1, transNo+1, a, n, dp, limit),
                                            0+track(ind+1, transNo, a, n, dp, limit));
        }
        return dp[ind][transNo];
    }
}
