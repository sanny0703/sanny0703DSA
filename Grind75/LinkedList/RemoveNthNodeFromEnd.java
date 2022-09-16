package LinkedList;

import org.jetbrains.annotations.NotNull;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(@NotNull ListNode head, int n) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int index = size - n;
        if (index == 0) {
            head = head.next;
        } else {
            cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * the idea here is to maintain a gap of n+1 between slow and fast , and both move at same speed , sp when fast reaches end
     * the slow will be at exactly the node before the node to be removed
     * <p>
     * slow and fast are started at new dummy to taken care of the case when n == size of the list
     */
    public static ListNode onePass(ListNode head,int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 1; i <= n + 1; i++)
            fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListUtils.printList(head);
        ListUtils.printList(removeNthFromEnd(head, 2));
    }
}
