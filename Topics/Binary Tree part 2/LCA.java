import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution{
    TreeNode lca(TreeNode r, int p, int q){
        if(r == null || r.val == p  || r.val == q)
            return r;

        TreeNode left = lca(r.left, p, q);
        TreeNode right = lca(r.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        // If both sides of a node returns true/root
        return r;
    }
}

public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
            3,
            new TreeNode(
                5,
                new TreeNode(6),
                new TreeNode(
                    2,
                    new TreeNode(7),
                    new TreeNode(4)
                )
            ),
            new TreeNode(
                1,
                new TreeNode(0),
                new TreeNode(8)
            )
        );

        Solution sol = new Solution();
        System.out.println(sol.lca(root, 5, 1).val);
    }
}
