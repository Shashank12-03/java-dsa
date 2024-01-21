package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode57 {
    public static void main(String[] args) {
        int[][] arr={};
        int[][] ans=insert(arr,new int[]{5,7});
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List <int[]> res= new ArrayList<>(); 
        if(intervals.length==0 || intervals==null){
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }
        else{
            int[][] newArray = new int[intervals.length + 1][intervals[0].length];

        // Copy existing rows to the new array
            for (int i = 0; i < intervals.length; i++) {
                System.arraycopy(intervals[i], 0, newArray[i], 0, intervals[i].length);
            }

            // Add the new row
            newArray[newArray.length - 1] = newInterval;
            return merge(newArray, res);
        }
    }
    static int[][] merge(int[][] intervals,List <int[]> res) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start= intervals[0][0];
        int end= intervals[0][1];
        for(int[] arr:intervals){
            if(arr[0]<=end){
                end=Math.max(end, arr[1]);
            }
            else{
                res.add(new int[]{start,end});
                start=arr[0];
                end=arr[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}
