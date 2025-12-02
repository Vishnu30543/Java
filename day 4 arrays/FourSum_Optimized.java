import java.util.*;

public class FourSum_Optimized {
    public static void main(String[] args) {        // TC : O(n^3)
        int a[] = {-1, 0, 1, 2, -1, -4};       
        int target = 0;               // target = 0
        System.out.println(find(a,target));
    }
    static List<List<Integer>> find(int a[], int target){
        int n = a.length;
        Arrays.sort(a);
        List<List<Integer>> s = new ArrayList<>();
        for(int i=0; i<n; i++){                     // i < n-3
            if(i>0 && a[i] == a[i-1]) continue;
            for(int j=i+1; j<n; j++){               // j < n-2
                if(j>i+1 && a[j] == a[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = a[i] + a[j];
                    sum += a[k];
                    sum += a[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(a[i],a[j],a[k],a[l]);
                        s.add(temp);
                        k++; l--;
                        while(k < l && a[k] == a[k-1]) k++;
                        while(k < l && a[l] == a[l+1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return s;
    }
}
