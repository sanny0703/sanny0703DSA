package trees;

public class MaxPathSumFromLeafToLeaf {
    private static int res;

    public static int maxSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res;
    }

    public static int solve(TreeNode root) {
        if (root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        int temp = Math.max(l, r) + root.val; // here we don't have the freedom to just choose root.val when l and r are both negative
        int ans = Math.max(temp, l + r + root.val);
        res = Math.max(res, ans);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(-5);
        System.out.println(maxSum(root));
    }
}
