class ListNode {    // O(1) SC
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Merge_2_sorted_SLL_optimized {
    public static void main(String[] args) {
        // Build a small linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode l1 = new ListNode(1,
        new ListNode(2,
        new ListNode(4
    )));
    ListNode l2 = new ListNode(1,
        new ListNode(3,
        new ListNode(4
        // new ListNode(5)
    )));

        Solution sol = new Solution();
        ListNode head = sol.merge(l1, l2);
        printList(head);
    }
    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }
        else{
            head = l2;
            l2 = l2.next;
        }

        ListNode t = head;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                t.next = l1;
                l1 = l1.next;
            }
            else{
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        if(l1 != null) t.next = l1;
        else t.next = l2;
        return head;
    }
}