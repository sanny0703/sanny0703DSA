package LinkedList;

/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1->2->3
 * <p>
 * Output:
 * 1->2->4
 * <p>
 * ======Approach========
 * Reverse the list find the first non 9 digit and add +1 to it and make all 9 digit to left as 0
 */
public class PlusOne {
    public static ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < 9) {
                temp.val += 1;
                break;
            } else {
                if (temp.next == null) {
                    temp.val = 0;
                    temp.next = new ListNode(1);
                    break;
                } else {
                    temp.val = 0;
                    temp = temp.next;
                }
            }
        }
        return reverse(head);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head, prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListUtils.printList(head);
        head = plusOne(head);
        ListUtils.printList(head);
    }
}
