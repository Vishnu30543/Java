public class Next_Permutation {
    /*
     * 1) Find a[i] < a[i+1]
     * 2) Find Greater than that index but Smaller one to stay close
     * 3) Sort the array after the index
     */

    static void reverse(int a[], int s, int e){
        for(int i=s; i<(e-s)/2; i++){
            int t = a[i];
            a[i] = a[e-i];
            a[e-i] = t;
        }
    }
    public static void main(String[] args) {
        int a[] = {3,2,1};
        find(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        } 
    }
    static void find(int a[]){
        int ind = -1;
        int n = a.length;
        for(int i=n-2; i>=0; i--){
            if(a[i] < a[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            // Next permutation will be the initial one [smallest number]
            // for (int i = 0; i < n/2; i++) {
            //     int t = a[i];
            //     a[i] = a[n-i-1];
            //     a[n-i-1] = t;
            // }
            reverse(a, 0, n-1);
        }
        else{
            System.out.println("ind "+ind);
            for (int i=n-1; i>ind; i--) {
                if(a[i] > a[ind]){
                    // Swap them
                    int t = a[i];
                    a[i] = a[ind];
                    a[ind] = t;
                    break;
                }
            }
            // Sort the remaining to keep the number small [Just Reverse]
            // for(int i=ind+1; i<n/2; i++){
            //     int t = a[i];
            //     a[i] = a[n-i-1];
            //     a[n-i-1] = t;
            // }
            reverse(a, ind+1, n);
        }
    }
}
