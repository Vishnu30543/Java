public class Minimum_Coins_Greedy {     // Not Always correct

    static int coinChange(int[] coins, int amount) {

        // Step 1: For each amount, try all coin denominations
        // Step 2: Return dp[amount] or -1 if not possible
        int n = coins.length;
        int req = 0;
        for(int i=n-1; i>=0; i--){
            if(amount == 0) break;

            if(amount >= coins[i]){
                amount -= coins[i];
                req++;
                i++;
            }
        }
        return req;
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
