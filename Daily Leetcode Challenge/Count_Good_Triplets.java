public class Count_Good_Triplets {

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Sample input
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7, b = 2, c = 3;

        int result = countGoodTriplets(arr, a, b, c);
        System.out.println("Number of good triplets: " + result);
    }
}
