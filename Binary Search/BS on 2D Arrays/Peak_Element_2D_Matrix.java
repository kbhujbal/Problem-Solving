public class Peak_Element_2D_Matrix{
    public static void main(String[] args) {
        boolean found = false;
        int[][] matrix = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = m - 1;

        while (low <= high) { 
            int mid = (low + high)/2;

            int rowIdx = maxElementIndex(matrix, n, mid);

            int left = (mid - 1 >= 0) ? matrix[rowIdx][mid - 1] : -1;
            int right = (mid + 1 < m) ? matrix[rowIdx][mid + 1] : -1;

            if (matrix[rowIdx][mid] > left && matrix[rowIdx][mid] > right) {
                System.out.println("Peak Element found at: " + rowIdx + ", " + mid);
                found = true;
                break;
            }
            else if (matrix[rowIdx][mid] < left) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }

    private static int maxElementIndex(int[][] matrix, int n, int mid){
        int maxValue = 0;
        int index = 0;

        for(int i = 0; i < n; i++){
            if(matrix[i][mid] > maxValue){
                maxValue = matrix[i][mid];
                index = i;
            }
        }
        return index;
    }
}