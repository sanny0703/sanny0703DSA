package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 *
 * Approach++
 * this problem is just to find a cycle in undirected graph
 */
public class GraphValidTree {
    public static boolean isValid(int n,int[][] edges){
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return !isCycle(adj);
    }
    public static boolean isCycle(List<List<Integer>>adj){
        int N = adj.size();
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            if(!visited[i])
                if(dfs(i,-1,adj,visited))
                    return  true;
        }
        return false;
    }
    public static boolean dfs(int cur,int prev,List<List<Integer>>adj,boolean[] visited){
        visited[cur] = true;
        for(int neighbor:adj.get(cur)){
            if(!visited[neighbor]){
                if(dfs(neighbor,cur,adj,visited))
                    return true;
                else if(prev != neighbor)
                    return  true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println(isValid(5, new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}));
    }
}
