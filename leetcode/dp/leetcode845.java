package dp;

import java.util.Arrays;

/**
 * leetcode845
 */
public class leetcode845 {
    public static void main(String[] args) {
        leetcode845 sol = new leetcode845();
        System.out.println(sol.longestMountain(new int[]{3,2}));
    }

    public int longestMountain(int[] arr) {
        if(arr.length==2){
            if(arr[0]>arr[1]){
                return 2;
            }else{
                return 0;
            }
        }
        int[] incr = new int[arr.length];
        int[] decr = new int[arr.length];
        Arrays.fill(incr, 1);
        Arrays.fill(decr, 1);
        for(int i =1;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                incr[i] = incr[i-1]+1;
            }
        }
        for (int i = decr.length-2; i >=0 ; i--) {
            if(arr[i+1]<arr[i]){
                decr[i] = decr[i+1]+1;
            }
        }
        int max = 0;
        for(int i =0;i<arr.length-1;i++){
            if (incr[i]>1 && decr[i]>1){
                max = Math.max(max,incr[i]+decr[i]-1);
            }
        }
        return max;
    }
}