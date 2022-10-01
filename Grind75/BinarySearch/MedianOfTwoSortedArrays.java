package BinarySearch;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {
    //using merge technique
    //tc:O(n/2) sc:O(n/2)
    public static double medianNaive(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, s = nums1.length + nums2.length;
        int[] sorted = new int[s];
        int i = 0, j = 0, k = 0, mid = s / 2;
        while (k < s) {
            if (i < n && j < m) {
                if (nums1[i] < nums2[j]) {
                    sorted[k] = nums1[i];
                    i++;
                } else {
                    sorted[k] = nums2[j];
                    j++;
                }
            } else if (i < n) {
                sorted[k] = nums1[i];
                i++;
            } else {
                sorted[k] = nums2[j];
                j++;
            }
            k++;
            if (k > mid) { // if k passes mid,the just calculate median
                return (sorted[(s - 1) / 2] + sorted[s / 2]) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * Key points:
     * <p>
     * We want to make two cuts, separating nums1 into [. . . . L1 | R1 . . . ] and nums2 into [. . . . L2 | R2 . . . ] respectively, so that [. . . . L1] + [. . . . L2] has equal number of elements as [R1 . . . ] + [R2 . . . ].
     * Our goal is to find such cutting positions that give us the median values.
     * For an array of length N, there are 2*N + 1 different cutting positions.
     * Cutting on a gap is simple. Cutting on a number of means both left half and right half get the number.
     * With two arrays, a valid cutting position that gives the median can be ANY cutting position of the shorter array. This is not true for the longer array.
     * Therefore, we always cut the shorter array, and then calculate the cutting position of longer array directly(by using the fact that each half has the same number of cutting positions). We want to make nums1 always point to the shorter array for convenience.
     * Using binary search, If L1 > R2, we know current cutting position is incorrect. A valid cutting position for median should be on the left half of nums1.
     * If L2 > R1, we know current cutting position is incorrect. A valid cutting position for median should be on the right half of nums1.
     * if L1 < R2 and L2 < R1, we are good. median = (max(L1, L2) + min(R1, R2)) / 2
     */
    public static double median(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return median(nums2, nums1);
        // if we add some #'s in between each number in array, no matter whether N is even or odd
        // we always get 2*N+1 elements
        int lo = 0, hi = 2 * n1;
        while (lo <= hi) {
            int mid1 = (hi + lo) / 2;
            //after adding #'s to both arrays ,we are left with 2*N1+1 + 2*N2+2 elements  i.e. exactly N1+N2 elements for each side
            //of the cut


            // if cut1 is made at k the cut2 = N1+N2-k
            int mid2 = n1 + n2 - mid1;
            //l1: left element of the cut in nums1
            // l2: left element of the cut in nums2
            //r1,r2: right elements
            double l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double r1 = mid1 == 2 * n1 ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double r2 = mid2 == 2 * n2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
            // we know that l1<=r1 and l2<= r2 since both arrays are sorted
            // no we have to make sure l1<= r2 and l2<= r1 to find the right cut
            if (l1 > r2) hi = mid1 - 1;// if l1 is higher go to smaller side
            else if (l2 > r1) lo = mid1 + 1;
            else return (Math.min(r1, r2) + Math.max(l1, l2)) / 2;

        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(median(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(median(new int[0], new int[]{0}));
    }
}
