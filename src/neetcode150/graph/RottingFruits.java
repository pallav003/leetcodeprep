package neetcode150.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Rotting Fruit
 * You are given a 2-D matrix grid. Each cell can have one of three possible values:
 * <p>
 * 0 representing an empty cell
 * 1 representing a fresh fruit
 * 2 representing a rotten fruit
 * Every minute, if a fresh fruit is horizontally or vertically adjacent
 * to a rotten fruit, then the fresh fruit also becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until there are
 * zero fresh fruits remaining. If this state is impossible within the grid, return -1.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,0],[0,1,1],[0,1,2]]
 * <p>
 * Output: 4
 * Example 2:
 * <p>
 * Input: grid = [[1,0,1],[0,2,0],[1,0,1]]
 * <p>
 * Output: -1
 * Constraints:
 * <p>
 * 1 <= grid.length, grid[i].length <= 10
 */
public class RottingFruits {
    public int[][] directions =
            new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {

        int output = 0;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 2) {
                    queue.add(new int[]{row, column});
                } else if (grid[row][column] == 1) {
                    freshCount++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] polled = queue.poll();
                for (int[] dir : directions) {
                    int newRow = polled[0] + dir[0], newCol = polled[1] + dir[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        queue.add(new int[]{newRow, newCol});
                        rotted = true;
                    }
                }
            }
            if (rotted) output++;

        }
        return freshCount > 0 ? -1 : output;
    }

}
