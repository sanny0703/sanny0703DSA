package LinkedList;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <br>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <br>
 * Return the head of the merged linked list.
 * <br>
 * <br>
 * <code>
 * Input: list1 = [1,2,4], list2 = [1,3,4]<br>
 * Output: [1,1,2,3,4,4]
 * </code>
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy, temp1 = list1, temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                cur.next = temp1;
                cur = cur.next;
                temp1 = temp1.next;
            } else {
                cur.next = temp2;
                cur = cur.next;
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) cur.next = temp1;
        if (temp2 != null) cur.next = temp2;
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListUtils.printList(mergeTwoLists(list1, list2));
    }
}
