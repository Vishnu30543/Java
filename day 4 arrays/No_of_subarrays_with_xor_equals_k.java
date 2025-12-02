import java.util.*;

public class No_of_subarrays_with_xor_equals_k {
    public static void main(String[] args) {
        int a[] = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(find(a,k));
    }
    static int find(int a[], int k){
        int n = a.length;
        int cnt = 0;
        int x = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            x ^= a[i];
            cnt += mp.getOrDefault(x^k, 0);

            if(x == k)
                cnt += 1;

            mp.put(x, mp.getOrDefault(x, 0)+1);
        }
        return cnt;
    }
}
