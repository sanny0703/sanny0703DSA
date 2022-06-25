package LinkedList;

/**
 * LinkedList Data Structure
 */
public class DesignLinkedList {
    private ListNode head;
    private int size;

    public DesignLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size - 1)
            return -1;
        if (index == 0)
            return head.val;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0)
            addAtHead(val);
        else if (index == size)
            addAtTail(val);
        else {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(val);
            ListNode next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1)
            return;
        if (index == 0) {
            head = head.next;
        } else {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        size--;
    }

    public static void main(String[] args) {
        DesignLinkedList linkedList = new DesignLinkedList();
        linkedList.addAtTail(10);
        linkedList.addAtHead(1);
        ListUtils.printList(linkedList.head);
        linkedList.addAtIndex(1, 2);
        linkedList.addAtIndex(2, 3);
        ListUtils.printList(linkedList.head);
        linkedList.deleteAtIndex(3);
        linkedList.addAtTail(4);
        ListUtils.printList(linkedList.head);
    }
}
