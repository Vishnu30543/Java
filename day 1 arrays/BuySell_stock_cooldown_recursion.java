import java.util.Arrays;

public class BuySell_stock_cooldown_recursion {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int n = a.length;
        int dp[][] = new int[n][2];
        for(int i[] : dp)
            Arrays.fill(i, -1);
        System.out.println(recur(0,1,a,n,dp));
        // index, canbuy?, array, size, dp
    }
    static int recur(int ind, int buy, int a[], int n, int dp[][]){
        if(ind >= n) return 0;      // Careful
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy==1){
            dp[ind][buy] = Math.max(-a[ind] + recur(ind+1,0,a,n,dp),
                                        0+recur(ind+1,1,a,n,dp));
        }
        else{       // Cooling period of 1 extra day
            dp[ind][buy] = Math.max(a[ind] + recur(ind+2,1,a,n,dp),
                                        0+recur(ind+1,0,a,n,dp));
        }
        return dp[ind][buy];
    }
}