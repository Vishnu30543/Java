import java.util.*;

public class TwoSum_Return_index {          // O(n)
    public static void main(String[] args) {
        int a[] = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(find(a,target)));
    }
    static int[] find(int a[], int target){
        int n = a.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            if(mp.containsKey(target-a[i])) return new int[]{i,mp.get(target-a[i])};
            mp.put(a[i], i);
        }
        return new int[]{};
    }
}
