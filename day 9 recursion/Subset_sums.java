import java.util.ArrayList;
import java.util.Collections;

public class Subset_sums {

    static void find(int sum, int ind, int a[], int n, ArrayList<Integer> l){
        if(ind == n){
            l.add(sum);
            return;
        }
        find(sum + a[ind], ind + 1, a, n, l);
        find(sum, ind + 1, a, n, l);
    }
    public static void main(String[] args) {
        int a[] = {1, 2, 7, 3};
        ArrayList<Integer> l = new ArrayList<>();
        find(0,0, a, a.length, l);
        Collections.sort(l);
        System.out.println(l);
    }

}
