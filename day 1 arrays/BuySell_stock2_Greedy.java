public class BuySell_stock2_Greedy {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println(track(a));
    }
    static int track(int a[]){
        int n = a.length;
        int profit = 0;
        for(int i=0; i<n-1; i++){
            if(a[i+1] > a[i])
                profit += (a[i+1]-a[i]);
        }
        return profit;
    }
}
