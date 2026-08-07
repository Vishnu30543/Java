class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int d){
        data = d;
    }
}

class Solution{
    void flatten(TreeNode root){
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode node = cur.left;

                while (node.right != null) {
                    node = node.right;
                }
                node.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}

public class Flatten_Tree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        // Example:
        Solution sol = new Solution();
        sol.flatten(root);
    }
}
