package Arrays.MeetingRooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.)
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 */
public class Two {
    public static int minRoomsRequired(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n], end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0, res = 0;
        int startIndex = 0, endIndex = 0;
        while (startIndex < n) {
            if (start[startIndex] < end[endIndex]) {
                count++;
                startIndex++;
            } else {
                count--;
                endIndex++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        System.out.println(minRoomsRequired(intervals));
    }

}
