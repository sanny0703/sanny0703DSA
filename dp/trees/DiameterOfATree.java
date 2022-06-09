package trees;

/**
 * <i><code> Here we are counting no of nodes in a path, not the edges</code></i>
 * <h3>Diameter of Tree</h3>
 * Given a binary tree, you need to compute the length of the diameter of the tree.<br>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.<br>
 * This path may or may not pass through the root.<br><br>
 *
 * <code>Example:<br>
 * Given a binary tree<br>
 * 1      <br>
 * / \     <br>
 * 2   3    <br>
 * / \       <br>
 * 4   5      <br>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].</code>
 */
public class DiameterOfATree {
    private static int res;

    public static int diameter(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res;
    }

    public static int solve(TreeNode root) {
        if (root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        int temp = Math.max(l, r) + 1; // when it is just a node in max path
        int ans = Math.max(temp, 1 + l + r); //(1+l+r)--> when it is the root of max path // and checking which is max
        res = Math.max(res, ans);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameter(root));
    }

}
