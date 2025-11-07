import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int a[] = {64, 34, 25, 12, 22, 11, 90};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    static void sort(int a[]){
        int n = a.length;
        mergesort(a,0,n-1);
    }
    //  Divide
    static void mergesort(int a[], int low, int high){
        if(low >= high) return;
        int mid = (low + high) /2;
        mergesort(a, low, mid);
        mergesort(a, mid+1, high);
        merge(a, low, mid, high);
    }
    static void merge(int a[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int ans[] = new int[high - low + 1];
        int i=0;
        while(left <= mid && right <= high){
            if(a[left] > a[right])
                ans[i++] = a[right++];
            else
                ans[i++] = a[left++];
        }
        while(left <= mid)
            ans[i++] = a[left++];
        while(right <= high)
            ans[i++] = a[right++];

        for(i=low; i<=high; i++)
            a[i] = ans[i-low];
    }
}
