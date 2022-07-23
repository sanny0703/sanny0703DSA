package Arrays;

/**
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * Example 1:
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * <p>
 * Example 2:
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * Note:
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 */
public class MinimumDominoRotationsForEqualRow {
    public static int greedyApproach(int[] tops, int[] bottoms) {
        int n = tops.length;
        int minRotations = check(tops[0], tops, bottoms, n);
        if (minRotations != -1 || tops[0] == bottoms[0]) return minRotations;
        else return check(bottoms[0], tops, bottoms, n);
    }

    public static int check(int k, int[] tops, int[] bottoms, int n) {
        int countTopRotations = 0, countBottomRotations = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != k && bottoms[i] != k) return -1;
            else if (tops[i] != k) countTopRotations++;
            else if (bottoms[i] != k) countBottomRotations++;
        }
        return Math.min(countBottomRotations, countTopRotations);
    }

    public static int countingApproach(int[] tops, int[] bottoms) {
        int[] countTops = new int[7], countBottoms = new int[7], countSame = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            countTops[tops[i]]++;
            countBottoms[bottoms[i]]++;
            if (tops[i] == bottoms[i]) countSame[tops[i]]++;
        }
        for (int i = 0; i < 7; i++) {
            if (countTops[i] + countBottoms[i] - countSame[i] == n) return n - Math.max(countBottoms[i], countTops[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(greedyApproach(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println(countingApproach(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
    }
}
