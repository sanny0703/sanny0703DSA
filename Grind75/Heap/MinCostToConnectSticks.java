package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You have some sticks with positive integer lengths.
 * <p>
 * You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y. You perform this action until there is one stick remaining.
 * <p>
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 * <p>
 * Example 1:
 * <p>
 * Input: sticks = [2,4,3]
 * <p>
 * Output: 14
 * <p>
 * Example 2:
 */
public class MinCostToConnectSticks {
    public static int minCost(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) queue.offer(stick);
        int cost = 0;
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            cost += sum;
            queue.offer(sum);
        }
        return cost;
    }

    public static void main(String[] args) {
        //30
        System.out.println(minCost(new int[]{1, 8, 3, 5}));
    }
}
