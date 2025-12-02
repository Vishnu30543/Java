import java.util.*;

public class Longest_Substring_without_repeat {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(find(s));
    }
    static int find(String s){
        int n = s.length();
        int left = 0, right = 0;
        int cnt = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (right < n) {
            if(mp.containsKey(s.charAt(right))){
                left = Math.max(mp.get(s.charAt(right)) + 1, left);
            }
            mp.put(s.charAt(right), right);
            cnt = Math.max(cnt, right-left+1);
            right++;
        }
        return cnt;
    }
}
