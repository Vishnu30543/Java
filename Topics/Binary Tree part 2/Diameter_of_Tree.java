import java.util.*;

class Tree{
    int data;
    Tree left, right;

    Tree(int d){
        data = d;
    }
}

class Solution{

    int height(Tree r, int v[]){
        if(r == null) return 0;

        int left = height(r.left, v);
        int right = height(r.right, v);

        v[0] = Math.max(v[0], left + right);

        return Math.max(left, right) + 1;
    }

    int diameter(Tree r){
        int v[] = new int[1];
        height(r, v);
        return v[0];
    }

    public int maxDepth(Node root) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxDepth'");
    }
}

public class Diameter_of_Tree {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(9);
        root.right = new Tree(20);

        root.right.left = new Tree(15);
        root.right.right = new Tree(7);

        Solution s = new Solution();
        System.out.println(s.diameter(root));
    }
}
