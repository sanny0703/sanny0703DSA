package compareWithNeighbouringElementsTypeProblems;

/**
 * find floor and ceil of an element in an array
 */
public class FloorAndCeil {
    public static int searchFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return arr[mid];
            if (arr[mid] < target) {
                res = Math.max(res, arr[mid]);
                low = mid + 1;
            } else high = mid - 1;
        }
        return res;
    }

    public static int searchCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return arr[mid];
            if (arr[mid] > target) {
                res = Math.min(res, arr[mid]);
                high = mid - 1;
            } else low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 8, 10, 12, 19};
        //4
        System.out.println(searchFloor(arr, 5));
        // 8
        System.out.println(searchCeil(arr, 5));
    }
}
