package neetcode150.graph;

/**
 * Max Area of Island
 * Solved
 * You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
 * <p>
 * An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is defined as the number of cells within the island.
 * <p>
 * Return the maximum area of an island in grid. If no island exists, return 0.
 * <p>
 * Example 1:Input: grid = [
 * [0,1,1,0,1],
 * [1,0,1,0,1],
 * [0,1,1,0,1],
 * [0,1,0,0,1]
 * ]
 * <p>
 * Output: 6
 * Explanation: 1's cannot be connected diagonally, so the maximum area of the island is 6.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int area = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, DFS(i, j, grid));
                }
            }
        }
        return area;
    }

    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int DFS(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length ||
                col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        int areacount = 1;
        grid[row][col] = 0;
        for (int[] dir : directions) {
            areacount += DFS(row + dir[0], col + dir[1], grid);
        }
        return areacount;

    }
}
