class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int d){
        data = d;
    }
}

class Solution{
    boolean check(TreeNode root){
        if(root == null) return true;

        return isSymmertic(root.left, root.right);
    }

    boolean isSymmertic(TreeNode r1, TreeNode r2){
        if(r1 == null || r2 == null)
            return r1 == r2;

        if(r1.data != r2.data) return false;

        return isSymmertic(r1.left, r2.right) && isSymmertic(r1.right, r2.left);
    }
}

public class Symmetric_Tree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution sol = new Solution();
        System.out.println(sol.check(root));
    }

}
