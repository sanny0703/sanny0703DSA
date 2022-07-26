package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.
 * <p>
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * <p>
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * <p>
 * Follow up:
 * Could you do better than O(n2)?
 * <p>
 * Hint:
 * Find the smallest and largest x-value for all points.
 * If there is a line then it should be at y = (minX + maxX) / 2.
 * For each point, make sure that it has a reflected point in the opposite side.
 */
public class LineReflection {
    public static boolean isReflected(int[][] points) {
        /**
         * As mentioned in the hint find minX and maxX, if there is a line ,it has to be at (minX+maxX)/2
         * we just have to find,if there is a reflected point for each point,that means
         * for each point(x,y) and it's reflection (x`,y`),their mid should be (minX+maxX)/2
         * (x+x`)/2 = (minX+maxX)/2
         * x+x` = minX+maxX
         * x` = minX+maxX-x, just make sure we have this point for each and every point in the points
         */
        Set<String> set = new HashSet<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
            minX = Math.min(point[0], minX);
            maxX = Math.max(point[0], maxX);
        }
        int mid = minX + maxX;
        for (int[] point : points)
            if (!set.contains((mid - point[0]) + "," + point[1])) return false;
        return true;
    }
}
