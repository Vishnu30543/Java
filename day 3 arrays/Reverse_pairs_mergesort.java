public class Reverse_pairs_mergesort {
    public static void main(String[] args) {
        int a[] = {1,3,2,3,1};      // nums[i] > 2 * nums[j]
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        return mergesort(a,0,n-1);
    }
    static int mergesort(int a[], int low, int high){
        int count = 0;
        if(low < high){
            int mid = (low + high)/2;
            count += mergesort(a, low, mid);
            count += mergesort(a, mid+1, high);
            count += countPairs(a, low, mid, high);
            merge(a, low, mid, high);
        }
        return count;
    }
    static int countPairs(int a[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int count=0;
        while (left <= mid) {
            while (right <= high && (long)a[left] > 2L * a[right]) {
                right++;
            }
            count += (right-(mid+1));
            left++;
        }
        return count;
    }

    static void merge(int a[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int t[] = new int[high-low+1];
        int j=0;
        while (left <= mid && right <= high) {
            if(a[left] <= a[right]){
                t[j++] = a[left++];
            }
            else{
                t[j++] = a[right++];
            }
        }
        while(left <= mid)
            t[j++] = a[left++];
        while(right <= high)
            t[j++] = a[right++];

        for(int k=low; k<=high; k++)
            a[k] = t[k-low];
    }
}
