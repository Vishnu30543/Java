import java.util.*;

// In Binary Tree.
// TC : O(n)  SC : O(H)

class Bst{
    int val;
    Bst right, left;

    Bst(int v){
        val = v;
        right = left = null;
    }

    static Bst insert(Bst root, int d){
        if(root == null)
            return new Bst(d);

        else if(root.val > d)
            root.left = insert(root.left, d);
        else
            root.right = insert(root.right, d);

        return root;
    }
    static boolean root_to_Node_Path(Bst root, List<Integer> l, int target){
        if(root == null){
            return false;
        }
        l.add(root.val);
        if(root.val == target)
            return true;
        if(root_to_Node_Path(root.right, l, target) == true || root_to_Node_Path(root.left, l, target) == true)
            return true;

        l.remove(l.size()-1);
        return false;
    }
}

public class Root_to_Node_Path {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(root, i);
        }
        List<Integer> l = new ArrayList<>();
        if(Bst.root_to_Node_Path(root, l, 5))
            System.out.println(l);
        else
            System.out.println("NO path");
    }
}
