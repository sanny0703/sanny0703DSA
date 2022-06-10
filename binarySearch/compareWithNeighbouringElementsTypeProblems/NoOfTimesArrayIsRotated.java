package compareWithNeighbouringElementsTypeProblems;

/**
 * Find the Rotation Count in Rotated Sorted array<br>
 * Consider an array of distinct numbers sorted in increasing order. <br>
 * The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.<br>
 *
 * <code>Examples:<br><br>
 * <p>
 * Input : arr[] = {15, 18, 2, 3, 6, 12}<br>
 * Output: 2<br>
 * Explanation :<br>
 * Initial array must be {2, 3,
 * 6, 12, 15, 18}. We get the given array after <br>
 * rotating the initial array twice.<br><br>
 * <p>
 * Input : arr[] = {7, 9, 11, 12, 5}<br>
 * Output: 4<br>
 * <p>
 * Input: arr[] = {7, 9, 11, 12, 15};<br>
 * Output: 0</code>
 */
public class NoOfTimesArrayIsRotated {
    /**
     * we just have to find the index of the smallest element, if it is not zero,then the array is rotated
     */
    public static int countRotations(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            if (arr[low] <= arr[high]) // checking whether th arr is already sorted
                return low;
            int mid = low + (high - low) / 2;
            // without +n , if mid is 0 ; mid-1 becomes -1%n,to avoid that we add n
            int prev = (mid + n - 1) % n; //making a cycle if it goes out of the bounds
            int next = (mid + 1) % n;//making a cycle if it goes out of the bounds
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) // comparing with both neighbors
                return mid;
            // we should always go for the unsorted part
            else if (arr[low] <= arr[mid]) // if left part is sorted go to right and vice versa
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 1, 2, 3};
        //3 {array is rotated 3 times}
        System.out.println(countRotations(arr));
    }
}
