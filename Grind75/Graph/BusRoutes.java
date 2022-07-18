package Graph;

import java.util.*;

/**
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 * <p>
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 * <p>
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 * <p>
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * <p>
 * Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * Output: -1
 */
public class BusRoutes {
    public static int findMinBuses(int[][] routes, int src, int dest) {
        int N = routes.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            // sorting it ,cause to make it easy to search for intersection ,and later we can use binary Search to search
            Arrays.sort(routes[i]);
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                if (intersect(routes[i], routes[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            // we sorted before, so we can use binarySearch instead of linear search here
            if (Arrays.binarySearch(routes[i], src) >= 0) {
                visited.add(i);
                queue.offer(new int[]{i, 1});
            }

            if (Arrays.binarySearch(routes[i], dest) >= 0) targets.add(i);
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], depth = cur[1];
            if (targets.contains(node)) return depth;
            for (int neighbor : adj.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }
        return -1;


    }

    public static boolean intersect(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) return true;
            if (a[i] > b[j]) j++;
            else i++;
        }
        return false;
    }
}
