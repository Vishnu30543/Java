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
        if(root == null || root.data == val)
            return root;
        if(root.data < val)
            return search(root.right, val);
        else
            return search(root.left, val);
    }
}

public class Search_in_BST {
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
