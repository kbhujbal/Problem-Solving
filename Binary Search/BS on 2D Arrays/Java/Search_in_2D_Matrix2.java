public class Search_in_2D_Matrix2{
    public static void main(String[] args) {
        boolean found = false;
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        int target = 14;
        int n = matrix.length;   // rows
        int m = matrix[0].length;   // columns

        int low = 0, high = (n*m) - 1;

        while (low <= high) { 
            int mid = (low + high)/2;

            int row = mid/m;
            int column = mid%m;

            if (matrix[row][column] == target) {
                System.out.println("Element found at: " + row + ", " + column);
                found = true;
                break;
            }
            else if (matrix[row][column] < target) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }
}