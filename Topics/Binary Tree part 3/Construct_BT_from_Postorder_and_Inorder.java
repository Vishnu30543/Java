import java.util.*;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int d){
        data = d;
    }
}

class Solution{
    TreeNode construct(int in[], int post[]){
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<in.length; i++){
            mp.put(in[i], i);
        }
        return buildTree(mp, in, 0, in.length-1, post, 0, post.length-1);
    }

    TreeNode buildTree(Map<Integer, Integer> mp, int in[], int instart, int inend, int post[], int poststart, int postend){
        
        if(instart > inend || poststart > postend) return null;

        TreeNode root = new TreeNode(post[postend]);
        int inIndex = mp.get(root.data);
        int leftElements = inIndex - instart;

        root.left = buildTree(mp, in, instart, inIndex-1, post, poststart, poststart+leftElements-1);
        root.right = buildTree(mp, in, inIndex+1, inend, post, poststart+leftElements, postend-1);

        return root;
    }
}

public class Construct_BT_from_Postorder_and_Inorder {
    public static void main(String[] args) {

        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};

        Solution sol = new Solution();
        TreeNode root = sol.construct(inorder, postorder);

    }
}
