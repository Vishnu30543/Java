public class Max_consecutive_ones {
    public static void main(String[] args) {
        int a[] = {1,1,0,1,1,1};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        int cnt = 0, max = 0;
        for(int i=0; i<n; i++){
            if(a[i] == 1){
                cnt++;
                max = Math.max(max, cnt);
            }
            else
                cnt = 0;
        }
        return max;
    }
}
