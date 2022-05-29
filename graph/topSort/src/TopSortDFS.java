import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * only applied on DAG
 * No Cycle
 * No Undirected
 */
public class TopSortDFS {

    public static List<Integer> topSort(List<List<Integer>>adj){
        int N = adj.size();
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            if(!visited[i]) dfs(i,adj,visited,stack);
        }
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
    public static  void dfs(int cur, List<List<Integer>>adj,boolean[] visited,Stack<Integer> stack){
        visited[cur] = true;
        for(int neighbor:adj.get(cur)){
            if(!visited[neighbor]) dfs(neighbor,adj,visited,stack);
        }
        stack.push(cur);
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        System.out.println(topSort(adj));
    }
}
