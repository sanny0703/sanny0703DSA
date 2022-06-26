package Arrays.MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of
 * you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 */
public class NonOverlappingIntervals {
    public static int count(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0 // we will start with 0 because no overlapping at start
                , end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) count++; // since this interval hasn't ended yet , overlapping count increases
            else end = intervals[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(count(intervals));
    }
}
