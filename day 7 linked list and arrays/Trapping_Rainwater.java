public class Trapping_Rainwater {
    public static void main(String[] args) {
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(findwater(a));
    }
    static int findwater(int a[]){
        int n = a.length;
        int lmax = a[0], rmax = a[n-1];
        int l = 0, r = n-1;
        int store = 0;
        while(l < r){
            lmax = Math.max(lmax, a[l]);
            rmax = Math.max(rmax, a[r]);

            if(lmax < rmax){
                store += (lmax - a[l]);
                l++;
            }
            else{
                store += (rmax - a[r]);
                r--;;
            }
        }
        return store;
    }
}
