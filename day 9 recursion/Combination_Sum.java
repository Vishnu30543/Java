import java.util.*;

public class Combination_Sum {  // TC : O(2ⁿ)

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] a, int target) {
        // Step 1: Sort the array (helps in pruning & ordered traversal)
        // Step 2: Create result list to store all valid combinations
        // Step 3: Call recursive backtracking function
        // Step 4: Return the result

        Arrays.sort(a);     // Optional
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, a, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int ind, int target, int[] a,
                                 List<Integer> t,
                                 List<List<Integer>> res) {

        // Step 1: If target becomes 0 → valid combination found
        // Add temp list to result and return
        // Step 2: If target < 0 → stop exploring this path (pruning)
        // Step 3: Loop from index to end of array
            // Step 4: Choose current number
            // Step 5: Recurse with updated target
            // (same index allowed since elements can be reused)
            // Step 6: Backtrack (remove last element)

        if(target == 0) {
            res.add(new ArrayList<>(t));
            return;
        }
        if(target < 0) return;

        for(int i=ind; i<a.length; i++){
            t.add(a[i]);
            backtrack(i, target - a[i], a, t, res);
            t.remove(t.size()-1);
        }
    }
}
