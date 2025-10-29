public class BuySell_stock3_Optimized {     // We only need curr & Tmr values in dp
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int limit = 3;
        System.out.println(track(a,limit));
    }
    // Tabular
    static int track(int a[], int limit){
        int n = a.length;
        int cur[][] = new int[2][limit+1];
        int after[][] = new int[2][limit+1];
        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                for(int l=1; l<=limit; l++){
                    if(buy == 1){
                        cur[buy][l] = Math.max(-a[ind] + after[0][l],
                                                        0+after[1][l]);
                    }
                    else{
                        cur[buy][l] = Math.max(a[ind] + after[1][l-1],
                                                        0+after[0][l]);
                    }
                }
                after = cur.clone();
            }
        }
        return after[1][limit];
    }
}
