class ListNode {    
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Add_Two_Numbers {
    public static void main(String[] args) {
        // Build a small linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode l1 = new ListNode(2,
        new ListNode(4,
        new ListNode(3
    )));
    ListNode l2 = new ListNode(5,
        new ListNode(6,
        new ListNode(4
        // new ListNode(5)
    )));

        Solution sol = new Solution();
        ListNode head = sol.add(l1, l2);
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
    public ListNode add(ListNode l1, ListNode l2){
       ListNode head = new ListNode();
       ListNode t = head;
        int carry = 0;
       while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            t.next = new ListNode(sum % 10);
            t = t.next;
       }
       return head.next;
    }
}