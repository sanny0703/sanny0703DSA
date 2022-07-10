package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * <p>
 * the idea is to use two heaps one two store left half(smaller) in reverseOrder and the other stores right half in normal Order
 * if there are odd number of elements we will store the extra element in right heap and just return that one as median
 * if even number of elements will just take the average of both heaps peek and return it
 */
public class FindMedianFromDataStream {
    Queue<Integer> small;
    Queue<Integer> large;

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void add(int num) {
        large.offer(num);
        small.offer(large.poll());
        if (large.size() < small.size())
            large.offer(small.poll());
    }

    public double getMedian() {
        if (large.size() == small.size())
            return (large.peek() + small.peek()) / 2.0;
        return large.peek();
    }
}
