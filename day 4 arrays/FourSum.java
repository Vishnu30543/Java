import java.util.*;

public class FourSum {
    public static void main(String[] args) {        // TC : O(n^4)
        int a[] = {-1, 0, 1, 2, -1, -4};       
        int target = 0;               // target = 0
        System.out.println(find(a,target));
    }
    static List<List<Integer>> find(int a[], int target){
        int n = a.length;
        Set<List<Integer>> l = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                Set<Long> set = new HashSet<>();
                for(int k=j+1; k<n; k++){
                    long sum = a[i] + a[j];
                    sum += a[k];
                    long fourth = target - sum;
                    if(set.contains(fourth)){
                        List<Integer> temp = Arrays.asList(a[i],a[j],a[k],(int)fourth);
                        Collections.sort(temp);
                        l.add(temp);
                    }
                    set.add((long)a[k]);
                }
            }
        }
        return new ArrayList<>(l);
    }
}
