package Stack;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <p>
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * <p>
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */
public class QueueUsingStacks {
    Stack<Integer> stack1, stack2;
    int front;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        front = -1;
    }

    public int peek() {
        return front;
    }

    public void push(int x) {
        if (stack1.isEmpty()) front = x;
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(x);
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
    }

    public int poll() {
        int res = stack1.pop();
        front = stack1.isEmpty() ? -1 : stack1.peek();
        return res;
    }
}
