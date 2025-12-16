class ListNode {    // TC : O(n) SC : O(1)
    int val;
    ListNode next;
    ListNode bottom;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.bottom = null;
    }
}

public class Flatten_SLL{

    public static void main(String[] args) {

        // ===== Build Multilevel Linked List =====
        // Example structure:
        // 5 -> 10 -> 19 -> 28
        // |    |     |     |
        // 7    20    22    35
        // |          |     |
        // 8          50    40
        // |                |
        // 30               45

        ListNode head = new ListNode(5);
        head.bottom = new ListNode(7);
        head.bottom.bottom = new ListNode(8);
        head.bottom.bottom.bottom = new ListNode(30);

        head.next = new ListNode(10);
        head.next.bottom = new ListNode(20);

        head.next.next = new ListNode(19);
        head.next.next.bottom = new ListNode(22);
        head.next.next.bottom.bottom = new ListNode(50);

        head.next.next.next = new ListNode(28);
        head.next.next.next.bottom = new ListNode(35);
        head.next.next.next.bottom.bottom = new ListNode(40);
        head.next.next.next.bottom.bottom.bottom = new ListNode(45);

        ListNode flatHead = flatten(head);

        printList(flatHead);
    }

    // ===== WRITE YOUR CORE LOGIC HERE =====
    static ListNode flatten(ListNode head) {

        // Step 1: handle edge cases
        // Step 2: recursively flatten right side
        // Step 3: merge two sorted lists (bottom pointers)

        if(head == null || head.next == null) return head;

        head.next = flatten(head.next);
        head = merge2SLL(head, head.next);

        return head;
    }

    static ListNode merge2SLL(ListNode a, ListNode b) {

        // merge using bottom pointer only
        ListNode t = new ListNode(-1);
        ListNode res = t;
        while (a!= null && b != null) {
            if(a.val < b.val){
                t.bottom = a;
                t = t.bottom;
                a = a.bottom;
            }
            else{
                t.bottom = b;
                t = t.bottom;
                b = b.bottom;
            }
            // t.next = null;
        }
        if(a != null) t.bottom = a;
        else t.bottom = b;

        return res.bottom;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.bottom;
        }
    }
}
