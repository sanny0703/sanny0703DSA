package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k-closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <code>
 * |a - x| < |b - x|, or
 * <br>
 * |a - x| == |b - x| and a < b
 * </code>
 * <p>
 * <code>
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * <br>
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * </code>
 */
public class KClosestElements {
    public static List<Integer> kClosest(int[] nums, int k, int x) {
        /*
          Since the array is sorted it's straight forward to use binary search.
          but here we have to search for k-closest elements to x, rather than x itself
         */
        int n = nums.length;
        int l = 0, r = n - k - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // if x -nums[mid]> nums[mid+k]-x this means nums[mid+1] -> nums[mid+k] are closer than nums[mid]
            // here we are trying to find the start point for k-closest that means nums[mid] should be better
            if (x - nums[mid] > nums[mid + k] - x)
                l = mid + 1;
            else r = mid - 1;
        }
        List<Integer> ans = new ArrayList<>();
        //from start point to k elements
        for (int i = l; i < l + k; i++) ans.add(nums[i]);
        return ans;
    }

    public static void main(String[] args) {
        // 4 closest to 5
        //4,5,6,6
        System.out.println(kClosest(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 6}, 4, 5));
    }
}
