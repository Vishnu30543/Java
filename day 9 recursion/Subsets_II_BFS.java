import java.util.*;

public class Subsets_II_BFS {   // TC : SC : O(n × 2ⁿ)

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }

   
    public static List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int n = a.length;
        int start = 0, end = 0;

        for(int i=0; i<n; i++){
            start = (i>0 && a[i] == a[i-1])? end : 0;
            end = res.size();           // Be Carefull

            for(int j=start; j<end; j++){
                List<Integer> t = new ArrayList<>(res.get(j));
                t.add(a[i]);            // Be Carefull
                res.add(t);
            }
        }
        return res;
    }
}
