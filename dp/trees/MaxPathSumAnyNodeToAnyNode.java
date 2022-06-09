package trees;

public class MaxPathSumAnyNodeToAnyNode {
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
        /**
         * if the sum of left and right subtrees is less than root.val, we can always take root.val because
         * it doesn't matter which node(AnyNode to AnyNode)
         */
        int temp = Math.max(Math.max(l, r) + root.val, root.val);// it's any node of the path
        int ans = Math.max(temp, l + r + root.val); // max of when it is just any node in the path and when it is root of the path
        res = Math.max(res, ans);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(maxSum(root));
    }
}
