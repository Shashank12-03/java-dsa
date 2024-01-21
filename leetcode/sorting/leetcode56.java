package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class leetcode56 {
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        int[][] ans=merge(arr);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
    static int[][] merge(int[][] intervals) {
        List <int[]> res= new ArrayList<>(); 
        if(intervals.length==0 || intervals==null){
            return res.toArray(new int[0][]);
        }
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
