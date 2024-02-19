package arrays;
import java.util.*;
public class leetcode1642 {
    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] diffArray=new int[heights.length-1];
        for (int i = 1; i < heights.length; i++) {
            diffArray[i-1]=heights[i-1]-heights[i];
        }
        System.out.println(Arrays.toString(diffArray));
        int count=0;
        for (int i = 0; i < diffArray.length; i++) {
            if (diffArray[i]>=0) {
                count++;
            }
            else{
                if (Math.abs(diffArray[i])>bricks) {
                    if (ladders>0) {
                        ladders--;
                        count++;
                    }
                }
                if()
            }
        }
        
    }
}
