import java.util.*;

class Tree{
    int data;
    Tree left, right;

    Tree(int d){
        data = d;
    }
}

class Solution{
    boolean check(Tree r1, Tree r2){
        if(r1 == null && r2 == null)
            return true;
        if(r1 == null || r2 == null)
            return false;

        return (r1.data == r2.data) && check(r1.left, r2.left) && check(r1.right, r2.right);
    }
}

public class Indentical_Trees {
    public static void main(String[] args) {
        Tree root1 = new Tree(1);
        root1.right = new Tree(3);
        root1.left = new Tree(2);

        Tree root2 = new Tree(1);
        root2.right = new Tree(3);
        root2.left = new Tree(2);

        Solution s = new Solution();
        boolean b = s.check(root1, root2);

        if(b) System.out.println("Trees are Identical");
        else System.out.println("Trees are not same");
    }
}
