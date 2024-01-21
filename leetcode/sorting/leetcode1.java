package sorting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class leetcode1 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        System.out.println(Arrays.toString(twoSum(nums, -8)));
    }
    //brute approach
    /*
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    } 
    */

    // O(nlogn) approach

    /*static int[] twoSum(int[] nums, int target) {
        //cloning the array 
        int[] temp=nums.clone();
        //sorting the given array
        Arrays.sort(nums);
        int[] ans=new int[2];
        int left=0;
        int right=nums.length-1;
        //searching for 1st element
        while(left<right){
            int sum=nums[left]+nums[right];
            // if sum==target we found our answer but we have to return position of the elements in orginal array so searching for it
            if(sum==target){
                int a=0;
                int b=0;
                for(int k=0;k<nums.length;k++){
                    if(temp[k]==nums[left]){
                        a=k;
                        break;
                    }
                }
                for(int k=0;k<nums.length;k++){
                    if(k!=a && temp[k]==nums[right]){
                        b=k;
                    }
                }
                return new int[]{a,b};
            }
            //if sum is less than target we increase the left side
            else if(sum<target){
                left++;
            }
            // if sum is greater than target we decrease the right side
            else{
                right--;
            }
        }
        return ans;
    }*/
    //optimal approach O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }
}
