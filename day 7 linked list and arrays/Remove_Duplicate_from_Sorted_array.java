public class Remove_Duplicate_from_Sorted_array {
    public static void main(String[] args) {
        int a[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        int i = 0;
        for(int j=1; j<n; j++){
            if(a[j] != a[i]){
                i++;
                a[i] = a[j];
            }
        }
        return i+1;
    }
}
