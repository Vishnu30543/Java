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
    // Simple trick:

    // Traverse in modified preorder:

    // Root → Right → Left
    // Reverse the result.

    static List<Integer> postOrder(Bst root){
        List<Integer> res = new ArrayList<>();

        Bst cur = root;
        while(cur != null){
            if(cur.right == null){
                res.add(cur.data);
                cur = cur.left;
            }
            else{
                Bst temp = cur.right;
                while (temp.left != null && temp.left != cur) {
                    temp = temp.left;
                }

                if(temp.left == null){
                    res.add(cur.data);
                    temp.left = cur;
                    cur = cur.right;
                }
                else{
                    temp.left = null;
                    cur = cur.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}

public class Morris_Postorder {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(i, root);
        }
        System.out.println("Preorder traversal of the BST:");
        System.out.println(Bst.postOrder(root));
    }
}
