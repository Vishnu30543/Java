import java.util.*;

class Tree{
    int data;
    Tree left, right;

    Tree(int d){
        data = d;
        left = right = null;
    }
}

class Solution{

    public ArrayList<Integer> boundaryTraversal(Tree root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;

        if(! isLeaf(root)) res.add(root.data);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    static boolean isLeaf(Tree r){
        return r.left == null && r.right == null;
    }

    void addLeftBoundary(Tree r, ArrayList<Integer> res){
        Tree node = r.left;
        while(node != null){
            if(! isLeaf(node)){
                res.add(node.data);
            }
            if(node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }
    void addRightBoundary(Tree r, ArrayList<Integer> res){
        Deque<Integer> dq = new ArrayDeque<>();
        Tree node = r.right;
        while(node != null){
            if(! isLeaf(node))
                dq.addFirst(node.data);

            if(node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        res.addAll(new ArrayList<>(dq));
    }
    void addLeaves(Tree node, ArrayList<Integer> res){
        if(isLeaf(node))
            res.add(node.data);

        if(node.left != null)
            addLeaves(node.left, res);
        if(node.right != null)
            addLeaves(node.right, res);
    }
}

public class Boundary_Traversal{
    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        root.left.right.left = new Tree(8);
        root.left.right.right = new Tree(9);

        Solution obj = new Solution();

        ArrayList<Integer> ans = obj.boundaryTraversal(root);

        for (int x : ans)
            System.out.print(x + " ");
    }
}