package DynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, <br>
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected<br>
 * it will automatically contact the police if two adjacent houses were broken into on the same night.<br><br>
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <br>
 * <br>
 * <code>
 * Input: nums = [1,2,3,1]
 * <br>
 * Output: 4
 * <br>
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * <br>
 * Total amount you can rob = 1 + 3 = 4.
 * </code>
 */
public class HouseRobber {
    public static int maxRob(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0]; // we got only option here
        dp[1] = Math.max(arr[0], arr[1]); // we got two here, so we choose the max
        for (int i = 2; i < n; i++) {
            // at every stage later we got two options
            // if we choose to include this one then we can add the previous to previous one to our current
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxRob(new int[]{1, 2, 3, 1}));
    }
}
