package arrays;

import java.util.*;

public class leetcode539 {
    public static void main(String[] args) {
        leetcode539 sol = new leetcode539();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(sol.findMinDifference(list));
    }
    public int findMinDifference(List<String> timePoints) {
        int[] temp = new int[timePoints.size()];
        int i = 0;
        for (String time : timePoints) {
            // System.out.println(time.toCharArray());
            temp[i++] = getMinutes(time);
        }
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
        int min = 1440;
        for (int j = 1; j < temp.length; j++) {
            System.out.println(temp[j]-temp[j-1]);
            min = Math.min(min, temp[j]-temp[j-1]);
        }
        return min;
    }
    private int getMinutes(String time) {
        int hr = Integer.parseInt(time.substring(0, 2));
        System.out.println(hr);
        int min = Integer.parseInt(time.substring(3, 5));
        System.out.println(min);
        if (hr==0 && min==0) {
            return 1440;
        }
        return hr*60 + min;
    }
}
