import java.util.*;

class TreeNode {    // TC: O(n), SC : O(n) : Height of Recursion [Auxiliary space]
    int data;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
    }
}

class Solution{
    TreeNode search(TreeNode root, int val){
        while (root != null) {
            if(root.data == val)
                return root;

            if(root.data < val)
                root = root.right;
            else
                root = root.left;
        }
        return null;
    }
}

public class Search_in_BST_Optimized {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
    
        Solution sol = new Solution();
        int val = 7;
    
        TreeNode result = sol.search(root, val);
    
        if (result != null)
            System.out.println(result.data);
        else
            System.out.println("Not Found");
    }
}
