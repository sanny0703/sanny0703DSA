package NArayTree;

import java.util.*;

/**
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 */
public class Postorder {
    private static final List<Integer> list = new ArrayList<>();

    public static List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        if (root.children != null) {
            for (Node child : root.children)
                postorder(child);
        }
        list.add(root.val);
        return list;
    }

    public static List<Integer> iterative(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            list.add(cur.val);
            if (cur.children != null) {
                for (Node child : cur.children)
                    stack.push(child);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        Node n = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(n, new Node(2), new Node(4)));
        System.out.println(postorder(root));
        System.out.println(iterative(root));
    }
}
