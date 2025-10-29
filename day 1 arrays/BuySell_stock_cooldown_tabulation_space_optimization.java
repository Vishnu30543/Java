public class BuySell_stock_cooldown_tabulation_space_optimization {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println(recur(a));
    }
    static int recur(int a[]){
        int n = a.length;
        int front2[] = new int[2];
        int front1[] = new int[2];
        int cur[] = new int[2];

        for(int ind=n-1; ind>=0; ind--){ 

            cur[1] = Math.max(-a[ind] + front1[0],
                                        0+front1[1]);

            cur[0] = Math.max(a[ind] + front2[1],
                                        0+front1[0]);
            front2 = front1.clone();
            front1 = cur.clone();
        }
        return cur[1];
    }
}
