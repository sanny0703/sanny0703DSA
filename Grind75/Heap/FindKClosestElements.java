package Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 */
public class FindKClosestElements {
    // one obvious approach is to use heap and traverse each and every element
    // but the arr is already sorted
    // let's use two pointer algo
    public static List<Integer> twoPointer(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high] - x))
                low++;
            else high--;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    // we can just apply binary search here to find start point of k elements
    public static List<Integer> binarySearch(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                low = mid + 1;
            else high = mid;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(twoPointer(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }
}
