package Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class LargestRectangleInHistogram {
    //the idea here is the largest area of rectangle  that can be formed with heights[i]
    // is  with width(r-l-1)
    // r: first height to the right of heights[i] that r<heights[i]
    // l: first height to the left of heights[i] that is l<heights[i]
    public static int largest(int[] heights) {
        int n = heights.length;
        int[] lessFromRight = new int[n];
        int[] lessFromLeft = new int[n];
        lessFromLeft[0] = -1;
        lessFromRight[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = lessFromLeft[p]; // these are larger than me,and you are smaller than me, so there is no way they are
            //smaller than you, so just start searching from the index which is smaller than me
            lessFromLeft[i] = p;
        }
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largest(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
