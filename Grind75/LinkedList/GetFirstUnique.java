package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * ou have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 */
public class GetFirstUnique {
    static class FirstUnique {
        ListNode head, tail;
        Map<Integer, ListNode> cache;
        int nodes;

        public FirstUnique(int[] nums) {
            cache = new HashMap<>();
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
            nodes = 0;
            for (int num : nums)
                add(num);
        }

        public void addNodeAtTail(ListNode node) {
            ListNode previous = tail.prev;
            previous.next = node;
            node.prev = previous;
            node.next = tail;
            tail.prev = node;
            nodes++;
        }

        public void deleteNode(ListNode node) {
            ListNode next = node.next, prev = node.prev;
            prev.next = next;
            next.prev = prev;
            nodes--;
        }

        public void add(int val) {
            if (cache.containsKey(val)) {
                deleteNode(cache.get(val));
                cache.remove(val);
            } else {
                cache.put(val, new ListNode(val));
                addNodeAtTail(cache.get(val));
            }
        }

        public int getFirstUnique() {
            if (nodes == 0) return -1;
            return head.next.val;
        }
    }

    static class ListNode {
        int val;
        ListNode next, prev;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
