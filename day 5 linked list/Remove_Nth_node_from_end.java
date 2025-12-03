class ListNode {    // O(n) TC
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Remove_Nth_node_from_end {
    public static void main(String[] args) {
        // Build a small linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode l1 = new ListNode(1,
        new ListNode(2,
        new ListNode(3,
        new ListNode(4,
        new ListNode(5
    )))));

        Solution sol = new Solution();
        ListNode head = sol.remove(l1, 2);
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
    public ListNode remove(ListNode head, int n){
        ListNode slow = head, fast = head;
        for(int i=0; i<n; i++)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}