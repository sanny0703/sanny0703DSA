package Graph;

import java.util.*;

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 * <p>
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * <p>
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * <p>
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * <p>
 * <p>
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 */
public class MinimumHeightTrees {
    /**
     * for a structure like tree or graph there can be at most two centroids because if there are 3 or more
     * they form a cycle, since they are equally important
     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            inDegree[edge[1]]++;
            inDegree[edge[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 1) queue.offer(i);
        //we just start removing all the nodes layer by layer starting from leaf nodes until there are at least two nodes
        //left
        while (n > 2) {
            int size = queue.size();
            n -= size;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int neighbor : adj.get(cur)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 1) queue.offer(neighbor);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.addAll(queue);
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
    }
}
