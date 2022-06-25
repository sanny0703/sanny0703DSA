package LinkedList;

public class ListUtils {
    public static void printList(ListNode head) {
        if (head == null)
            return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "-->");
            cur = cur.next;
        }
        System.out.println();
    }
}
