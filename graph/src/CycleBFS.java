import java.util.*;

public class CycleBFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(1,3));
        adj.add(Arrays.asList(2));
//        adj.add(Arrays.asList(5));
//        adj.add(Arrays.asList(2));
//        adj.add(Arrays.asList(3,6,10));
//        adj.add(Arrays.asList(5,7));
//        adj.add(Arrays.asList(6,8));
//        adj.add(Arrays.asList(7,9,11));
//        adj.add(Arrays.asList(10,8));
//        adj.add(Arrays.asList(5,9));
//        adj.add(Arrays.asList(8));
        System.out.println(isCycle(adj));

    }
    public static boolean isCycle(List<List<Integer>> adj){
        int N = adj.size();
        boolean[] visited = new boolean[N];
        for(int i =1;i<N-1;i++){
            if(!visited[i]){
                if(bfs(i,adj,visited)) return true;
            }
        }
        return false;
    }
    public static boolean bfs(int vertex,List<List<Integer>> adj,boolean[] visited){
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(vertex,-1));
        visited[vertex] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int neighbor:adj.get(cur.cur)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(new Node(neighbor,cur.cur));
                }
                else if(cur.prev != neighbor) return true;
            }
        }
        return false;
    }

      static class Node{
        int cur,prev;
        public Node(int cur, int prev){
            this.cur = cur;
            this.prev = prev;
        }
     }
}
