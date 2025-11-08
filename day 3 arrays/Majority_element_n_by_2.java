import java.util.*;

public class Majority_element_n_by_2 {
    public static void main(String[] args) {
        int a[] = {2,2,1,1,1,2,2};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> i : mp.entrySet()){
            if(i.getValue() > n/2) return i.getKey();
        }
        return 0;
    }
}
