package LinkedList;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <br>
 * <br>
 * <code>
 * Input: head = [1,2,2,1]<br>
 * Output: true
 * </code>
 */
public class PalindromeList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode firstHalfEnd = middle(head);
        // we chose to reverse the second half because in case of odd length, we don't want to compare the middle element
        // which leads to incorrect answers, so instead we reverse second half and compare with the original list as long as the
        // second half is not null
        ListNode secondHalfHead = reverseList(firstHalfEnd);
        ListNode temp1 = head, temp2 = secondHalfHead;
        while (temp2 != null) {
            if (temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static ListNode middle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = null;
        while (head != null) {
            node = new ListNode(head.val, node);
            head = head.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
}
