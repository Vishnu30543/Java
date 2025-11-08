public class Pow_x_n {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.printf("%.5f",pow(x,n));
    }
    static double pow(double x, int n){
        // long nn = Math.abs(n);               // to handle 2^-5 etc..
        long nn = n;
        if(nn < 0) nn = nn*-1;
        double ans = 1.0;
        while(nn > 0){
            // even power -> 2^10  =  (2*2)^5;
            if(nn%2 == 0){
                x = x*x;
                nn /= 2;
            }
            // odd power -> 2^9  =  (2 * )
            else{
                ans = ans*x;
                nn -= 1;
            }
        }
        if(n<0) ans = 1.0/ans;
        return ans;
    }
}
