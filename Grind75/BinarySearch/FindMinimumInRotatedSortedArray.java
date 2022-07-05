package BinarySearch;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            // if already sorted
            if (nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n; // handle out of bounds
            int next = (mid + 1) % n;// handle out of bounds
            // if both adjacent are > mid ,then mid is min
            if (nums[prev] >= nums[mid] && nums[next] >= nums[mid])
                return nums[mid];
                // search in unsorted array
            else if (nums[low] <= nums[mid])
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
