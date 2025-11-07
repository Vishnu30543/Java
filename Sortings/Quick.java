import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int a[] = {64, 34, 25, 12, 22, 11, 90};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    static void sort(int a[]){
        qs(a, 0, a.length-1);
    }
    static void qs(int a[], int low, int high){
        if(low < high){
            int pIndex = partition(a,low,high);
            qs(a, low, pIndex-1);
            qs(a, pIndex+1, high);
        }
    }
    static int partition(int a[], int low, int high){
        int pivot = low;
        int i = low;
        int j = high;
        while(i<j){
            while(a[i] <= a[pivot] && i < high)
                i++;
            while(a[j] > a[pivot] && j > low)
                j--;
            if(i < j) swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }
    static void swap(int a[], int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
