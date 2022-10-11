package Arrays.MyCalender;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a
 * double booking.
 * <br>
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both
 * events.).
 * <br>
 * The event can be represented as a pair of integers start and end that represents a booking on the half-open interval
 * [start, end), the range of real numbers x such that start <= x < end.
 * <br>
 * Implement the MyCalendar class:
 * <br>
 * MyCalendar() Initializes the calendar object.
 * boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing
 * a double booking. Otherwise, return false and do not add the event to the calendar.
 * <br>
 * <br>
 * <code>
 * Input <br>
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * Output<br>
 * [null, true, false, true]
 * <br>
 * Explanation<br>
 * MyCalendar myCalendar = new MyCalendar();<br>
 * myCalendar.book(10, 20); // return True<br>
 * myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.<br>
 * myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20,<br>
 * but not including 20.
 * </code>
 */
public class One {
    private static List<int[]> bookingsList = new ArrayList<>();
    private static TreeSet<int[]> bookings = new TreeSet<>(Comparator.comparingInt(a -> a[0]));

    public static boolean bruteForce(int start, int end) {
        // just check each and every booking for overlapping
        // O(n^2) for n bookings
        for (int[] booking : bookingsList) {
            if (Math.max(booking[0], start) < Math.min(booking[1], end))
                return false;
        }
        bookingsList.add(new int[]{start, end});
        return true;
    }

    public static boolean optimised(int start, int end) {
        // O(n log(n)) log(n) for ceil and floor
        int[] booking = new int[]{start, end};
        int[] floor = bookings.floor(booking), ceil = bookings.ceiling(booking);
        if (floor != null && floor[1] > booking[0]) return false;
        if (ceil != null && ceil[0] < booking[1]) return false;
        bookings.add(booking);
        return true;
    }

    public static void main(String[] args) {
        System.out.println("===== brute force method =======");
        System.out.println(bruteForce(10, 20));
        System.out.println(bruteForce(15, 25));
        System.out.println(bruteForce(20, 30));
        System.out.println("====== efficient method=====");
        System.out.println(optimised(10, 20));
        System.out.println(optimised(15, 25));
        System.out.println(optimised(20, 30));
    }
}
