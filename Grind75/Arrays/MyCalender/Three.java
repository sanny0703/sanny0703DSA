package Arrays.MyCalender;

import java.util.Map;
import java.util.TreeMap;

/**
 * A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)
 * <br>
 * You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking between all the previous events.
 * <br>
 * Implement the MyCalendarThree class:
 * <br>
 * MyCalendarThree() Initializes the object.
 * int book(int start, int end) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.
 * <br>
 * <br>
 * <code>
 * Input
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * Output
 * [null, 1, 1, 2, 3, 3, 3]
 * <p>
 * Explanation
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
 * myCalendarThree.book(50, 60); // return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
 * myCalendarThree.book(10, 40); // return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2-booking.
 * myCalendarThree.book(5, 15); // return 3, The remaining events cause the maximum K-booking to be only a 3-booking.
 * myCalendarThree.book(5, 10); // return 3
 * myCalendarThree.book(25, 55); // return 3
 * </code>
 */
public class Three {
    private static Map<Integer, Integer> bookings = new TreeMap<>();

    public static int book(int start, int end) {
        // similar to MyCalendarTwo, we just have to return the max overlapping
        bookings.put(start, bookings.getOrDefault(start, 0) + 1); // add an event
        bookings.put(end, bookings.getOrDefault(end, 0) - 1); // remove an event
        int max = 0, curMax = 0;
        for (int value : bookings.values()) {
            max = Math.max(max, curMax += value);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(book(10, 20));
        System.out.println(book(50, 60));
        System.out.println(book(10, 40));
        System.out.println(book(5, 15));
        System.out.println(book(5, 10));
        System.out.println(book(25, 55));
    }

}
