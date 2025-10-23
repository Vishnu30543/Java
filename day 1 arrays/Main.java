import java.util.*;

public class Main{
    static int help(String s, String t){
        int n = s.length(), m = t.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }
    
    public static void main(String[] x){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(n);
        String st = "babgbag";
        String t = "bag";
        System.out.println(help(st,t));

        
    }
    
}