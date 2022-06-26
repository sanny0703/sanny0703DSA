package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum {
    public static int[] maximum(int[] nums, int k) {
        int n = nums.length;
        ;
        int[] ans = new int[n - k + 1];
        Deque<Integer> list = new ArrayDeque<>();
        int i = 0, j = 0;
        while (j < n) {
            // no use for smaller elements
            while (!list.isEmpty() && list.getLast() < nums[j])
                list.removeLast();
            list.addLast(nums[j]);
            if (j - i + 1 == k) {
                int first = list.getFirst();
                ans[i] = first;
                // if the nums[i] is in list,it will be at First
                // cause if it is useless, we already have removed it
                if (first == nums[i]) {
                    list.removeFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
