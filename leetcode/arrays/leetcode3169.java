package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode3169 {
    public static void main(String[] args) {
        
    }

    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(row -> row[0]));
        int meetingDays = 0;
        for (int[] row : meetings) {
            System.out.println(Arrays.toString(row));
        }
        int[] prev = meetings[0];
        for (int i = 1; i < n; i++) {
            if (prev[1] >= meetings[i][0]) {
                prev[1] = Math.max(prev[1], meetings[i][1]);
            } else {
                meetingDays += (prev[1] - prev[0]) + 1;
                prev = meetings[i];
            }
        }
        meetingDays += (prev[1] - prev[0]) + 1;
        
        // int meetingDays = 0;
        // for(int[] meeting:list){
        //     meetingDays+= (meeting[1]-meeting[0])+1;
        // }
        return days-meetingDays;
    }
}
