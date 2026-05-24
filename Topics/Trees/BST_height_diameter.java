class Bst{
    int val;
    Bst left, right;

    Bst(int d){
        val = d;
        left = right = null;
    }

    static Bst insert(Bst root, int d){
        if(root == null){
            root = new Bst(d);
            return root; 
        }
        if(root.val > d)
            root.left = insert(root.left, d);
        else
            root.right = insert(root.right, d);
        
        return root;
    }

    static int height(Bst root){
        if(root == null) return 0;

        int l = height(root.left);
        int r = height(root.right);

        return Math.max(l,r)+1;
    }

    static int diameter(Bst a, Bst b){
        return height(a) + height(b);
    }
}

public class BST_height_diameter {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(root, i);
        }
        System.out.println(Bst.height(root));

    }
}
