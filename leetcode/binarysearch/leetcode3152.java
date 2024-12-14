package binarysearch;

import java.util.Arrays;

public class leetcode3152 {
    public static void main(String[] args) {
        leetcode3152 sol = new leetcode3152();
        System.out.println(Arrays.toString(sol.isArraySpecial(new int[]{4,3,1,6}, new int[][]{{0,2},{2,3}})));
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        // here what we do we create a prefix array to keep count of how many mis parity happens suppose like if we have occured mis parity at position 2 so what we are doing here we start with 0 as we cant compare before it so starting from 0 we start comparing with previous element if its mis parity then we increase the count at that position of mis parity in short array its mis parity happened till that position  
        // int[] array = new int[nums.length]; 
        // boolean[] ans = new boolean[queries.length]; 
        // array[0] = 0;
        // for(int i =1 ;i<nums.length;i++){
        //     if((nums[i]%2==nums[i-1]%2)){
        //         array[i] = array[i-1]+1;
        //     }
        //     else{
        //         array[i] = array[i-1];
        //     }
        // }
        // int i = 0;
        // for(int[] query:queries){
        //     if(array[query[0]]==array[query[1]]){
        //         ans[i++] = true;
        //     }
        //     else{
        //         ans[i++] = false;
        //     }
        // }
        // return ans;

        int[] array = new int[nums.length]; 
        boolean[] ans = new boolean[queries.length]; 
        array[0] = 0;
        for(int i =1 ;i<nums.length;i++){
            if((nums[i]%2==nums[i-1]%2)){
                array[i] = 1;
            }
        }
        int i = 0;
        for(int[] query:queries){
            int left = query[0];
            int right = query[1];
            while(left<right){
                int mid = left+(right-left)/2;
                if(array[mid]==1){
                    ans[i++] = false;
                }
                
            }
        }
        return ans;
    }
}
