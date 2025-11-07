import java.util.Arrays;

public class Count_Inversion_mergesort {
    public static void main(String[] args) {
        int a[] = {2, 3, 7, 1, 3, 5};
        int v = count(a);
        System.out.println("Inversions : "+ v);
        System.out.println(Arrays.toString(a));
    }
    static int count(int a[]){
        return mergesort(a, 0, a.length-1);
    }
    static int mergesort(int a[], int low, int high){
        int count = 0;
        if(low < high){
            int mid = (low + high) / 2;
            count += mergesort(a, low, mid);
            count += mergesort(a, mid+1, high);
            count += merge(a, low, mid, high);
        }
        return count;
    }
    static int merge(int a[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int t[] = new int[high-low+1];
        int i=0, count=0;
        while(left <= mid && right <= high){
            if(a[left] <= a[right]){
                t[i++] = a[left++];
            }
            // Right side is smaller
            else{
                t[i++] = a[right++];
                count += (mid - left + 1);
            }
        }
        while(left <= mid)
            t[i++] = a[left++];
        while(right <= high)
            t[i++] = a[right++];
        
        for(int j=low; j<=high; j++){
            a[j] = t[j-low];
        }
        return count;
    }
}
