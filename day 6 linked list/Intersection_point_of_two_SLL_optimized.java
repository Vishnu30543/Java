class ListNode {    // SC O(1)  TC : O(n+m)
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Intersection_point_of_two_SLL_optimized {
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
        
        ListNode t1 = l1;
        ListNode t2 = l2;

        while(l1 != l2){
            l1 = (l1 == null)? t2 : l1.next;
            l2 = (l2 == null)? t1 : l2.next;
        }
        return l1;
    }
}