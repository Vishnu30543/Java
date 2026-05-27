import java.util.*;

class Bst{              // TC : SC : O(n)
    int data;
    Bst right, left;

    Bst(int d){
        data = d;
        right = left = null;
    }

    static Bst insert(int d, Bst root){
        if(root == null)
            return new Bst(d);
        else if(d < root.data)
            root.left = insert(d, root.left);
        else
            root.right = insert(d, root.right);

        return root;
    }
    static List<Integer> rightView(Bst root){
        List<Integer> res = new ArrayList<Integer>();

        helper(res, root, 0);
        return res;
    }
    static void helper(List<Integer> res, Bst root, int depth){
        if(root == null)
            return;

        if(depth == res.size()){
            res.add(root.data);
        }
        helper(res, root.right, depth+1);
        helper(res, root.left, depth+1);
        // Just Reverse the above to get Left view
    }
}

public class RightView {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(i, root);
        }
        System.out.println("Right View of the BST:");
        System.out.println(Bst.rightView(root));
    }
}
