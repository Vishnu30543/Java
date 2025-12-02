public class length_of_maxSubarray_withSum_equals_k {
    public static void main(String[] args) {
        int a[] = {1,2,3,1,1,1,1,3,3};
        int k = 7;
        System.out.println(count(a,k));
    }
    static int count(int a[], int k){
        int n = a.length;
        int maxlen = 0;
        int sum = 0;
        int left=0, right=0;
        while(right < n){
            while(left <= right || sum > k){
                sum -= a[left];
                left++;
            }
            if(sum == k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            sum += a[right];
            right++;
        }
        return maxlen;
    }
}
