package LinkedList;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 */
public class ReverseNodesInGroupOfK {

    public static  ListNode reverseGroups(ListNode head,int k){
        if(head == null || head.next == null || k==1)
            return  head;
        ListNode  dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int count =0;
        while(head!= null){
            count++;
            if(count%k==0){
                begin = reverse(begin,head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return  dummy.next;
    }
    public  static ListNode reverse(ListNode begin, ListNode end){
        ListNode first = begin.next,cur = begin.next,prev = begin;
        while(cur!= end){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // now first cur is at end
        // connect back the new end
        first.next = cur;
        // connect back the new begin
        begin.next = prev;
        // return the node prev to end
        return  first;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListUtils.printList(head);
        ListUtils.printList(reverseGroups(head,2));
    }
}
