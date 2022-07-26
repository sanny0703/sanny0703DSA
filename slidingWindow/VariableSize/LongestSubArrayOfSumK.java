package VariableSize;

/**
 * Given an array containing N positive integers and an integer K. <br>
 * Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.<br>
 * <br>
 * <code>For Input:<br>
 * 1<br>
 * 7 5<br>
 * 4 1 1 1 2 3 5<br>
 * your output is: <br>
 * 4 . </code>
 */
public class LongestSubArrayOfSumK {
    // this approach won't work for negative numbers
    public static int longestSubArray(int[] arr, int k) {
        int sum = 0;
        int i = 0, j = 0;
        int ans = 0; // variable to store longest subArray length
        while (j < arr.length) {
            sum += arr[j];
            if (sum > k) { // we are doing this first cause after removing prev elements we might hit our window
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
            }
            // this will take care of hit and after removing prev elements hit
            if (sum == k) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //4{1,1,1,2}
        System.out.println(longestSubArray(new int[]{4, 1, 1, 1, 2, 3, 5,}, 5));
        //5{10,33,34,65,89}
        System.out.println(longestSubArray(new int[]{2, 3, 4, 5, 3, 1, 9, 4, 5, 3, 2, 6, 7, 3, 9, 10, 33, 34, 65, 89, 34, 556, 7968, 454}, 231));
        System.out.println(longestSubArray(new int[]{1,-1,5,-2,3},3));
    }
}
