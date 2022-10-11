package Arrays.MyCalender;

import java.util.Map;
import java.util.TreeMap;

/**
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause<br>
 * a triple booking.
 * <br>
 * A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all <br>
 * the three events.).
 * <br>
 * The event can be represented as a pair of integers start and end that represents a booking on the half-open<br>
 * interval [start, end), the range of real numbers x such that start <= x < end.
 * <br>
 * Implement the MyCalendarTwo class:
 * <br>
 * MyCalendarTwo() Initializes the calendar object.<br>
 * <code>boolean book(int start, int end)</code> Returns true if the event can be added to the calendar <br>
 * successfully without causing a triple booking.
 * Otherwise, return false and do not add the event to the calendar.
 * <br>
 * <br>
 * <code>
 * Input
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * Output
 * [null, true, true, true, false, true, true]
 * <br>
 * Explanation
 * MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
 * myCalendarTwo.book(10, 20); // return True, The event can be booked.
 * myCalendarTwo.book(50, 60); // return True, The event can be booked.
 * myCalendarTwo.book(10, 40); // return True, The event can be double booked.
 * myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
 * myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already
 * double booked.
 * myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked
 * with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 * </code>
 */
public class Two {
    private static Map<Integer, Integer> bookings = new TreeMap<>();

    public static boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1); // new event started
        bookings.put(end, bookings.getOrDefault(end, 0) - 1); // new event ended
        int max = 0, curMax = 0;
        for (int value : bookings.values()) {
            max = Math.max(max, curMax += value);
        }
        if (max < 3)
            // less than 3 overlapping, so we can add the booking
            return true;
        // since we got 3 or more overlapping, we can't add the booking, so let's remove the booking we added
        bookings.put(start, bookings.get(start) - 1);
        // removing the 0 events, makes our search for finding max a bit quicker
        if (bookings.get(start) == 0) bookings.remove(start);
        bookings.put(end, bookings.get(end) + 1);
        if (bookings.get(end) == 0) bookings.remove(end);
        return false;
    }
}
