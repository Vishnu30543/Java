public class Pascal_given_rowcol {          // n-1 C r-1
    public static void main(String[] x){
        int row = 5, col = 3;
        System.out.println(ncr(row-1, col-1));
        System.out.print(ncr_optimized(row-1, col-1));
    }

    static long ncr(int n, int r){
        int nume = 1, deno = 1;
        for(int i=0; i<r; i++){
            nume *= (n-i);
            deno *= (r-i);
        }
        return nume/deno;
    }

    static long ncr_optimized(int n, int r){
        int res = 1;
        for(int i=0; i<r; i++){
            res *= (n-i);
            res /= (i+1);
        }
        return res;
    }
}