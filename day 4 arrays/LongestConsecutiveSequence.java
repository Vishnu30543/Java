import java.util.*;

public class LongestConsecutiveSequence {   // Input Array manipulated
    public static void main(String[] args) {        // TC : O(nlogn) (Sorting)
        int a[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        Arrays.sort(a);
        if(n == 0) return 0;
        int longest = 1;
        int cnt = 0;
        for(int i=1; i<n; i++){
            //  Duplicate number
            if(a[i] == a[i-1]) continue;
            
            else if(a[i] == a[i-1] + 1)   //  Consecutive Sequence
                cnt++;
            else                          // Start form Begin
                cnt = 1;
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
