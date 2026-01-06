import java.util.*;

public class Permutation_Sequence {

    static String getPermutation(int n, int k) {
        // Reduce k by 1 as it is 0-indexed 
        // create list of numbers from 1 to n
        // build answer using factorial grouping
        // return final permutation string

        k--;
        String ans = "";
        int fact = 1;
        List<Integer> num = new ArrayList<>();
        for(int i=1; i<=n; i++){
            num.add(i);
        }
        for(int i=1; i<n; i++){
            fact *= i;
        }
        while(true){
            int index = k/fact;
            ans += num.get(index);
            num.remove(index);

            if(num.size() == 0) break;

            k = k%fact;
            fact = fact/num.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 17));
    }
}
