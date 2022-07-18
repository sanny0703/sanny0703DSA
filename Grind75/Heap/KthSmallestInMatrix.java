package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * You must find a solution with a memory complexity better than O(n2).
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * <p>
 * <p>
 * <p>
 * Naive approach:
 * use a maxHeap and traverse the whole matrix
 * TC:O(N^2 logK)
 * total N^2 elements in the matrix and heap maintains at max k elements
 */
public class KthSmallestInMatrix {

    public static int smallest(int[][] matrix, int k) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int n = matrix.length;
        // we just only need k th smallest, which can be found in these columns itself
        for (int j = 0; j < Math.min(n, k); j++)
            queue.offer(new int[]{0, j, matrix[0][j]});
        for (int i = 0; i < k - 1; i++) {
            int[] cur = queue.poll();
            if (cur[0] == n - 1) continue;
            queue.offer(new int[]{cur[0] + 1, cur[1], matrix[cur[0] + 1][cur[1]]});
        }
        return queue.peek()[2];
    }

    public static void main(String[] args) {
        System.out.println(smallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }
}
