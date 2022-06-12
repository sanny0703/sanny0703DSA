package compareWithNeighbouringElementsTypeProblems;

/**
 * SEARCH IN A NEARLY SORTED ARRAY:<br><br>
 * <p>
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,<br>
 * i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.<br>
 * Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].<br><br>
 * <p>
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.<br><br>
 *
 * <code>Example :<br>
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40<br>
 * Output: 2 <br>
 * Output is index of 40 in given array</code>
 */
public class SearchNearlySortedArray {

    public static int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            // since it may present i+1 or i-1 we are going to check them out too
            if (mid - 1 >= low && arr[mid - 1] == target)
                return mid - 1;
            if (mid + 1 <= high && arr[mid + 1] == target)
                return mid + 1;
            if (arr[mid] < target)
                low = mid + 2; // since, we have already checked mid+1, but no luck
            else
                high = mid - 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        //2
        System.out.println(search(new int[]{10, 3, 40, 20, 50, 80, 70}, 40));
    }
}
