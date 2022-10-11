package DynamicProgramming.LongestIncreasingSubsequence;

public class DpApproach {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1; // for first element the longest increasing  sequence will be itself
        int longest = 1;
        for (int i = 1; i < n; i++) {
            int maxBeforeI = 0; // longest before current element
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    // if it less than current element, we can include current element in that sequence
                    maxBeforeI = Math.max(maxBeforeI, dp[j]);
            }
            dp[i] = 1 + maxBeforeI;
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        //4 {2,3,4,5}
        System.out.println(longestSubsequence(new int[]{2, 6, 8, 3, 4, 5, 1}));
    }
}
