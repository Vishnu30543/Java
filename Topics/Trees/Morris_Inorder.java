import java.util.*;

class Bst{
    int data;
    Bst left, right;

    Bst(int d){
        data = d;
        left = right = null;
    }

    static Bst insert(Bst node, int val){
        if(node == null){
            node = new Bst(val);
            return node;
        }

        if(val <= node.data){
            node.left = insert(node.left, val);
        }
        else
            node.right = insert(node.right, val);
        
        return node;
    }
    static List<Integer> inorder(Bst root){
        List<Integer> res = new ArrayList<>();

        Bst cur = root;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.data);
                cur = cur.right;
            }
            else{
                // Find the Predecesor of the left sub tree
                // And attach the cur node to it's right
                Bst temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }
                else{
                    temp.right = null;
                    res.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

public class Morris_Inorder {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(root, i);
        }

        System.out.println("Inorder traversal of the BST:");
        System.out.println(Bst.inorder(root));
    }
}