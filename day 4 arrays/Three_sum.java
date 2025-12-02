import java.util.*;

public class Three_sum {
    public static void main(String[] args) {
        int a[] = {-1, 0, 1, 2, -1, -4};                      // target = 0
        System.out.println(find(a));
    }
    static List<List<Integer>> find(int a[]){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        int n = a.length;
        for(int i=0; i<n; i++){
            if(i>0 && a[i-1] == a[i]) continue;
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int sum = a[i]+a[j]+a[k];
                if(sum == 0){
                    ans.add(Arrays.asList(a[i],a[j],a[k]));
                    j++; k--;
                    while(j > k && a[j] == a[j-1]) j++;
                    while(j > k && a[k] == a[k+1]) k--;
                }
                if(sum < 0)
                    j++;
                if(sum > 0)
                    k--;
            }
        }
        return ans;
    }
}
