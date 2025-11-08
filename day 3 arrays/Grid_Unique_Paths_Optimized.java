public class Grid_Unique_Paths_Optimized {
     public static void main(String[] args) {
        int m=3, n=7;
        System.out.println(find(m,n));
    }
    static int find(int m, int n){
        // ncr  m+n-2 C m-1   (or)  m+n-2 C n-1
        int i = m+n-2;
        int j = m-1;
        return ncr(i,j);
    }
    static int ncr(int n, int r){
        long res = 1;
        for(int i=0; i<r; i++){
            res *= (n-i);
            res /= (i+1);
        }
        return (int)res;
    }
}
