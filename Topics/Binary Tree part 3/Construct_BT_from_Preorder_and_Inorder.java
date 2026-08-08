import java.util.*;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int d){
        data = d;
    }
}

class Solution{
    TreeNode construct(int in[], int pre[]){
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<in.length; i++){
            mp.put(in[i], i);
        }
        return buildTree(mp, in, 0, in.length-1, pre, 0, pre.length-1);
    }

    TreeNode buildTree(Map<Integer, Integer> mp, int in[], int instart, int inend, int pre[], int prestart, int preend){
        if(instart > inend || prestart > preend)
            return null;

        TreeNode root = new TreeNode(pre[prestart]);
        int inIndex = mp.get(root.data);
        int leftElements = inIndex - instart;

        root.left = buildTree(mp, in, instart, inIndex-1, pre, prestart+1, prestart+leftElements-1);
        root.right = buildTree(mp, in, inIndex+1, inend, pre, prestart + leftElements + 1, preend);

        return root;
    }
}

public class Construct_BT_from_Preorder_and_Inorder {
    public static void main(String[] args) {

        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] preorder = {10, 20, 40, 50, 30, 60};

        Solution sol = new Solution();
        TreeNode root = sol.construct(inorder, preorder);

    }
}