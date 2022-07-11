package NArayTree;

import java.util.*;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            while(size-->0){
                Node cur = queue.poll();
                l.add(cur.val);
                if(cur.children!= null){
                    for(Node child:cur.children){
                        queue.offer(child);
                    }
                }
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        Node n = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(n, new Node(2), new Node(4)));
        System.out.println(levelOrder(root));
    }
}
