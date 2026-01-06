import java.util.*;

public class Palindrome_Partitioning {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> result = partition(s);
        System.out.println(result);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int index, String s,
                                 List<String> path,
                                 List<List<String>> res) {

        // Step 1: If index reaches end of string,
        // add current partition to result and return
        // Step 2: Try all possible substrings starting from index
            // Step 3: Check if substring s[index..i] is palindrome
            // Step 4: If yes, add substring to path
            // Step 5: Recurse for remaining substring starting at i + 1
            // Step 6: Backtrack (remove last added substring)

        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                backtrack(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {

        // Step 1: Compare characters from both ends
        // Step 2: Move inward while characters match
        // Step 3: If mismatch found, return false
        // Step 4: If loop ends, return true

        for(int i=left,j=right; i<j; i++,j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
