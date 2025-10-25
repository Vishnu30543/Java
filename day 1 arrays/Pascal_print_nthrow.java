public class Pascal_print_nthrow {

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
    static void print(int n){
        System.out.print(1+" ");
        int res = 1;
        for(int i=1; i<n; i++){
            res *= (n-i);
            res /= i;
            System.out.print(res+" ");
        }
    }
}