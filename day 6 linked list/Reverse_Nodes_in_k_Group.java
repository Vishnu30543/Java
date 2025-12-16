class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        // Build a small linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1,
        new ListNode(2,
        new ListNode(3,
        new ListNode(4))));

        Solution sol = new Solution();
        ListNode reversed = sol.reverseList(head, 3);

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
    public ListNode reverseList(ListNode head, int k){
        if(head == null || head.next == null || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGrpEnd = dummy;
        ListNode grpSt = head;
        while (true) {
            ListNode kth = findkth(grpSt,k);
            if(kth == null)
                break;

            ListNode nxtGrpSt = kth.next;
            kth.next = null;
            ListNode revHead = reverse(grpSt);

            prevGrpEnd.next = revHead;

            grpSt.next = nxtGrpSt;

            prevGrpEnd = grpSt;
            grpSt = nxtGrpSt;
        }
        return dummy.next;
    }
    static ListNode findkth(ListNode h, int k){
        ListNode t = h;
        while (t != null && k > 1) {
            t = t.next;
            k--;
        }
        return t;
    }
    static ListNode reverse(ListNode h){
        ListNode prev = null, curr = h, nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}