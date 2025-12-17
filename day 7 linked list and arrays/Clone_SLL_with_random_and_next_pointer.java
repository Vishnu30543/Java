class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Clone_SLL_with_random_and_next_pointer {

    public static void main(String[] args) {

        // ===== Build Original List =====
        // Example:
        // 1 → 2 → 3
        // ↑    ↓    ↑
        // |    |    |
        // 3 ← 1 ← 2

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        n1.random = n3;
        n2.random = n1;
        n3.random = n2;

        // ===== Clone the List =====
        Node clonedHead = cloneList(n1);

        // ===== Print for Verification =====
        printList(clonedHead);
    }

    // ===== WRITE YOUR CORE LOGIC HERE =====
    static Node cloneList(Node head) {

        // Step 1: handle edge case
        // Step 2: create clone nodes & interleave with original
        // Step 3: assign random pointers
        // Step 4: separate original and cloned lists
        if(head == null) return head;       // Important
        insertClone(head);
        connectRandomPointers(head);
        Node res = getRandomList(head);

        return res;
    }

    static void insertClone(Node head){
        Node t = head;
        while (t != null) {
            Node c = new Node(t.val);
            c.next = t.next;
            t.next = c;
            t = t.next.next;    // t = c.next
        }
    }

    static void connectRandomPointers(Node head){
        Node t = head;
        while (t != null) {
            Node copy = t.next;
            if(t.random != null){
                copy.random = t.random.next;
            }
            else{
                copy.random = null;
            }
            t = t.next.next;
        }
    }

    static Node getRandomList(Node head){
        Node dummy = new Node(-1);
        Node tail = dummy;
        Node t = head;
        while (t != null) {
            tail.next = t.next;
            tail = tail.next;
            // Re-build the original list
            t.next = t.next.next;
            t = t.next;
        }
        return dummy.next;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println(
                "Node: " + curr.val +
                ", Random: " + randomVal
            );
            curr = curr.next;
        }
    }
}
