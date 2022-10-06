package SegmentTree.problems;

/**
 * Given an arr with integers and Q queries and update methods, return min of a given range for each query
 */
public class RangeMin {
    private final SegmentTreeNode root;

    public RangeMin(int[] arr) {
        root = buildTree(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -8, -3, 5, -10};
        RangeMin rangeMin = new RangeMin(arr);
        System.out.println(rangeMin.rangeMin(0, 3));
        rangeMin.update(3, 8);
        System.out.println(rangeMin.rangeMin(0, 3));
    }

    private SegmentTreeNode buildTree(int[] arr, int start, int end) {
        if (start > end)
            return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end)
            root.min = arr[start];
        else {
            int mid = start + (end - start) / 2;
            root.left = buildTree(arr, start, mid);
            root.right = buildTree(arr, mid + 1, end);
            root.min = Math.min(root.left.min, root.right.min);
        }
        return root;
    }

    public int rangeMin(int start, int end) {
        return rangeMin(root, start, end);
    }

    private int rangeMin(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end)
            return root.min;
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid)
            return rangeMin(root.left, start, end);
        if (start >= mid + 1)
            return rangeMin(root.right, start, end);
        return Math.min(rangeMin(root.left, start, mid), rangeMin(root.right, mid + 1, end));
    }

    public void update(int position, int value) {
        update(root, position, value);
    }

    private void update(SegmentTreeNode root, int position, int value) {
        if (root.start == root.end)
            root.min = value;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (position >= mid + 1)
                update(root.right, position, value);
            else update(root.left, position, value);
            root.min = Math.min(root.left.min, root.right.min);
        }
    }

    private static class SegmentTreeNode {
        int min, start, end;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
            left = right = null;
        }
    }
}
