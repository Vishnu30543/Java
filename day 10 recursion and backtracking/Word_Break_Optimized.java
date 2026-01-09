import java.util.*;

public class Word_Break_Optimized {     // TC : O(maxLen)

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // Convert word list to a set for faster lookup
        // Initialize DP or memoization structure
        // Start iteration
        // Check all possible substrings
        // If matches, keep true in dp array
        
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        int maxLen = 0;
        for(String i : set) maxLen = Math.max(maxLen, i.length());

        for(int i=1; i<=s.length(); i++){

            for(int j=Math.max(0, i-maxLen); j<i; j++){

                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
                
            }
        }
        return dp[s.length()];
    }
}
