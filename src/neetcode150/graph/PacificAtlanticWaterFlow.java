package neetcode150.graph;

import java.util.*;

/**
 * Pacific Atlantic Water Flow
 * You are given a rectangular island heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The islands borders the Pacific Ocean from the top and left sides, and borders the Atlantic Ocean from the bottom and right sides.
 * <p>
 * Water can flow in four directions (up, down, left, or right) from a cell to a neighboring cell with height equal or lower. Water can also flow into the ocean from cells adjacent to the ocean.
 * <p>
 * Find all cells where water can flow from that cell to both the Pacific and Atlantic oceans. Return it as a 2D list where each element is a list [r, c] representing the row and column of the cell. You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: heights = [
 * [4,2,7,3,4],
 * [7,4,6,4,7],
 * [6,3,5,3,6]
 * ]
 * <p>
 * Output: [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]
 * Example 2:
 * <p>
 * Input: heights = [[1],[1]]
 * <p>
 * Output: [[0,0],[0,1]]
 * Constraints:
 * <p>
 * 1 <= heights.length, heights[r].length <= 100
 * 0 <= heights[r][c] <= 1000
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> outputList = new ArrayList<>();
        int rowSize = heights.length;
        int colSize = heights[0].length;
        boolean[][] pacificVisit = new boolean[rowSize][colSize];
        boolean[][] atlanticVisit = new boolean[rowSize][colSize];
        for (int i = 0; i < colSize; i++) {
            DFS(0, i, pacificVisit, heights);
            DFS(rowSize - 1, i, atlanticVisit, heights);
        }
        for (int i = 0; i < rowSize; i++) {
            DFS(i, 0, pacificVisit, heights);
            DFS(i, colSize - 1, atlanticVisit, heights);
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (pacificVisit[row][col] && atlanticVisit[row][col]) {
                    outputList.add(Arrays.asList(row, col));
                }
            }
        }
        return outputList;

    }

    public int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void DFS(int row, int col, boolean[][] visit, int[][] heights) {
        // in dfs keep new row column as >= since we are starting from the ocean not from the
        // middle of the ocean
        visit[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
                    && heights[newRow][newCol] >= heights[row][col] && !visit[newRow][newCol]) {
                DFS(newRow, newCol, visit, heights);
            }
        }
    }
}
