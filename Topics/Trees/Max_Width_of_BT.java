import java.util.*;

// In Binary Tree.
// Require Pair

class Pair{
    Bst node;
    int num;
    Pair(Bst n, int data){
        node = n;
        num = data;
    }
}

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
    static int width(Bst root){
        if(root == null) return 0;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for(int i=0; i<size; i++){
                int cur_num = q.peek().num - min;
                Bst node = q.peek().node;
                q.poll();

                if(i==0) first = cur_num;
                if(i==size-1) last = cur_num;

                if(node.left != null)
                    q.offer(new Pair(node.left, cur_num*2 + 1));
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_num*2 + 2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}

public class Max_Width_of_BT
{
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(root, i);
        }
        System.out.println(Bst.width(root));
    }
}
