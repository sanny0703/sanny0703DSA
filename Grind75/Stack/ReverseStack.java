package Stack;

import java.util.Stack;

/**
 * Reverse a stack recursively not using any loops
 * <p>
 * follow up:reverse without using extra space O(N)
 */
public class ReverseStack {
    public static void main(String[] args) {
        Recursive stack1 = new Recursive();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.stack);
        stack1.reverse();
        System.out.println(stack1.stack);
        Iterative stack = new Iterative();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        stack.reverse();
        stack.print();
    }

    private static class Recursive {
        public Stack<Integer> stack;

        public Recursive() {
            stack = new Stack<>();
        }

        private void insertAtBottom(int x) {
            if (stack.isEmpty()) stack.push(x);
            else {
                int a = stack.pop();
                insertAtBottom(x);
                stack.push(a);
            }
        }

        public void reverse() {
            if (!stack.isEmpty()) {
                int a = stack.pop();
                reverse();
                insertAtBottom(a);
            }
        }

        public int push(int x) {
            return stack.push(x);
        }

        public int pop() {
            return stack.pop();
        }
    }

    private static class Iterative {
        private Node head;

        public void push(int x) {
            if (head == null) {
                head = new Node(x);
                return;
            }
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + "-->");
                temp = temp.next;
            }
            System.out.println();
        }

        public void reverse() {
            if (head != null) {
                Node temp = head, prev = null;
                while (temp != null) {
                    Node next = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = next;
                }
                head = prev;
            }
        }

         static  class Node {
            Node next;
            int val;

            public Node(int val) {
                this.val = val;
            }
        }
    }


}
