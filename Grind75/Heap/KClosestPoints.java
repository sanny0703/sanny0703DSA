package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class KClosestPoints {
    public static int[][] closest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for (int[] point : points) {
            if (maxHeap.size() < k)
                maxHeap.offer(point);
            else {
                if (distance(maxHeap.peek()) > distance(point)) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;
    }

    public static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(closest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
