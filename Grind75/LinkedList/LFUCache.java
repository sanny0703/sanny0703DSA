package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * <p>
 * Implement the LFUCache class:
 * <p>
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity,
 * it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency),
 * the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 * <p>
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LFUCache {
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoubleLinkedList> frequencyMap;
    private int capacity;
    private int minFrequency;
    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        size = 0;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        for (int i = 1; i <= 4; i++)
            cache.put(i, i);
        for (int i = 4; i >= 1; i--)
            System.out.println(cache.get(i));
        cache.put(5, 5);
        for (int i = 1; i <= 5; i++)
            System.out.println(cache.get(i));
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null)
            return -1;
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = nodeMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DoubleLinkedList oldList = frequencyMap.get(minFrequency);
                nodeMap.remove(oldList.removeLast().key);
                size--;
            }
            size++;
            minFrequency = 1;
            DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
            newList.add(node);
            frequencyMap.put(node.frequency, newList);
        } else {
            node.val = value;
            updateNode(node);
        }
    }

    private void updateNode(Node node) {
        DoubleLinkedList oldList = frequencyMap.get(node.frequency);
        oldList.remove(node);
        if (node.frequency == minFrequency && oldList.size == 0)
            minFrequency++;
        node.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
        newList.add(node);
        frequencyMap.put(node.frequency, newList);
    }

    private static class DoubleLinkedList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node) {
            Node next = node.next;
            Node prev = node.prev;

            next.prev = prev;
            prev.next = next;
            size--;
        }

        public Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private static class Node {
        int key;
        int val;
        int frequency;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            frequency = 1;
        }
    }
}
