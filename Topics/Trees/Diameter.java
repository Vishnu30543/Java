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

    static int height(Bst root, int d[]){
        if(root == null) return 0;

        int l = height(root.left, d);
        int r = height(root.right, d);
        d[0] = Math.max(d[0], l+r);

        return Math.max(l,r)+1;
    }

    static int diameter(Bst a){
        int d[] = new int[1];
        height(a, d);
        return d[0];        // Bee Carefull
    }
}

public class Diameter {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(root, i);
        }
        System.out.println(Bst.diameter(root));

    }
}
