public class Sort_colors_012 {              // Dutch National Flag
    /*
     * 0 low-1      low mid-1      mid high       high+1 n-1 
     *  0's            1's        Unsorted ele      2's
     * 
     * Start from mid:
     * 1) a[mid] == 0   swap(mid, low)  mid++,low++
     * 2) a[mid] == 1   mid++;
     * 3) a[mid] == 2   swap(mid, high) high--
     * 
     * If(mid > high)   Terminate
     */
    public static void main(String[] args) {
        int a[] = {2,0,2,1,1,0};
        dutchflag(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    static void dutchflag(int a[]){
        int n = a.length;
        int low=0, mid=0, high=n-1;
        while(mid <= high){
            if(a[mid] == 0){
                swap(a, mid, low);
                mid++;
                low++;
            }
            else if(a[mid] == 1){
                mid++;
            }
            else{
                swap(a, mid, high);
                high--;
            }
        }
    }
    static void swap(int a[], int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
