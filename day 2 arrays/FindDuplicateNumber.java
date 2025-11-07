public class FindDuplicateNumber {      // We manipulate the input array
    public static void main(String[] args) {
        int a[] = {1,3,4,2,2};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        for(int i=0; i<n; i++){
            int ind = Math.abs(a[i]);
            if(a[ind] < 0)
                return ind;
            a[ind] = -a[ind];
        }
        return -1;
    }
}
