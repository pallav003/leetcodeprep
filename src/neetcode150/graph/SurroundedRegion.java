package neetcode150.graph;

/**
 * Surrounded Regions
 * You are given a 2-D matrix board containing 'X' and 'O' characters.
 * <p>
 * If a continous, four-directionally connected group of 'O's is surrounded by 'X's, it is considered to be surrounded.
 * <p>
 * Change all surrounded regions of 'O's to 'X's and do so in-place by modifying the input board.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","O","O","X"],
 * ["X","X","X","O"]
 * ]
 * <p>
 * Output: [
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","O"]
 * ]
 * Explanation: Note that regions that are on the border are not considered surrounded regions.
 * <p>
 * Constraints:
 * <p>
 * 1 <= board.length, board[i].length <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegion {
    public void solve(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int i = 0; i < rowSize; i++) {
            if (board[i][0] == 'O') DFS(board, i, 0);// first column
            if (board[i][colSize - 1] == 'O') DFS(board, i, colSize - 1);// last column
        }
        for (int j = 0; j < colSize; j++) {
            if (board[0][j] == 'O') DFS(board, 0, j);//first row
            if (board[rowSize - 1][j] == 'O') DFS(board, rowSize - 1, j);
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    private void DFS(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        DFS(board, row + 1, col);
        DFS(board, row - 1, col);
        DFS(board, row, col + 1);
        DFS(board, row, col - 1);
    }
}
