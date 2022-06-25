package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class DesignLRUCache {
    int capacity;
    ListNode head, tail;
    Map<Integer, ListNode> cache;

    public DesignLRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();

        head.prev = null;
        head.next = tail;

        tail.prev = head;
        tail.next = null;

    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, val);
            addNode(newNode);
            cache.put(key, newNode);
            if (cache.size() > capacity) {
                ListNode oldNode = popTail();
                cache.remove(oldNode.key);
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    public void addNode(ListNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(ListNode node) {
        deleteNode(node);
        addNode(node);
    }

    public ListNode popTail() {
        ListNode node = tail.prev;
        deleteNode(node);
        return node;
    }

    class ListNode {
        int key, val;

        public ListNode() {
        }

        ListNode next, prev;

        public ListNode(int key, int val) {
            this(key, val, null, null);
        }

        public ListNode(int key, int val, ListNode prev, ListNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
