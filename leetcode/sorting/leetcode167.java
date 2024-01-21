package sorting;
import java.util.Arrays;
public class leetcode167 {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
    static int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        for(int i=1;i<nums.length;i++){
            int left=i-1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    ans[0]=left+1;
                    ans[1]=right;
                    right--;
                    left++;
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
}
