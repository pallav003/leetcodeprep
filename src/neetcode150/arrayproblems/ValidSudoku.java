package neetcode150.arrayproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Sudoku
 * Solved
 * You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
 *
 * Each row must contain the digits 1-9 without duplicates.
 * Each column must contain the digits 1-9 without duplicates.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
 * Return true if the Sudoku board is valid, otherwise return false
 *
 * Note: A board does not need to be full or be solvable to be valid.
 *
 * Example 1:
 *
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 *  ["4",".",".","5",".",".",".",".","."],
 *  [".","9","8",".",".",".",".",".","3"],
 *  ["5",".",".",".","6",".",".",".","4"],
 *  [".",".",".","8",".","3",".",".","5"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".",".",".",".",".",".","2",".","."],
 *  [".",".",".","4","1","9",".",".","8"],
 *  [".",".",".",".","8",".",".","7","9"]]
 *
 * Output: true
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j]!= '.' && (!set.add(i + "row in " + board[i][j])
                        || !set.add(j + "column in " + board[i][j])
                        || !set.add(i / 3 + " " + j / 3 + " block" + board[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(sudoku));
        ;
        char[][] secondSudoku =
               {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(validSudoku.isValidSudoku(secondSudoku));
        ;
    }
}
