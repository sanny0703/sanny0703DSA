package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];
        if (n == 2) return mergeTwoLists(lists[0], lists[1]);
        ListNode base = lists[0];
        for (int i = 1; i < n; i++) {
            base = mergeTwoLists(base, lists[i]);
        }
        return base;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = new ListNode(list1.val);
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.val);
                tail = tail.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;
        return dummy.next;
    }

    public static ListNode usingHeap(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            ListNode next = tail.next;
            if (next != null) queue.offer(next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode three = new ListNode(2, new ListNode(6));
        ListUtils.printList(merge(new ListNode[]{one, two, three}));
        ListUtils.printList(usingHeap(new ListNode[]{one, two, three}));
    }
}
