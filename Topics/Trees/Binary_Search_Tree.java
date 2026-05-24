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

    static Bst delete(Bst node, int val){
        if(node == null)
            return null;
        
        if(val < node.data){
            node.left = delete(node.left, val);
        }
        else if(val > node.data){
            node.right = delete(node.right, val);
        }
        else{
            if(node.left == null && node.right == null){
                node = null;
            }
            else if(node.left == null){
                node = node.right;
            }
            else if(node.right == null){
                node = node.left;
            }
            else{
                Bst temp = findMin(node.right);
                // findMin(node.right) will return the minimum value in the right subtree of the node to be deleted. This minimum value is the smallest value that is greater than the node's value, and it will be used to replace the node's value in order to maintain the properties of the binary search tree after deletion.
                // findMin(node.left) will return the minimum value in the left subtree of the node to be deleted. This minimum value is the smallest value that is less than the node's value, and it can also be used to replace the node's value in order to maintain the properties of the binary search tree after deletion.
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }
        return node;
    }
    static Bst findMin(Bst node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    // static Bst findMax(Bst node){
    //     while(node.right != null){
    //         node = node.right;
    //     }
    //     return node;
    // }
    static void inorder(Bst node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}

public class Binary_Search_Tree {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(root, i);
        }

        System.out.println("Inorder traversal of the BST:");
        Bst.inorder(root);
        root = Bst.delete(root, 3);
        System.out.println();
        System.out.println("Inorder traversal after deletion:");
        Bst.inorder(root);
    }
}
