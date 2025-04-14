import java.util.Arrays;

public class CountDaysWithoutMeetings {

    public static int countDaysWithoutMeetings(int days, int[][] meetings) {
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int freeDays = 0;
        int prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > prevEnd + 1) {
                freeDays += (start - prevEnd - 1);
            }
            prevEnd = Math.max(prevEnd, end);
        }

        if (prevEnd < days) {
            freeDays += (days - prevEnd);
        }
        return freeDays;
    }

    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};

        int result = countDaysWithoutMeetings(days, meetings);
        System.out.println("Output: " + result);  
    }
}
