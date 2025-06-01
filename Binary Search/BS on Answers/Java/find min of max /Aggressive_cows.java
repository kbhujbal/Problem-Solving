// There will be N stalls, with their co-ordinates given in the stalls array.
// We have to place C cows in the stalls such that the minimum distance between any two cows is maximum.

public class Aggressive_cows{
    public static void main(String[] args) {
        int[] stalls = {0, 4, 3, 7, 9, 10};
        int cows = 4;

        int low = 0, high = stalls[stalls.length - 1] - stalls[0];
        int ans = -1;

        while (low <= high) { 
            int mid = (low + high)/2;

            if (canWePlaceCows(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("Minimum distance at which cows can be placed is: " + ans);
    }

    public static boolean canWePlaceCows(int[] stalls, int cows, int minDist) {
        int cntCows = 1, last = stalls[0];

        for (int i = 0; i < stalls.length; i++) {
            if (stalls[i] - last >= minDist) {
                cntCows += 1;
                last = stalls[i];
            }
            if (cntCows == cows) {
                return true;
            }
        }
        return false;
    }
}