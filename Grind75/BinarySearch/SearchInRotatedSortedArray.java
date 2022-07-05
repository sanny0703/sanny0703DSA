package BinarySearch;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int index = -1;
        while (low <= high) {
            // checking whether arr is already sorted
            if (nums[low] <= nums[high]) {
                index = low;
                break;
            }
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n; // cycle
            int prev = (mid + n - 1) % n; //cycle
            // if mid is  the target
            if (nums[prev] <= nums[mid] && nums[next] <= nums[mid]) {
                index = mid;
                break;
            } else if (nums[low] <= nums[mid]) // search in unsorted part
                low = mid + 1;
            else high = mid - 1;

        }
        if (nums[index] == target) return index;
        low = 0;
        high = n - 1;
        if (nums[low] <= target && index > 0)
            // if target is in left half
            return binarySearch(nums, low, index - 1, target);
            // right half
        else return binarySearch(nums, index, high, target);

    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
