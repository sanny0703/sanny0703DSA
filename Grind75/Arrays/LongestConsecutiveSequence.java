package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    public static int longest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) { // this takes care of O(N) eg: [6,5,4,3,2,1] until 1 loop doesn't calculate anything
                int currentNum = num;
                int currentStreak = 0;
                while (set.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(longest(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
