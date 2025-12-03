class ListNode {    // return 1st middle
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Find_middle_SLL_1st_middle {
    public static void main(String[] args) {
        // Build a small linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1,
        new ListNode(2,
        new ListNode(3,
        new ListNode(4
        // new ListNode(5)
    ))));

        Solution sol = new Solution();
        ListNode mid = sol.find(head);
        System.out.println(mid.val);
    }
}

class Solution {
    public ListNode find(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}