package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * <p>
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */
public class FloodFill {
    //DFS O(M) M: all cells in the image
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length, m = image[0].length;
        if (image[sr][sc] != newColor) dfs(image, image[sr][sc], newColor, sr, sc, n, m);
        return image;
    }

    public static void dfs(int[][] image, int color, int newColor, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || image[x][y] != color) return;
        image[x][y] = newColor;
        dfs(image, color, newColor, x + 1, y, n, m);
        dfs(image, color, newColor, x - 1, y, n, m);
        dfs(image, color, newColor, x, y + 1, n, m);
        dfs(image, color, newColor, x, y - 1, n, m);
    }

    //BFS
    public static int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int n = image.length, m = image[0].length;
        int sourceColor = image[sr][sc];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (isValid(image, x + 1, y, n, m, sourceColor)) {
                queue.offer(new int[]{x + 1, y});
                image[x + 1][y] = newColor;
            }
            if (isValid(image, x - 1, y, n, m, sourceColor)) {
                queue.offer(new int[]{x - 1, y});
                image[x - 1][y] = newColor;
            }
            if (isValid(image, x, y + 1, n, m, sourceColor)) {
                queue.offer(new int[]{x, y + 1});
                image[x][y + 1] = newColor;
            }
            if (isValid(image, x, y - 1, n, m, sourceColor)) {
                queue.offer(new int[]{x, y - 1});
                image[x][y - 1] = newColor;
            }
        }
        return image;
    }

    public static boolean isValid(int[][] image, int x, int y, int n, int m, int color) {
        return x >= 0 && x < n && y >= 0 && y < m && image[x][y] == color;
    }

}
