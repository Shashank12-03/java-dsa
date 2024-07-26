package string;

import java.util.*;



public class time {
    public static void main(String[] args) {
        System.out.println(timing(new String[]{"12:15PM-02:00PM", "09:00AM-10:00AM","10:30AM-12:00PM"}));
    }

    public static String timing(String[] input){
        int[][] store = new int[input.length][2];
        for (int i = 0; i < store.length; i++) {
            int startTime = strToTime(input[i].substring(0, 7).toCharArray());
            int endTime = strToTime(input[i].substring(8, 15).toCharArray());
            store[i][0] = startTime;
            store[i][1] = endTime;
        }
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(store[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        Arrays.sort(store, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // Compare based on the first element of each sub-array
                return Integer.compare(a[0], b[0]);
            }
        });
        System.out.println();
        // Printing the sorted array
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(store[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < store.length;i++){
            max = Math.max(max, store[i][0]-store[i-1][1]);
        }
        System.out.println(max);
        int min = max%60;
        int hr = max/60;
        String ans = hr + ":" + min; 
        return ans;

    }

    private static int strToTime(char[] charArray) {
        int hr = (charArray[0]-'0')*10  + (charArray[1]-'0');
        int min = (charArray[3]-'0')*10  + (charArray[4]-'0');
        if (hr ==12 && charArray[5]=='A'){
            hr -=12;
        }
        if (charArray[5]=='P' && hr !=12){
            hr+=12;
        }
        return hr*60 + min;
    }
}