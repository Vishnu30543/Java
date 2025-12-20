import java.util.Arrays;

public class Fractional_Knapsack_class {    // SC : O(n) TC : O(nlogn)

    static class Items{
        int value;
        int weight;

        Items(int v, int w){
            value = v;
            weight = w;
        }
    }
    static double fractionalKnapsack(int val[], int wt[], int capacity){

        // Step 1: Create Item objects from value and weight arrays
        // Step 2: Sort items by value/weight ratio (descending)
        // Step 3: Take full items while capacity allows
        // Step 4: Take fractional part if needed
        // Step 5: Return maximum value
        int n = val.length;
        Items it[] = new Items[n];
        for(int i=0; i<n; i++){
            it[i] = new Items(val[i],wt[i]);
        }

        Arrays.sort(it, (a,b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        /*
            Arrays.sort(items, (a, b) -> {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            return Double.compare(ratioB, ratioA); // Note: b then a for descending
            });

            Arrays.sort(items, Comparator.comparingDouble((Item i) -> 
                        (double) i.value / i.weight).reversed());
        */

        double profit = 0.0;
        int capacityleft = capacity;

        for(Items i : it){
            if(capacityleft == 0) break;

            if(i.weight <= capacityleft){
                profit += i.value;
                capacityleft -= i.weight;
            }
            else{
                profit += ((double)i.value/i.weight)*capacityleft;
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
