package Arrays;

import Arrays.MeetingRooms.Interval;

import java.util.*;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 * Each employee has a list of non-overlappingIntervals, and these intervals are in sorted order.
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 * <p>
 * Input:
 * schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * <p>
 * Output:
 * [[3,4]]
 * <p>
 * Explanation:
 * <p>
 * There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 */
public class EmployeeFreeTime {
    public static List<Interval> getFreeTime(List<List<Interval>> intervals) {
        List<Interval> ans = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();
        intervals.forEach(timeLine::addAll);
        timeLine.sort(Comparator.comparingInt(a -> a.start));
        Interval temp = timeLine.get(0);
        for (Interval interval : timeLine) {
            if (temp.end < interval.start) {
                ans.add(new Interval(temp.end, interval.start));
                temp = interval;
            } else temp = temp.end < interval.end ? interval : temp;

        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Interval>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        intervals.add(Collections.singletonList(new Interval(1, 3)));
        intervals.add(Collections.singletonList(new Interval(4, 10)));
        System.out.println(getFreeTime(intervals));

    }
}
