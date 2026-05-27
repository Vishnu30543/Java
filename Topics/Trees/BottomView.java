import java.util.*;

class Bst{              // TC : SC : O(n)
    int data;
    Bst right, left;
    int line;

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
    static List<Integer> bottomView(Bst root){
        List<Integer> res = new ArrayList<Integer>();

        if(root == null) return res;

        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Bst> q = new LinkedList<>();

        root.line = 0;
        q.add(root);

        while (!q.isEmpty()) {
            Bst temp = q.remove();
            int line = temp.line;
            mp.put(line, temp.data);

            if(temp.left != null){
                temp.left.line = line-1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.line = line+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}

public class BottomView {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(i, root);
        }
        System.out.println("Bottom View of the BST:");
        System.out.println(Bst.bottomView(root));
    }
}
