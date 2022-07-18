package Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 * <p>
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * <p>
 * Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.
 * constrains: |x|+|y| <= 300
 * <p>
 * <p>
 * Approach++++
 * <p>
 * the idea is to only check on positive side,because even if it is on negative side ,the steps needed will be same
 */
public class MinimumKnightMoves {
    public static int minMoves(int x, int y) {
        x = Math.abs(x); // we will be moving in positive coordinates only
        y = Math.abs(y);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0}); // source point
        // knight can move to one of the  8 positions in one go
        int[][] dir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        int countSteps = 0;
        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int curX = cur[0], curY = cur[1];
                if (curX == x && curY == y) return countSteps;
                for (int[] d : dir) {
                    int newX = curX + d[0], newY = curY + d[1];
                    if (newX >= -1 && newY >= -1 && !visited.contains(newX + "," + newY)) {
                        visited.add(newX + "," + newY);
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            countSteps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(5, 5));
    }
}
