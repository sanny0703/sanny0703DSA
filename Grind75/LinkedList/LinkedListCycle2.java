package LinkedList;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class LinkedListCycle2 {

    /**
     * Consider a Linked List with a cycle in it.
     * L1: distance between head and starting point of the cycle
     * L2: distance between starting point and the meeting point of fast and slow pointers
     * <p>
     * So to arrive at the meeting point slow has traversed a distance of L1+L2
     * fast pointer has traversed a distance of L1+L2+x+L2( x+L2 : because L2 is part of the cycle and x is C-L2)
     * <p>
     * since fast traversed twice as much as slow 2(L1+L2) = L1+L2+x+L2;
     * L1 = x
     * which means distance from head to starting point of cycle is equal to the remaining part of cycle other than L2
     */
    public static ListNode cycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode t = new ListNode(2);
        t.next = new ListNode(0, new ListNode(-4, t));
        head.next = t;
        System.out.println(cycle(head).val);
    }
}
