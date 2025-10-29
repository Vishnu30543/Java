public class BuySell_stock2_SpaceOptimized {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println(track(a));
    }
    static int track(int a[]){
        int n = a.length;
        int aheadbuy = 0, aheadnotbuy = 0;
        int curbuy = 0, curnotbuy = 0;

        for(int ind=n-1; ind>=0; ind--){
            curbuy = Math.max(-a[ind]+aheadnotbuy,
                                    0+aheadbuy);
            curnotbuy = Math.max(a[ind]+aheadbuy,
                                    0+aheadnotbuy);

            aheadbuy = curbuy;
            aheadnotbuy = curnotbuy;
        }
        return aheadbuy;
    }
}
