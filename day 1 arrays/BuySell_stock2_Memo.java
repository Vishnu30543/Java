import java.util.Arrays;

public class BuySell_stock2_Memo {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int dp[][] = new int[a.length][2];
        for(int[] i : dp){
            Arrays.fill(i, -1);;
        }
        System.out.println(track(0,1,a,a.length,dp));
        // Index, canbuy?, array, length, dp
    }
    static int track(int ind, int buy, int a[], int n, int dp[][]){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-a[ind]+track(ind+1, 0, a, n, dp),// Buy
                                0 + track(ind+1, 1, a, n, dp)); // Not buy
        }
        else{   // Sell
            profit = Math.max(a[ind]+track(ind+1, 1, a, n, dp), // Sell
                                0 + track(ind+1, 0, a, n, dp)); // Not sell
        }
        return dp[ind][buy] = profit;
    }
}
