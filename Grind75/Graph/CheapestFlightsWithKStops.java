package Graph;

import java.util.*;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 * <p>
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
public class CheapestFlightsWithKStops {
    public static int findCheapest(int n, int[][] flights, int src, int dest, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Node(flight[1], flight[2]));
        }
        // we maintain a visited map to keep track of visited cities along with the stops it took to visit that city
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(src, 0);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currentCity = cur[0], price = cur[1], stops = cur[2];
            if (currentCity == dest) {
                return price;
            }
            // we only visit the city ,if it's not visited or stops < k
            if (!visited.containsKey(currentCity) || stops < k) {
                visited.put(currentCity, stops);
                if (stops > k) continue;
                for (Node neighborNode : adj.get(currentCity)) {
                    queue.offer(new int[]{neighborNode.city, price + neighborNode.price, stops + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findCheapest(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));

    }

    static class Node {
        int city, price;

        public Node(int city, int price) {
            this.city = city;
            this.price = price;
        }
    }
}
