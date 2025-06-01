public class Search_in_2D_Matrix{
    public static void main(String[] args) {
        boolean found = false;
        int[][] matrix = {
            {3, 4, 7, 9},
            {12, 13, 16, 18},
            {20, 21, 23, 29}
        };

        int target = 23;
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