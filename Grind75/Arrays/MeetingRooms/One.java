package Arrays.MeetingRooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 */
public class One {
    public static boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        intervals.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < n; i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        System.out.println(canAttendMeetings(intervals));
    }
}
