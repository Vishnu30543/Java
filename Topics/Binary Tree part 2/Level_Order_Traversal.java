import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left, right;

    Node(int d){
        val = d;
    }
}

class Solution{
    ArrayList<ArrayList<Integer>> level(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
        if (root == null) return ans;
    
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
    
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
    
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.val);
    
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
    
            ans.add(level);
        }
    
        return ans;
    }
}

public class Level_Order_Traversal {
    public static void main(String[] args) {
        // Depth Tree image example..
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> ans = s.level(root);

        for(ArrayList<Integer> l : ans)
            System.out.println(l);
    }
}
