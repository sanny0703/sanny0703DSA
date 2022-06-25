package LinkedList;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateList {
    public static ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        k %= size;
        if (k == 0) return head;
        ListNode fast = head, slow = head;
        //after this loop fast reaches the first node after rotation
        while (k-- > 0) {
            fast = fast.next;
        }
        // slow reaches the last node after rotation
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode ans = slow.next; // cause slow is the last node after rotation
        fast.next = head;
        slow.next = null;
        return ans;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListUtils.printList(head);
        ListUtils.printList(rotate(head, 2));
    }
}
