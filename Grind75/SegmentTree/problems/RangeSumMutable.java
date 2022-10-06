package SegmentTree.problems;

public class RangeSumMutable {

    private final SegmentTreeNode root;

    public RangeSumMutable(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7};
        RangeSumMutable rangeSumMutable = new RangeSumMutable(arr);
        System.out.println(rangeSumMutable.rangeSum(0, 2));
        rangeSumMutable.update(1, 10);
        System.out.println(rangeSumMutable.rangeSum(0, 2));
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end)
            root.sum = nums[start];
        else {
            int mid = start + (end - start) / 2;
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    public void update(int position, int val) {
        update(root, position, val);
    }

    public int rangeSum(int start, int end) {
        return rangeSum(root, start, end);
    }

    private int rangeSum(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end)
            return root.sum;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid)
                return rangeSum(root.left, start, end);
            if (start >= mid + 1)
                return rangeSum(root.right, start, end);
            else
                return rangeSum(root.left, start, mid) + rangeSum(root.right, mid + 1, end);
        }
    }

    private void update(SegmentTreeNode root, int position, int val) {
        if (root.start == root.end)
            root.sum = val;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (position <= mid)
                update(root.left, position, val);
            else update(root.right, position, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    private static class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
}
