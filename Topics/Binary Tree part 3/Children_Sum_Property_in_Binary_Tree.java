class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int d){
        data = d;
    }
}

class Solution{
    void changeTree(TreeNode root){
        if(root == null) return;

        int cur = 0;
        if(root.left != null) 
            cur += root.left.data;
        if(root.right != null)
            cur += root.right.data;

        if(cur >= root.data)
            root.data = cur;
        else{
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total += root.right.data;
        if(root.left != null || root.right != null) root.data = total;
    }
}

public class Children_Sum_Property_in_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution sol = new Solution();

        // Print the inorder traversal
        // of tree before modification
        System.out.print("Binary Tree before modification: ");
        TreeTraversal.inorderTraversal(root);
        System.out.println();

        sol.changeTree(root);

        System.out.print("Binary Tree after Children Sum Property: ");
        TreeTraversal.inorderTraversal(root);
        System.out.println();
    }
}

class TreeTraversal {
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
}