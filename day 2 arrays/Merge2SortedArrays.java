public class Merge2SortedArrays {       // Gap Method
    public static void main(String[] args) {
        int a[] = {1,3,5,7},   b[] = {0,2,6,8,9};
        merge(a,b);

        System.out.print("Array A: ");
        for (int x : a) System.out.print(x + " ");
        System.out.println();

        System.out.print("Array B: ");
        for (int x : b) System.out.print(x + " ");
    }
    static void merge(int a[], int b[]){
        int n = a.length, m = b.length;
        int gap = nextgap(n+m);
        while (gap > 0) {
            int len = a.length + b.length;
            int left = 0;
            int right = left + gap;
            
            while (right < len) {
                if(left<n && right<n)           // Both pointers in a[]
                    swap(a, a, left, right);
                else if(left<n && right>=n)      // left pointer in a[] & right pointer in b[]
                    swap(a, b, left, right-n);
                else                            // Both pointers in b[]
                    swap(b, b, left-n, right-n);
                
                right++;
                left++;
            }
            gap = nextgap(gap);
        }
    }
    static void swap(int a[], int b[], int i, int j){
        if(a[i] > b[j]){
            int t = a[i];
            a[i] = b[j];
            b[j] = t;
        }
    }
    static int nextgap(int gap){
        if(gap <= 1)
            return 0;
        return (gap/2) + (gap%2);
    }
}
