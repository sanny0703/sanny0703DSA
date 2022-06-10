package compareWithNeighbouringElementsTypeProblems;

/**
 * search for an element in rotated sorted array
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int index = -1; // index of the smallest element
        while (low <= high) {
            if (arr[low] <= arr[high]) {
                index = low;
                break;
            }
            int mid = low + (high - low) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                index = mid;
                break;
            } else if (arr[low] <= arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (arr[index] == target)
            return index;
        low = 0;
        high = n - 1;
        if (arr[low] <= target)
            return binarySearch(arr, low, index - 1, target);
        else
            return binarySearch(arr, index, high, target);

    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};
        //2
        System.out.println(search(arr, 15));
        //-1
        System.out.println(search(arr,13));
    }
}
