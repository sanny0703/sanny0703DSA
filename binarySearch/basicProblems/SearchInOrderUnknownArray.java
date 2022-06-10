package basicProblems;

/**
 * search for an element in an array whose order is not know(ascending/descending)
 */
public class SearchInOrderUnknownArray {
    /**
     * just make two different flavours of Binary Search each for ascending and descending orders
     */
    public static int search(int[] arr, int target) {
        boolean isAscending = arr[0] < arr[1];
        return isAscending ? bsAsec(arr, target) : bsDec(arr, target);
    }

    public static int bsAsec(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int bsDec(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 9};
        //4
        System.out.println(search(arr, 5));

        int[] arr2 = {8, 7, 5, 4, 2, 1};
        //4
        System.out.println(search(arr2, 2));
        //-1
        System.out.println(search(arr2, 9));
    }
}
