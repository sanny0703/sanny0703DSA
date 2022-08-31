package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.
 * <br>
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <br>
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 */
public class BinaryTreeWithFactors {
    public static int countTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long res = 0L, mod = (long) 1e9 + 7;
        Map<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // factor of itself(only root case [2],[4])
            dp.put(arr[i], 1L);// L indicates long just like f for float
            for (int j = 0; j < i; j++) {
                // we need to consider only factors of a number to obtain product
                if (arr[i] % arr[j] == 0) {
                    // dp.getOrDefault takes care of no possible product case by repeatedly just putting 1 for arr[i]
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault((arr[i] / arr[j]), 0L)) % mod);
                }
            }
            res = (res + dp.get(arr[i])) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(countTrees(new int[]{2, 4}));
        System.out.println(countTrees(new int[]{2, 4, 5, 10}));
    }
}
