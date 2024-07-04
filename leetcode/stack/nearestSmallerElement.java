package stack;

import java.util.Arrays;
import java.util.Stack;

public class nearestSmallerElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(prevSmaller(new int[]{ 39, 27, 11, 4, 24, 32, 32, 1 })));
        // -1 -1 -1 -1 4 24 24 -1
        // -1 -1 -1 -1 4 24 32 -1 
    }
    public static int[] prevSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        nums[0]=-1;
        for(int i=1;i<nums.length;i++){
            if(stack.isEmpty()){
                nums[i]=-1;
            }else{
                while (!stack.isEmpty() && stack.peek()>=nums[i]) {
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
        return nums;
    }
    
}
