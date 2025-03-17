package neetcode150.binaryseach;

/**
 * Search a 2D Matrix
 * You are given an m x n 2-D integer array matrix and an integer target.
 * <p>
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 * <p>
 * Can you write a solution that runs in O(log(m * n)) time?
 * <p>
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 * <p>
 * Output: true
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int targetRow = Integer.MIN_VALUE;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                targetRow = mid;
                break;
            } else if (target > matrix[mid][n - 1]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        if (targetRow == Integer.MIN_VALUE) {
            return false;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SearchIn2DMatrix search = new SearchIn2DMatrix();
        System.out.println(search.searchMatrix(new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}}, 15));
        System.out.println(search.searchMatrix(new int[][]{{1}}, 1));

    }
}
