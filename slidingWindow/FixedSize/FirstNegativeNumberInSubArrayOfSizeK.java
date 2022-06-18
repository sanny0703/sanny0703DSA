package FixedSize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.<br>
 * <br>
 * <code>Example:
 * <br>
 * Input:<br>
 * 2<br>
 * 5<br>
 * -8 2 3 -6 10<br>
 * 2<br>
 * 8<br>
 * 12 -1 -7 8 -15 30 16 28<br>
 * 3<br>
 * <p>
 * Output:<br>
 * -8 0 -6 -6<br>
 * -1 -1 -7 -15 -15 0 . </code>
 */
public class FirstNegativeNumberInSubArrayOfSizeK {
    public static List<Integer> firstNegative(int[] arr, int k) {
        List<Integer> negativesFound = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) negativesFound.add(arr[j]);
            if (j - i + 1 == k) {
                if (negativesFound.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(negativesFound.get(0));
                    if (arr[i] <0)
                        negativesFound.remove(0);
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(firstNegative(new int[]{-8, 2, 3, -6, 10}, 2));
        System.out.println(firstNegative(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3));
    }
}
