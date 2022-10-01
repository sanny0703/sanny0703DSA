package Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        leftHeight[0] = height[0];
        rightHeight[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++)
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--)
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int var = Math.min(leftHeight[i], rightHeight[i]) - height[i];
            if (var > 0) ans += var;
        }
        return ans;
    }
    public static int trapTwoPointer(int[] height){
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else ans += maxLeft - height[left];
                left++;
            } else {
                if (height[right] >= maxRight)
                    maxRight = height[right];
                else ans += maxRight - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapTwoPointer(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
