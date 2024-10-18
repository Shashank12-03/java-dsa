
import java.util.*;

public class leetcode962 {
    public static void main(String[] args) {
        leetcode962 sol = new leetcode962();
        System.out.println(sol.maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }
    public int maxWidthRamp(int[] nums) {
        // int maxLen  = 0;
        // for(int i =0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i]<=nums[j]){
        //             maxLen = Math.max(maxLen,j-i);
        //         }
        //     }
        // }
        // return maxLen;
        int n=nums.length;
        int[] temp=new int[n];
        int maxWidth = 0;
        temp[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            temp[i] = Math.max(nums[i], temp[i+1]);
        }
        int left = 0;
        for (int right = 0; right < temp.length; right++) {
            while (nums[left]>temp[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right-left);
        }
        System.out.println(Arrays.toString(temp));
        return maxWidth;
    }
}
