package binarySearchOnAnswer;

/**
 * A peak element is an element that is strictly greater than its neighbors.<br><br>
 * <p>
 * Given an integer array nums, find a peak element, and return its index.<br>
 * If the array contains multiple peaks, return the index to any of the peaks.<br><br>
 *
 * <code>
 * Input: arr = [1,2,3,1]<br>
 * Output: 2<br>
 * Explanation: 3 is a peak element and your function should return the index number 2.<br>
 * </code>
 */
public class PeakElement {
    public static int peak(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; // only one element case
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if mid is the first element
            int left = mid == 0 ? Integer.MIN_VALUE : arr[mid - 1];
            // if mid is the last element
            int right = mid == n - 1 ? Integer.MIN_VALUE : arr[mid + 1];
            if (arr[mid] > left && arr[mid] > right)
                return mid;
            // move to the part which is greater than mid
            if (left > arr[mid])
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        //5 {6 is the peak}
        System.out.println(peak(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
