/**
 * search for an index of an element in sorted array
 */
public class BinarySearch {
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 6, 8, 9};
        //2
        System.out.println(search(arr, 2));
        // -1
        System.out.println(search(arr, 5));
    }
}
