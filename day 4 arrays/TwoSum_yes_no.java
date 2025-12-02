import java.util.Arrays;

public class TwoSum_yes_no {            // O(n) + O(nlogn) (sorting)    Sc: O(1)
    public static void main(String[] args) {
        int a[] = {2,7,11,15};
        int target = 9;
        System.out.println(find(a,target));
    }
    static boolean find(int a[], int target){
        Arrays.sort(a);
        int n = a.length;
        int left = 0, right = n-1;
        while(left < right){
            if(a[left] + a[right] == target) return true;
            else if(a[left] + a[right] > target)
                right--;
            else
                left++;
        }
        return false;
    }
}
