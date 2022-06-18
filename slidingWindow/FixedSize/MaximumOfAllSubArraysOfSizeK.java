package FixedSize;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.<br>
 * <br>
 * <code>Example:<br>
 * <p>
 * Input 1:<br>
 * A = [1, 3, -1, -3, 5, 3, 6, 7]<br>
 * B = 3<br>
 * Output 1:<br>
 * C = [3, 3, 5, 5, 6, 7] . </code>
 */
public class MaximumOfAllSubArraysOfSizeK {
    public static List<Integer> maxOfAllSubArrays(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> maxTrack = new ArrayDeque<>();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            while (!maxTrack.isEmpty() && maxTrack.getLast() < arr[j]) {
                maxTrack.pollLast();
            }
            maxTrack.addLast(arr[j]);
            if (j - i + 1 == k) {
                int first = maxTrack.getFirst();
                ans.add(first);
                if (arr[i] == first)
                    maxTrack.pollFirst();
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxOfAllSubArrays(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
