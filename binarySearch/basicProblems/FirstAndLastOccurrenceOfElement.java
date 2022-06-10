package basicProblems;

import java.util.Arrays;

/**
 * find the first and last occurrence of an element in a sorted array
 */
public class FirstAndLastOccurrenceOfElement {
    public static int[] search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        int[] res = new int[]{-1, -1};
        if (ans == -1)
            return res;
        int i = ans;
        while (i >= 0 && arr[i] == target) {
            res[0] = i;
            i--;
        }
        i = ans;
        while (i < arr.length && arr[i] == target) {
            res[1] = i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 4, 4, 5};
        //{3,7}
        System.out.println(Arrays.toString(search(arr, 4)));

    }
}
