package Arrays.MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.The balloons are represented as a 2D integer array points
 * where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * <p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.A balloon with xstart and
 * xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * <p>
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * <p>
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 */
public class MinNumberOfArrowsToBurstBalloons {
    public static int minArrows(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrowCount = 1, // we start with1 because at least 1 arrow is required to break ballon
                arrowEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (arrowEnd >= points[i][0])
                continue;
            arrowCount++;
            arrowEnd = points[i][1];
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(minArrows(points));
    }
}
