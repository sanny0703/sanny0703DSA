package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElement {
    public static int largest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(largest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
