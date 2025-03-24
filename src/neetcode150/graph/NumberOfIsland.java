package neetcode150.graph;

import java.util.*;

/**
 * Number of Islands
 * Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.
 * <p>
 * An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["0","1","1","1","0"],
 * ["0","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","1"],
 * ["1","1","0","0","1"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 4
 * Constraints:
 * <p>
 * 1 <= grid.length, grid[i].length <= 100
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        Set<String> visitedSet = new HashSet<>();
        int island = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1' && !visitedSet.contains(r + " " + c)) {
                    BFS(r, c, grid, visitedSet);
                    island++;
                }
            }
        }
        System.out.println(visitedSet);
        return island;
    }

    public static int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public void BFS(int row, int col, char[][] grid, Set<String> visited) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row, col));
        visited.add(row + " " + col);
        while (!queue.isEmpty()) {
            List<Integer> rowCol = queue.poll();
            for (int[] d : dir) {
                int newRow = d[0] + rowCol.get(0), newCol = d[1] + rowCol.get(1);
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length
                        && newCol < grid[0].length && grid[newRow][newCol] == '1'
                        && !visited.contains(newRow + " " + newCol)) {
                    queue.add(Arrays.asList(newRow, newCol));
                    visited.add(newRow + " " + newCol);
                }

            }
        }

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'1', '0', '0', '0', '0'}
        };

        System.out.println("Number of islands (BFS): " + new NumberOfIsland().numIslands(grid)); // Output: 3
    }
}
