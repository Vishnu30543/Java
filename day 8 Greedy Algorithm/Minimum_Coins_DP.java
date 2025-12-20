import java.util.Arrays;

public class Minimum_Coins_DP { // TC: O(amount × number_of_coins) SC : O(amonunt)

    static int coinChange(int[] coins, int amount) {

        // Step 1: Create DP array where dp[i] = minimum coins to make amount i
        // Step 2: Initialize dp array with a large value (unreachable)
        // Step 3: Base case: dp[0] = 0
        // Step 4: For each amount, try all coin denominations
        // Step 5: Return dp[amount] or -1 if not possible
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1);      // large number
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int c : coins){
                if(c <= i){
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }

        return (dp[amount] > amount)? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
