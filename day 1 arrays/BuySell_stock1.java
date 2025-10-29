public class BuySell_stock1 {
    public static void main(String[] args) {
        int a[] = {7,1,5,3,6,4};
        System.out.println(track(a));
    }
    static int track(int a[]){
        int n = a.length;
        int min = a[0], profit = 0, max = 0;
        for (int i = 1; i < n; i++) {
            profit = a[i] - min;
            if(max < profit)
                max = profit;
            min = Math.min(a[i], min);
        }
        return max;
    }
}
