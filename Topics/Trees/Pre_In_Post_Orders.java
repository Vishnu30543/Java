import java.util.*;

class Bst{              // TC : SC : O(n)
    int data;
    Bst right, left;
    int num;

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
    static List<List<Integer>> allOrders(Bst root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();


        if(root == null) return res;

        Stack<Bst> st = new Stack<>();
        root.num=1;
        st.add(root);

        while(!st.isEmpty()){
            Bst temp = st.pop();
            int num = temp.num;

            if(num == 1){
                pre.add(temp.data);
                temp.num ++;
                st.push(temp);

                if(temp.left != null){
                    temp.left.num = 1;
                    st.push(temp.left);
                }
            }
            else if(num == 2){
                in.add(temp.data);
                temp.num++;
                st.push(temp);

                if(temp.right != null){
                    temp.right.num = 1;
                    st.push(temp.right);
                }
            }
            else
                post.add(temp.data);
        }
        res.add(pre);
        res.add(in);
        res.add(post);
        // res.addAll(Arrays.asList(pre, in, post));

        return res;
    }
}

public class Pre_In_Post_Orders {
    public static void main(String[] args) {
        Bst root = null;
        int a[] = {7,8,1,3,2,5,10,4};
        for(int i: a){
            root = Bst.insert(i, root);
        }
        List<List<Integer>> ans = Bst.allOrders(root);
        System.out.println("All Orders of the BST:");

        String[] names = {"Preorder", "Inorder", "Postorder"};

        for(int i = 0; i < ans.size(); i++){
            System.out.println(names[i] + " : " + ans.get(i));
        }
    }
}
