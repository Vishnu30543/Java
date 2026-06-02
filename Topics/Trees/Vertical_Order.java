import java.util.*;

class Bst{              // TC : O(nlogn) , SC : O(n)
    int data;
    Bst right, left;

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
    static List<List<Integer>> vertical(Bst root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        if(root == null) return new ArrayList<>();

        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.remove();
            Bst temp = t.node;
            int vertical = t.row;
            int level = t.col;

            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(temp.data);

            if(temp.left != null){
                q.offer(new Tuple(temp.left, vertical-1, level+1));
            }
            if(temp.right != null){
                q.offer(new Tuple(temp.right, vertical+1, level+1));
            }
        }
        List<List<Integer>> l = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> t1 : map.values()){
            l.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : t1.values()){
                while (!nodes.isEmpty()) {
                    l.get(l.size()-1).add(nodes.poll());
                }
            }
        }
        return l;
    }
}

class Tuple{
    Bst node;
    int row;
    int col;

    Tuple(Bst n, int r, int c){
        node = n;
        row = r;
        col = c;
    }
}
// (node.val, vertical position, horizontal position)
// Can also be done in other traversals also Pre, Post etc not only level-order.
public class Vertical_Order {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(i, root);
        }
        System.out.println("Vertical View of the BST:");
        System.out.println(Bst.vertical(root));
    }
}
