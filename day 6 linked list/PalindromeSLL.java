class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeSLL {

    public static void main(String[] args) {

        // ===== Build Linked List Here =====
        // Example: 1 → 2 → 3 → 2 → 1

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        System.out.println(result);
    }

    static boolean isPalindrome(ListNode head) {

        // Step 1: handle edge cases
        // Step 2: find middle of linked list
        // Step 3: reverse second half
        // Step 4: compare both halves
        // Step 5 (optional): restore list
        if(head == null || head.next == null) return true;
        ListNode mid = findmid(head);
        ListNode revhead = reverse(mid.next);
        ListNode p1 = revhead, p2 = head;
        while (p1 != null) {
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    static ListNode findmid(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
