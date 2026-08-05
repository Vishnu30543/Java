import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left, right;

    Node(int d){
        val = d;
    }
}
// Without Recusion
class Solution{
    int maxDepth(Node r){
        if(r == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(r);

        int level = 0;

        while (! q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++){
                Node node = q.poll();

                if(node.left != null) q.offer(node.left);

                if(node.right != null) q.offer(node.right);
            }
            level++;
        }
        return level;
    }
}

public class Depth_Height_of_Tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        Solution solution = new Solution();
        int depth = solution.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
