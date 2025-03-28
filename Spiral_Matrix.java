import java.util.ArrayList;

public class Spiral_Matrix{
    public static void main(String[] args) {
        int [][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        ArrayList <Integer> result = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0]. length - 1;

        while (top <= bottom && left <= right) { 
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        System.out.println(result);
    }
}