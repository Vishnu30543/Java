import java.util.*;

public class length_of_maxSubarray_withSum_equals_k_better {
    public static void main(String[] args) {    // Supports -ve No.'s
        int a[] = {3,4,7,2,-3,1,4,2};
        int k = 7;
        System.out.println(count(a,k));
    }
    static int count(int a[], int k){
        int n = a.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int maxlen = 0, presum = 0;
        mp.put(0, -1);
        for(int i=0; i<n; i++){
            presum += a[i];

            if(mp.containsKey(presum-k)){
                maxlen = Math.max(maxlen, mp.get(presum-k));
            }
            mp.putIfAbsent(presum, i);
        }
        return maxlen;
    }
}
