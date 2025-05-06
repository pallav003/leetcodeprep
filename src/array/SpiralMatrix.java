package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                output.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                output.add(matrix[i][right]);
            }
            right--;
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    output.add(matrix[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    output.add(matrix[i][left]);
                }
                left++;
            }


        }
        return output;
    }
}
