import java.util.HashMap;
import java.util.Map;

public class Subarray_k_equals_sum {
    public static void main(String[] args) {
        int a[] = {3,4,7,2,-3,1,4,2};
        int k = 7;
        System.out.println(count(a,k));
    }
    static int count(int a[], int k){
        int n = a.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0, sum = 0;
        for(int i=0; i<n; i++){
            sum += a[i];
            if(sum == k)
                cnt++;
            if(mp.containsKey(sum-k))
                cnt += mp.get(sum-k);

            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}
