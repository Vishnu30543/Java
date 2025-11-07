import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int a[] = {64, 34, 25, 12, 22, 11, 90};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    static void sort(int a[]){
        int n = a.length;
        boolean swapped = false;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(a[j] > a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    swapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if(!swapped) break;             // For optimization
        }
    }
}
