import java.util.Arrays;

public class Fractional_Knapsack_array {    // SC : O(n) TC : O(nlogn)

    static double fractionalKnapsack(int val[], int wt[], int capacity){

        // Step 1: Create index array instead of Item objects
        // Step 2: Sort items by value/weight ratio (descending)
        // Step 3: Take full items while capacity allows
        // Step 4: Take fractional part if needed
        // Step 5: Return maximum value
        int n = val.length;
        Integer idx[] = new Integer[n];

        for(int i=0; i<n; i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (i,j) -> Double.compare((double)val[j]/wt[j], (double)val[i]/wt[i]));
        /*
            Better :
            Arrays.sort(idx, (i, j) ->
            Long.compare((long) val[j] * wt[i], (long) val[i] * wt[j]));
        */

        double profit = 0.0;
        int capacityleft = capacity;

        for(int i : idx){
            if(capacityleft == 0) break;

            if(wt[i] <= capacityleft){
                profit += val[i];
                capacityleft -= wt[i];
            }
            else{
                profit += ((double)val[i]/wt[i])*capacityleft;
                capacityleft = 0;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        System.out.printf("%.6f%n", fractionalKnapsack(val, wt, capacity));
    }
}
