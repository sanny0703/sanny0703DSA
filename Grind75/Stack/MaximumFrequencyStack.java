package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * <p>
 * Implement the FreqStack class:
 * <p>
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 */
public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public MaximumFrequencyStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > maxFreq)
            maxFreq = f;
        if (!group.containsKey(val))
            group.put(val, new Stack<>());
        group.get(f).push(val);
    }

    public int pop() {
        int val = group.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        if (group.get(maxFreq).size() == 0)
            maxFreq--;
        return val;
    }
}
