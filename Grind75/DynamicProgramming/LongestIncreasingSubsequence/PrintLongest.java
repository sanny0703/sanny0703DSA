package DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * print the longest IncreasingSubsequence
 */
public class PrintLongest {
    public static List<Integer> longestSubsequence(int[] nums) {
        List<Integer> sequence = new ArrayList<>(),
                IndexOfSequence = new ArrayList<>(); // store indices along with nums
        int[] trace = new int[nums.length]; // stores the prev index for each entry in sequence
        Arrays.fill(trace, -1);
        for (int i = 0; i < nums.length; i++) {
            if (sequence.isEmpty() || sequence.get(sequence.size() - 1) < nums[i]) {
                if (!sequence.isEmpty())
                    // if it's not the first entry store the prev index of the entry
                    trace[i] = IndexOfSequence.get(IndexOfSequence.size() - 1);
                sequence.add(nums[i]);
                IndexOfSequence.add(i);
            } else {
                int index = search(sequence, nums[i]);
                if (index > 0)
                    // store prev index of the new entry
                    trace[i] = IndexOfSequence.get(index - 1);
                IndexOfSequence.set(index, i);
                sequence.set(index, nums[i]);
            }
        }
        List<Integer> result = new ArrayList<>();
        int t = IndexOfSequence.get(IndexOfSequence.size() - 1);
        while (t != -1) {
            result.add(nums[t]);
            t = trace[t];
        }
        Collections.reverse(result);
        return result;

    }

    private static int search(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{2, 6, 8, 3, 4, 5, 1}));
    }
}
