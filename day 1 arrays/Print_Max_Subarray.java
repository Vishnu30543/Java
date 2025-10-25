public class Print_Max_Subarray {           // Kadane's Algorithm
    public static void main(String[] args) {
        // int a[] = {-2,1,-3,4,-1,2,1,-5,4};
        int a[] = {5,4,-1,7,8};
        int res[] = find(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
    static int[] find(int a[]){
        int n = a.length;
        int sum = 0, max = Integer.MIN_VALUE, start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if(sum == 0) start = i;
            sum += a[i];
            if(sum > max){
                max = sum;
                end = i;
            }
            if(sum < 0){
                sum = 0;
                start = i;
            }
        }
        int res[] = new int[end-start+1];
        for(int i=start,j=0; i<=end; i++){
            res[j++] = a[i];
        }
        System.out.println("\nMax Sum: " + max);
        return res;
    }
}
