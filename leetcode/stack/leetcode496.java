package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leetcode496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            nums1[i]=map.get(x);
        }
        helper(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int x= nums1[i];
            nums1[i]=nums2[x];
        }
        return nums1;
    }
    private static void helper(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length-1]);
        nums[nums.length-1]=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(stack.isEmpty()){
                nums[i]=-1;
            }else{
                while (!stack.isEmpty() && stack.peek()<nums[i]) {
                    stack.pop();

                }
                int x = nums[i];
                if(!stack.isEmpty()){
                    nums[i]= stack.peek();
                }else{
                    nums[i]=-1;
                }
                stack.push(x);
            }
        }
    }
}
