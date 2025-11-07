import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int a[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        int v[][] = mergeIntervals(a);
        // for (int i = 0; i < v.length; i++) { 
        //     for (int j = 0; j < v[i].length; j++) {
        //         System.out.print(v[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(Arrays.deepToString(v));
    }
    static int[][] mergeIntervals(int a[][]){
        List<int[]> l = new ArrayList<>();
        for(int i[] : a){
            if(l.isEmpty() || i[0] > l.get(l.size()-1)[1])
                l.add(i);
            else
                l.get(l.size()-1)[1] = Math.max(l.get(l.size()-1)[1], i[1]);
        }
        return l.toArray(new int[0][]);
    }
}
