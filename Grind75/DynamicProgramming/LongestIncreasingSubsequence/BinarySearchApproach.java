package DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchApproach {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num)
                list.add(num);
            else {
                int index = binarySearch(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    private static int binarySearch(List<Integer> list, int target) {
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
