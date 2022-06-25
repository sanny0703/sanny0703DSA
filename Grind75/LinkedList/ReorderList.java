package LinkedList;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 */
public class ReorderList {
    public static void reorder(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null; // split the list in to two halves
        ListNode l1 = head, l2 = reverse(slow); // reverse the second half
        merge(l1, l2); // merge both the halves
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next; // we will make this one next l2
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListUtils.printList(head);
        reorder(head);
        ListUtils.printList(head);
    }
}
