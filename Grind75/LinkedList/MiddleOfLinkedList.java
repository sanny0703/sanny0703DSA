package LinkedList;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <br>
 * If there are two middle nodes, return the second middle node.
 * <br>
 * <br>
 * <code>
 * Input: head = [1,2,3,4,5]<br>
 * Output: [3,4,5]<br>
 * Explanation: The middle node of the list is node 3.
 * </code>
 */
public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListUtils.printList(head);
        ListUtils.printList(middleNode(head));
    }
}
