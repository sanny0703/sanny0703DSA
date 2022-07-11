package NArayTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 */
public class Preorder {
    private static final List<Integer> list = new ArrayList<>();

    public static List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        list.add(root.val);
        if (root.children != null) {
            for (Node child : root.children)
                preorder(child);
        }
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
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Node n = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(n, new Node(2), new Node(4)));
        System.out.println(preorder(root));
        System.out.println(iterative(root));
    }
}
