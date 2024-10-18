package arrays;

import java.util.*;

public class leetcode1331 {
    public static void main(String[] args) {
        leetcode1331 sol = new leetcode1331();
        System.out.println(Arrays.toString(sol.arrayRankTransform(new int[]{10,10,10,10})));
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        int[] sort = arr.clone();
        Arrays.sort(sort);
        for(int i = 0;i<n;i++){
            if(!map.containsKey(sort[i])){
                map.put(sort[i],i);
            }
        }
        for(int i=0;i<n;i++){
            ans[i] =map.get(arr[i])+1;
        }
        return ans;
    }
}
