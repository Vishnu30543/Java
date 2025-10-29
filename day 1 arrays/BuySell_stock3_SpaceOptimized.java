public class BuySell_stock3_SpaceOptimized {     // We only need curr & Tmr values in dp
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int limit = 3;
        System.out.println(track(a,limit));
    }
    static int track(int a[], int limit){
        int n = a.length;
        int cur[] = new int[limit*2 +1];        // 4 + 1 transactions 
        int before[] = new int[limit*2 +1];     // buy sell buy sell
        for(int ind=n-1; ind>=0; ind--){        // 0    1   2    3
            for(int trans=3; trans>=0; trans--){
                if(trans%2 == 0){
                    cur[trans] = Math.max(-a[ind] + before[trans+1],
                                                    0+before[trans]);
                }
                else{
                    cur[trans] = Math.max(a[ind] + before[trans+1],
                                                    0+before[trans]);
                }
            }
            before = cur.clone();
        }
        return cur[0];
    }
}
