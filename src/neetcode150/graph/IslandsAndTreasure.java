package neetcode150.graph;

/**
 * Islands and Treasure
 * You are given a
 * m
 * ×
 * n
 * m×n 2D grid initialized with these three possible values:
 * <p>
 * -1 - A water cell that can not be traversed.
 * 0 - A treasure chest.
 * INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
 * Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest than the value should remain INF.
 * <p>
 * Assume the grid can only be traversed up, down, left, or right.
 * <p>
 * Modify the grid in-place.
 * <p>
 * Example 1:
 * <p>
 * Input: [
 * [2147483647,-1,0,2147483647],
 * [2147483647,2147483647,2147483647,-1],
 * [2147483647,-1,2147483647,-1],
 * [0,-1,2147483647,2147483647]
 * ]
 * <p>
 * Output: [
 * [3,-1,0,1],
 * [2,2,1,-1],
 * [1,-1,2,-1],
 * [0,-1,3,4]
 * ]
 * Example 2:
 * <p>
 * Input: [
 * [0,-1],
 * [2147483647,2147483647]
 * ]
 * <p>
 * Output: [
 * [0,-1],
 * [1,2]
 * ]
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] is one of {-1, 0, 2147483647}
 */
public class IslandsAndTreasure {
    public void islandsAndTreasure(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (grid[r][c] == 0) {
                    DFS(r, c, grid, 0);
                }
            }
        }
    }

    public static int[][] directions ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void DFS(int row, int col, int[][] grid, int distance) {
        if (row < 0 || col < 0 || row >= grid.length
                || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] < distance) {
            return;
        }
        grid[row][col] = distance;


        for (int[] dir : directions) {
            DFS(row + dir[0], col + dir[1], grid, distance+1);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        IslandsAndTreasure islandsAndTreasure = new IslandsAndTreasure();
        islandsAndTreasure.islandsAndTreasure(grid);
        for (int [] data : grid) {
            for (int i : data) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
