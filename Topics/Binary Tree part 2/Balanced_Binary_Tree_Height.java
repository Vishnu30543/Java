import java.util.*;

class Tree{
    int data;
    Tree left, right;

    Tree(int d){
        data = d;
    }
}

class Solution{
    boolean check(Tree r){

        return dfs(r) != -1;
    }
    int dfs(Tree r){
        if(r == null) return 0;

        int left = dfs(r.left);
        int right = dfs(r.right);

        // Once it receives the trigger from any of the node, it returns the same
        if(left == -1 || right == -1) return -1;
        // Triggers first (down wala)
        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}

public class Balanced_Binary_Tree_Height {
    public static void main(String[] args) {
        Tree root1 = new Tree(3);
        root1.right = new Tree(20);
        root1.left = new Tree(9);

        root1.right.left = new Tree(15);
        root1.right.right = new Tree(7);

        Solution s = new Solution();
        boolean b = s.check(root1);

        if(b) System.out.println("Tree is Balanced");
        else System.out.println("Trees is not Balanced");
    }
}
