import java.util.*;

public class LongestConsecutiveSequence_m2 {    // Without input array manipulation but extra space for set
    public static void main(String[] args) {    // TC : O(2n) SC : O(n)
        int a[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        if(n == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(a[i]);
        }
        int longest = 1;
        for(int i : set){
            int ele = i;
            int cnt = 0;
            if(set.contains(ele-1)) continue;
            else{
                while(set.contains(ele)){
                    ele++;
                    cnt++;
                }
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
