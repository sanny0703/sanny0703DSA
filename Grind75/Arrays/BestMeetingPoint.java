package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  A group of two or more people wants to meet and minimize the total travel distance.
 *  You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 *  The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 *  For example, given three people living at (0,0), (0,4), and (2,2):
 *
 *  1 - 0 - 0 - 0 - 1
 *  |   |   |   |   |
 *  0 - 0 - 0 - 0 - 0
 *  |   |   |   |   |
 *  0 - 0 - 1 - 0 - 0
 *
 *  The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 *
 *  Hint:
 *  Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 *
 *  Dx = |x1-x|+|x2-x|+|x3-x|
 *  Dy = |y1-y|+|y2-y|+|y3-y|
 *  these are minimum only when x and y are their respective medians
 */
public class BestMeetingPoint {
    public static int minDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        List<Integer> vertical = new ArrayList<>();
        List<Integer> horizontal = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vertical.add(j);
                    horizontal.add(i);
                }
            }
        }
        Collections.sort(vertical);
        Collections.sort(horizontal);
        int verticalMedian = vertical.get(vertical.size() / 2);
        int horizontalMedian = horizontal.get(horizontal.size() / 2);
        int distance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    distance += Math.abs(i - horizontalMedian) + Math.abs(j - verticalMedian);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(minDistance(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
    }
}
