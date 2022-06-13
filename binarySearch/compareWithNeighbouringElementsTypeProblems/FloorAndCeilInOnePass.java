package compareWithNeighbouringElementsTypeProblems;

import java.util.Arrays;

/**
 * find floor and ceil of an element in an array in one go
 */
public class FloorAndCeilInOnePass {

    public static int[] floorAndCeil(int[] arr, int target) {
        int n = arr.length;
        int[] ans = new int[2];
        ans[0] = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans[0] = mid;
                break;
            }
            if (arr[mid] < target) {
                if (ans[0] == -1) ans[0] = mid;
                else if (arr[ans[0]] < arr[mid]) ans[0] = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        if (arr[ans[0]] == target) ans[1] = ans[0];
        else ans[1] = ans[0] + 1;
        return new int[]{arr[ans[0]], arr[ans[1]]};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(floorAndCeil(new int[]{1, 2, 3, 4, 8, 10, 12, 19}, 11)));
        System.out.println(Integer.MIN_VALUE);
    }
}
