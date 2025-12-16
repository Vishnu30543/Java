import java.util.Arrays;

public class Longest_increasing_subsequence_Expression {    // O(n^2)
    public static void main(String[] args) {
        int a[] = {15,6,5,12,1};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, 1);

        int maxlen = 1;
        int start = 0, end = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){

                // Condition 1 : It should be increasing number
                if(a[i] > a[j]){
                    // Condition 2 : Given Exp. ( Ai[x] & Ai[x+1] ) * 2 < ( Ai[x] | Ai[x+1] )
                    int and = a[j] & a[i];
                    int or = a[j] | a[i];

                    if(and * 2 < or){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                        start = j; end = i;
                    }
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        System.out.print("Numbers are : ");
        for(int i=start; i<=end; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        return maxlen;
    }
}
