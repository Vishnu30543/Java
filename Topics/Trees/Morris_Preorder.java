import java.util.*;

class Bst{
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

    static List<Integer> preOrder(Bst root){
        List<Integer> res = new ArrayList<>();

        Bst cur = root;
        while (cur != null) {
            if(cur.left == null){
                res.add(cur.data);
                cur = cur.right;
            }
            else{
                Bst temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }

                if(temp.right == null){
                    res.add(cur.data);
                    temp.right = cur;
                    cur = cur.left;
                }
                else{
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

public class Morris_Preorder {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(i, root);
        }
        System.out.println("Preorder traversal of the BST:");
        System.out.println(Bst.preOrder(root));
    }
}
