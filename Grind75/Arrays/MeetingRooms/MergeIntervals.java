package Arrays.MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty() || list.getLast()[1] < interval[0])
                list.add(interval);
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        int[][] int2 = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(Arrays.deepToString(merge(int2)));
    }
}
