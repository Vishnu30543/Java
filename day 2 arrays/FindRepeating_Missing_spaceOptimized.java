import java.util.Arrays;

public class FindRepeating_Missing_spaceOptimized {
     public static void main(String[] args) {
        int a[] = {1,3,4,2,2};
        System.out.println(Arrays.toString(find(a)));
    }
    static int[] find(int a[]){
        int n = a.length;
        long SN = n * (n+1)/2;
        long S2N = n*(n+1)*(2L*n+1)/6;
        long S=0, S2=0;
        for(int i=0; i<n; i++){
            S += a[i];
            S2 += a[i]*a[i];
        }
        long diff = S - SN;           // x - y
        long sqdiff = S2 - S2N;
        long sum = sqdiff/diff;       // x + y
        long x = (sum + diff) / 2;
        long y = sum - x;
        return new int[]{(int)x, (int)y};
    }
}
