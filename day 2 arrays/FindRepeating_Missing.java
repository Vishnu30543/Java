import java.util.Arrays;

public class FindRepeating_Missing {        // With O(n) extra space
    public static void main(String[] args) {
        int a[] = {1,3,4,2,2};
        System.out.println(Arrays.toString(find(a)));
    }
    static int[] find(int a[]){
        int n = a.length;
        int freq[] = new int[n+1];
        int repeating = -1, missing = -1;
        for(int i=0; i<n; i++){
            freq[a[i]]++;
        }
        for(int i=1; i<=n; i++){
            if(freq[i] >= 2) repeating = i;
            else if(freq[i] == 0) missing = i;
            if(repeating != -1 && missing != -1) break;
        }
        return new int[]{repeating, missing};
    }
}
