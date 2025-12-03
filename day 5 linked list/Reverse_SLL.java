class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Reverse_SLL {
    public static void main(String[] args) {
        // Build a small linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1,
        new ListNode(2,
        new ListNode(3,
        new ListNode(4))));

        Solution sol = new Solution();
        ListNode reversed = sol.reverseList(head);

        // Print reversed list
        printList(reversed);
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
    public ListNode reverseList(ListNode head){
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = head.next;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}