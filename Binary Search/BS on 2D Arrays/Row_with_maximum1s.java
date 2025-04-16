public class Row_with_maximum1s {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        int result = rowWithMax1s(matrix);
        System.out.println("Row with maximum 1s is: " + result);
    }
    
    public static int rowWithMax1s(int[][] matrix) {
        int maxOnes = 0;
        int rowIndex = -1;
        int cols = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            int firstOneIndex = lowerBound(matrix[i], 1);
            int onesCount = cols - firstOneIndex;

            if (onesCount > maxOnes) {
                maxOnes = onesCount;
                rowIndex = i;
            }
        }

        return rowIndex;
    }

    public static int lowerBound(int[] row, int target) {
        int low = 0, high = row.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
