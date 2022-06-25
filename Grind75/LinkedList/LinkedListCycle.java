package LinkedList;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <br>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <br>
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <br>
 * <br>
 * <code>
 * Input: head = [3,2,0,-4], pos = 1<br>
 * Output: true<br>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * </code>
 */
public class LinkedListCycle {
    public static boolean isCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }


}
