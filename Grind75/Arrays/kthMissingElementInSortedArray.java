package Arrays;

/**
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
 * <p>
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 * <p>
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 */
public class kthMissingElementInSortedArray {
    public static int missing(int[] nums, int k) {
        int n = nums.length;
        // if no elements ,every element is missing starting from 1, jus return kth element which is k
        if (n == 0) return k;
        //if k > the largest element,then the range starts at nums[0] + K( we need kth missing)+n-1(are already present )
        if (k >= nums[n - 1]) return k + nums[0] + n - 1;
        // starting from nums[0] check if every element is present or not and if present decrease k
        int index = 1;
        int num = nums[0];
        while (index < n && k > 0) {
            num++;
            if (num == nums[index]) index++;
            else k--;
        }
        return k + num;
    }

    public static void main(String[] args) {
        System.out.println(missing(new int[]{6, 7, 8, 10, 14}, 4));
    }
}

