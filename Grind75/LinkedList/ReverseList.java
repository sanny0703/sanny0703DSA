package LinkedList;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <br>
 * <br>
 * <code>
 * Input: head = [1,2,3,4,5]<br>
 * Output: [5,4,3,2,1]
 * </code>
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = null;
        while (head != null) {
            node = new ListNode(head.val, node);
            head = head.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListUtils.printList(head);
        ListUtils.printList(reverseList(head));
    }
}
