public class BuySell_stock3_Tabular {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int limit = 3;
        System.out.println(track(a,limit));
    }
    static int track(int a[], int limit){
        int n = a.length;
        int dp[][][] = new int[n+1][2][limit+1];
        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                for(int l=1; l<=limit; l++){
                    if(buy == 1){
                        dp[ind][buy][l] = Math.max(-a[ind] + dp[ind+1][0][l],
                                                        0+dp[ind+1][1][l]);
                    }
                    else{
                        dp[ind][buy][l] = Math.max(a[ind] + dp[ind+1][1][l-1],
                                                        0+dp[ind+1][0][l]);
                    }
                }
            }
        }
        return dp[0][1][limit];
    }
}
