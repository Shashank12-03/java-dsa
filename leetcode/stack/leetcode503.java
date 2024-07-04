package stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,3,4,2})));
    }
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int [] ans = new int[nums.length];
        for(int i=2*n-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=nums[i%n]) {
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    ans[i]= stack.peek();
                }
                else{
                    ans[i]=-1;
                }
            }
            int x = nums[i%n];          
            stack.push(x);
        }
        return ans;
    }
}
