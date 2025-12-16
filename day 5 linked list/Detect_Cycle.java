class ListNode {    // SC O(1)  TC : O(n+m)
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Detect_Cycle {
    public static void main(String[] args) {
        // Create nodes
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
    
        // Link them: 3 → 2 → 0 → -4
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    
        // Create cycle: -4 → 2
        n4.next = n2;
    
        Solution sol = new Solution();
        ListNode cycleStart = sol.detectCycle(n1);
    
        if (cycleStart != null)
            System.out.println("Cycle starts at: " + cycleStart.val);
        else
            System.out.println("No cycle");
    }    
}

class Solution{
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    } 
}