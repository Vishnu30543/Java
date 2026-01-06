import java.util.*;

public class Subset_Sum_equals_to_target {  // TC : SC : O(n × target)

    static boolean subsetSum(int[] a, int target) {
        // initialize dp or recursion
        // check if subset sum equals target
        // return true if possible else false
        Arrays.sort(a);
        return find(a, a.length, target);
    }

    static boolean find(int a[], int n, int target){
       boolean dp[][] = new boolean[n+1][target+1];
       for(int i=0; i<=n; i++) dp[i][0] = true;

       for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                if(a[i-1] <= target)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - a[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
       }
       return dp[n][target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 5;
        System.out.println(subsetSum(arr, target));
    }
}
