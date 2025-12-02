import java.util.Arrays;

public class Majority_element_n_by_3_Optimized {    // Boyer–Moore Majority Vote (extended for n/3) algorithm
    public static void main(String[] args) {
        int a[] = {2,2,1,1,1,2,2};
        System.out.println(Arrays.toString(find(a)));
    }
    static int[] find(int a[]){
        int n = a.length;
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MAX_VALUE; 
        for (int i = 0; i < n; i++){
            if(cnt1 == 0 && ele2 != a[i]){
                cnt1 = 1;
                ele1 = a[i];
            }
            else if(cnt2 == 0 && ele1 != a[i]){
                cnt2 = 1;
                ele2 = a[i];
            }
            else if(cnt1 != 0 && ele1 == a[i]) cnt1++; 
            else if(cnt2 != 0 && ele2 == a[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        // Verify if count < n/3 or not
        cnt1 = 0; cnt2 = 0;
        for(int i=0; i<n; i++){
            if(a[i] == ele1) cnt1++;
            else if(a[i] == ele2) cnt2++;
        }

        int res[] = new int[2];
        int j=0;

        if(cnt1 > n/3) res[j++] = ele1;
        if(cnt2 > n/3) res[j++] = ele2;
        Arrays.sort(res);
        Arrays.copyOf(res, j);
        return res;
    }
}
