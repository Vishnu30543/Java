class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RotateSLL {

    public static void main(String[] args) {

        // ===== Build Linked List =====
        // Example: 1 → 2 → 3 → 4 → 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode newHead = rotateRight(head, k);

        printList(newHead);
    }

    // ===== WRITE YOUR CORE LOGIC HERE =====
    static ListNode rotateRight(ListNode head, int k) {

        // Step 1: handle edge cases
        // Step 2: find length of list
        // Step 3: reduce k using modulo
        // Step 4: find new tail (len - k - 1)
        // Step 5: rotate links

        if(head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode t = head;
        while(t.next != null){
            t = t.next;
            len++;
        }
        t.next = head;
        k = k % len;
        if (k == 0) return head;
        int gotill = len - k - 1;

        t = head;
        while (gotill -- > 0) {
            t = t.next;
        }
        head = t.next;
        t.next = null;

        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
