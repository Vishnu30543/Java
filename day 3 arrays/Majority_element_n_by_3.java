import java.util.*;

public class Majority_element_n_by_3 {
    public static void main(String[] args) {
        int a[] = {2,2,1,1,1,2,2};
        System.out.println(Arrays.toString(find(a)));
    }
    static int[] find(int a[]){
        int n = a.length;
        int res[] = new int[2];     // Max possiblity of > n/3 freq ele is 2
        int j=0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(a[i], mp.getOrDefault(a[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> i : mp.entrySet()){
            if(i.getValue() > n/3)
                res[j++] = i.getKey();
        }
        Arrays.copyOf(res, j);
        Arrays.sort(res);
        return res;
    }
}
