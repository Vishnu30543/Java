import java.util.Arrays;

public class BuySell_stock_cooldown_tabulation {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println(recur(a));
    }
    static int recur(int a[]){
        int n = a.length;
        int dp[][] = new int[n+2][2];
        for(int ind=n-1; ind>=0; ind--){    // Removed buy loop

            dp[ind][1] = Math.max(-a[ind] + dp[ind+1][0],
                                        0+dp[ind+1][1]);

            dp[ind][0] = Math.max(a[ind] + dp[ind+2][1],
                                        0+dp[ind+1][0]);
        }
        return dp[0][1];
    }
}

/*
  
     static int recur(int a[]){
        int n = a.length;
        int dp[][] = new int[n+2][2];
        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    dp[ind][buy] = Math.max(-a[ind] + dp[ind+1][0],
                                                0+dp[ind+1][1]);
                }
                else{
                    dp[ind][buy] = Math.max(a[ind] + dp[ind+2][1],
                                                0+dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }
 */