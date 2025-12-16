class ListNode {    // SC O(1)  TC : O(n+m)
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Cycle_Detection {
    public static void main(String[] args) {

        ListNode n1  = new ListNode(1);
        ListNode n2  = new ListNode(2);
        ListNode n3  = new ListNode(3);
        ListNode n4  = new ListNode(4);
        ListNode n5  = new ListNode(5);
        ListNode n6  = new ListNode(6);
        ListNode n7  = new ListNode(7);
        ListNode n8  = new ListNode(8);
        ListNode n9  = new ListNode(9);
        ListNode n10 = new ListNode(10);
    
        // linear links
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
    
        // create cycle: last node points back to n5
        n10.next = n5;
    

        Solution sol = new Solution();
        ListNode head = sol.find(n1);
        System.out.print(head.val);
    }
}

class Solution {
    public ListNode find(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            } 
        }
        if(! hasCycle) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}