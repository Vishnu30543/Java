public class Max_Subarray {                 // Kadane's Algorithm
    public static void main(String[] args) {
        int a[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            max = Math.max(max, sum);
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}
