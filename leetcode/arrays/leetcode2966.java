package arrays;

import java.util.Arrays;

public class leetcode2966 {
    public static void main(String[] args) {
        int[][] ans=divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2);
        for (int[] is : ans) {
            System.out.print(Arrays.toString(is));
        }
    }
    public static int[][] divideArray(int[] nums, int k) {
        int[][] ans=new int[nums.length/3][3];
        Arrays.sort(nums);
        int j=0;
        for (int i = 0; i < ans.length; i++) {
            if(nums[j+2]-nums[j]<=k){
                for (int l = 0+j, m=0; l < 3+j; l++,m++) {
                    ans[i][m]=nums[l];
                }
            }else{
                return new int[][]{};
            }
            j+=3;
        }
        return ans;
    }
}
