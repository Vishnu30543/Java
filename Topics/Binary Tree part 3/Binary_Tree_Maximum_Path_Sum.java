import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
    }
}

class Solution {

    int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;     // For -ve number nodes

        dfs(root, max);
        return max[0];
    }

    int dfs(TreeNode root, int max[]) {
        if(root == null) return 0;

        int left = dfs(root.left, max);
        int right = dfs(root.right, max);

        left = Math.max(0, left);
        right = Math.max(0, right);

        max[0] = Math.max(max[0], left+right+root.data);

        return Math.max(left, right) + root.data;
    }
}

public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
    
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
    
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    
        Solution sol = new Solution();
    
        System.out.println(sol.maxPathSum(root));
    }
}