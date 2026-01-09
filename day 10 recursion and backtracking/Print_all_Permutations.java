import java.util.*;

public class Print_all_Permutations {   // TC : O(n! x n)

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, nums.length, res);
        return res;
    }

    static void backtrack(int index, int[] a, int n, List<List<Integer>> res) {
        // if temp size equals nums length, add copy to result
        // iterate over nums
        // skip used elements
        // mark used, add element
        // recursive call
        // unmark used, remove element
        if(index == n){
            List<Integer> t = new ArrayList<>();
            for(int i=0; i<n; i++){
                t.add(a[i]);
            }
            res.add(t);
        }
        for(int i=index; i<n; i++){     // Be Careful
            swap(i, index, a);
            backtrack(index+1, a, n, res);
            swap(i, index, a);
        }
    }
    
    static void swap(int p, int q, int a[]){
        int t = a[p];
        a[p] = a[q];
        a[q] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
