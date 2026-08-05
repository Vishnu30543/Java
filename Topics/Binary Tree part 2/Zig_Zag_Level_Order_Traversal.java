import java.util.*;

class Tree{
    int data;
    Tree left, right;

    Tree(int d){
        data = d;
    }
}

class Solution{
    ArrayList<ArrayList<Integer>> zigzag(Tree r){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(r == null) return res;

        Queue<Tree> q = new LinkedList<>();
        q.offer(r);

        boolean lefttoright = false;
        while (! q.isEmpty()) {
            int size = q.size();
            Deque<Integer> dq = new ArrayDeque<>();
            
            for(int i=0; i<size; i++){
                Tree node = q.poll();

                if(lefttoright)
                    dq.addFirst(node.data);
                else
                    dq.add(node.data);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            lefttoright = !lefttoright;
            res.add(new ArrayList<>(dq));
        }
        return res;
    }
}

public class Zig_Zag_Level_Order_Traversal {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(9);
        root.right = new Tree(20);

        root.right.left = new Tree(15);
        root.right.right = new Tree(7);

        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> l = s.zigzag(root);

        // for(ArrayList<Integer> i : l)
        //     for(int j : i)
        //         System.out.println(j+" ");

        for (ArrayList<Integer> level : l) {
            System.out.println(level);
        }
    }
}
