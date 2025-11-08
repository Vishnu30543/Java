public class Majority_element_n_by_2_Optimized {    // Moore Voting Algorithm
    public static void main(String[] args) {
        int a[] = {2,2,1,1,1,2,2};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        int ele = 0, count = 0;
        for(int i=0; i<n; i++){
            if(count == 0){
                ele = a[i];
                count = 1;
            }
            else if(ele != a[i])
                count--;
            else
                count++;
        }
         // Step 2: Verify candidate
        count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == ele)
                count++;
        }

        if (count > n / 2)
            return ele;   // majority element confirmed
        else
            return -1;    // no majority element

    }
}
