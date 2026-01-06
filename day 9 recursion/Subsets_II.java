import java.util.*;

public class Subsets_II {   // TC : SC : O(n × 2ⁿ)

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        // Step 1: Sort the array to handle duplicates
        // Step 2: Create result list to store all subsets
        // Step 3: Create a temporary list to build subsets
        // Step 4: Call recursive backtracking function
        // Step 5: Return final result

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        backtrack(0, nums, nums.length, l, res);
        return res;
    }

    public static void backtrack(int ind, int[] a, int n, List<Integer> l, List<List<Integer>> res) {
        // Step 1: Add current subset to result
        // Step 2: Loop from index to end of array
        // Step 3: Skip duplicates
        // Step 4: Include current element
        // Step 5: Recursive call for next index
        // Step 6: Remove last element (backtrack)

        res.add(new ArrayList<>(l));

        for(int i=ind; i<n; i++){
            if(i > ind && a[i] == a[i-1]) continue;    // i != ind
            l.add(a[i]);
            backtrack(i+1, a, n, l, res);
            l.remove(l.size() - 1);
        }
    }
}
