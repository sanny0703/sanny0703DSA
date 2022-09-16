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
    // r: index of first height to the right of heights[i] that r<heights[i]
    // l: index of first height to the left of heights[i] that is l<heights[i]
    public static int largest(int[] heights) {
        int n = heights.length;
        int[] firstLeftIndexWithLesserHeight = new int[n];
        int[] firstRightIndexWithLesserHeight = new int[n];
        firstLeftIndexWithLesserHeight[0] = -1; // no heights to the left of 0th index.
        firstRightIndexWithLesserHeight[n - 1] = n; // no heights to the right of nth index.
        for (int i = 1; i < n; i++) {
            int currentPosition = i - 1;
            while (currentPosition >= 0 && heights[currentPosition] >= heights[i]) {
                // since the height of currentPosition is > heights[i] there is no way we can find lesser height before we the lesser height of currentPosition
                // so,let's start searching from there
                currentPosition = firstLeftIndexWithLesserHeight[currentPosition];
            }
            firstLeftIndexWithLesserHeight[i] = currentPosition;
        }
        for (int i = n - 2; i >= 0; i--) {
            int currentPosition = i + 1;
            while (currentPosition < n && heights[currentPosition] >= heights[i]) {
                currentPosition = firstRightIndexWithLesserHeight[currentPosition];
            }
            firstRightIndexWithLesserHeight[i] = currentPosition;
        }
        int largestArea = 0;
        for (int i = 0; i < n; i++) {
            // just take the largest among the areas formed with each histogram
            int currentHistogramArea = (firstRightIndexWithLesserHeight[i] - firstLeftIndexWithLesserHeight[i] - 1) * heights[i];
            largestArea = Math.max(largestArea, currentHistogramArea);
        }
        return largestArea;
    }

    public static void main(String[] args) {
        System.out.println(largest(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
