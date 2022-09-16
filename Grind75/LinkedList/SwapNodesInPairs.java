package LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */
public class SwapNodesInPairs {
    public static ListNode swap(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;

            temp.next = head;
            prev.next = temp;

            prev = head;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        ListUtils.printList(head);
        ListUtils.printList(swap(head));
    }
}
