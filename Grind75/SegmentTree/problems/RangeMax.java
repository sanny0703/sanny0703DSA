package SegmentTree.problems;

/**
 * Given an arr with integers and Q queries and update methods, return max of a given range for each query
 */
public class RangeMax {
    private final SegmentTreeNode root;

    public RangeMax(int[] arr) {
        root = buildTree(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -8, -3, 5, -10};
        RangeMax rangeMax = new RangeMax(arr);
        System.out.println(rangeMax.rangeMax(0, 3));
        rangeMax.update(3, 8);
        System.out.println(rangeMax.rangeMax(0, 3));
    }

    private SegmentTreeNode buildTree(int[] arr, int start, int end) {
        if (start > end)
            return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end)
            root.max = arr[start];
        else {
            int mid = start + (end - start) / 2;
            root.left = buildTree(arr, start, mid);
            root.right = buildTree(arr, mid + 1, end);
            root.max = Math.max(root.left.max, root.right.max);
        }
        return root;
    }

    public int rangeMax(int start, int end) {
        return rangeMax(root, start, end);
    }

    private int rangeMax(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end)
            return root.max;
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid)
            return rangeMax(root.left, start, end);
        if (start >= mid + 1)
            return rangeMax(root.right, start, end);
        return Math.max(rangeMax(root.left, start, mid), rangeMax(root.right, mid + 1, end));
    }

    public void update(int position, int value) {
        update(root, position, value);
    }

    private void update(SegmentTreeNode root, int position, int value) {
        if (root.start == root.end)
            root.max = value;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (position <= mid)
                update(root.left, position, value);
            else update(root.right, position, value);
            root.max = Math.max(root.left.max, root.right.max);
        }
    }

    private static class SegmentTreeNode {
        int max, start, end;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            max = Integer.MIN_VALUE;
            left = right = null;
        }
    }
}
