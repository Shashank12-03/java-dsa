package dp;

import java.util.*;

public class leetcode120{
    public static void main(String[] args) {
        System.out.println(minimumTotal({{2},{3,4},{6,5,7},{4,1,8,3}}));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for (List<Integer> list : triangle){
            int min = Integer.MAX_VALUE;
            for(Integer num:list){
                min = Math.min(min, num);
            }
            sum+=min;
        }
        return sum;
    }
}