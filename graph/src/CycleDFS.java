import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleDFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(1,4));
        adj.add(Arrays.asList(5));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(3,6,10));
        adj.add(Arrays.asList(5,7));
        adj.add(Arrays.asList(6,8));
        adj.add(Arrays.asList(7,9,11));
        adj.add(Arrays.asList(10));
        adj.add(Arrays.asList(5,9));
        adj.add(Arrays.asList(8));
        System.out.println(isCycle(adj));

    }
    public static boolean isCycle(List<List<Integer>> adj){
        int N = adj.size();
        boolean[] visited = new boolean[N];
        for(int i =1;i<=N;i++){
            if(!visited[i]){
                if(dfs(i,-1,adj,visited)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(int cur, int prev,List<List<Integer>> adj, boolean[] visited){
        visited[cur] = true;
        for(int neighbor:adj.get(cur)){
            if(!visited[neighbor]){
                if(dfs(neighbor,cur,adj, visited)) return true;
            }
            else if(neighbor!= prev) return true;
        }
        return false;
    }
}
