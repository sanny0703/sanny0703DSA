package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public static boolean canFinish(int numOfCourses, int[][] prerequisites) {
        int N = numOfCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        return !isCycle(adj);
    }

    public static boolean isCycle(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        boolean[] dfsVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, dfsVisited)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int cur, List<List<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
        visited[cur] = true;
        dfsVisited[cur] = true;
        for (int neighbor : adj.get(cur)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, dfsVisited)) return true;
            } else if (dfsVisited[neighbor]) return true;
        }
        dfsVisited[cur] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
