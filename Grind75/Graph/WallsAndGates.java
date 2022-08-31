package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 You are given a m x n 2D grid initialized with these three possible values.

 -1     - A wall or an obstacle.
 0      - A gate.
 INF    - Infinity means an empty room.
 We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that
 the distance to a gate is less than 2147483647.

 Fill each empty room with the distance to its nearest gate.
 If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:

 INF    -1      0       INF
 INF    INF     INF     -1
 INF    -1      INF     -1
 0      -1      INF     INF

 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 */
public class WallsAndGates {
    public static void nearestGate(int[][] grid){
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int dist =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            dist++;
            while (size-->0){
                int[] cur = queue.poll();
                for(int[] direction:directions){
                    int x = cur[0]+direction[0];
                    int y = cur[1]+direction[1];
                    if(x >=0 && x<n && y>=0 && y<m && grid[x][y]!=-1 && grid[x][y]!=0){
                        if(grid[x][y]>dist){
                            grid[x][y]=dist;
                            queue.offer(new int[]{x,y});
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] grid = {{INF,-1,0,INF},{INF,INF,INF,-1},{INF,-1,INF,-1},{0,-1,INF,INF}};
        nearestGate(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
