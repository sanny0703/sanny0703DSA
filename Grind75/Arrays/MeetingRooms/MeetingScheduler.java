package Arrays.MeetingRooms;

import java.util.*;

/**
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
 * <p>
 * If there is no common time slot that satisfies the requirements, return an empty array.
 * <p>
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 * <p>
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 * <p>
 * <p>
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * <p>
 * Output: [60,68]
 * <p>
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * <p>
 * Output: []
 */
public class MeetingScheduler {
    public static List<Integer> schedule(int[][] slots1, int[][] slots2, int duration) {
        // sort the slots based on start time(because we have to book the earliest possible slot)
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] slot : slots1) {
            //we only need those slots,whose duration is at least the required duration
            if (slot[1] - slot[0] >= duration) queue.offer(slot);
        }
        for (int[] slot : slots2) {
            //we only need those slots,whose duration is at least the required duration
            if (slot[1] - slot[0] >= duration) queue.offer(slot);
        }
        while (!queue.isEmpty()) {
            int[] lastSlot = queue.poll();
            int[] currentSlot = queue.peek();// this handles the case where even both slots(current and last) have same start time
            if (lastSlot[1] >= currentSlot[0] + duration)
                return Arrays.asList(currentSlot[0], currentSlot[0] + duration);
        }
        return Arrays.asList();

    }

    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}}, slots2 = {{0, 15}, {60, 70}};
        System.out.println(schedule(slots1, slots2, 8));
    }
}
