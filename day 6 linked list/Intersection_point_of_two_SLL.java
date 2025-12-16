import java.util.*; // SC O(n)  TC : O(n+m)

class ListNode {    
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Intersection_point_of_two_SLL {
    public static void main(String[] args) {
        ListNode common = new ListNode(2, new ListNode(4));

        ListNode l1 = new ListNode(1,
            new ListNode(9,
            new ListNode(1,
            common)));

        ListNode l2 = new ListNode(3, common);


        Solution sol = new Solution();
        ListNode head = sol.find(l1, l2);
        System.out.print(head.val);
    }
}

class Solution {
    public ListNode find(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return null;
        Set<ListNode> set = new HashSet<>();
        while(l1 != null){
            set.add(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            if(set.contains(l2))
                return l2;
            l2 = l2.next;
        }
        return null;
    }
}