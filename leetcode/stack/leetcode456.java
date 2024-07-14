package stack;

import java.util.Stack;

public class leetcode456 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3,1,4,2}));
    }
    public static boolean find132pattern(int[] nums) {
        Stack<Pair> stk = new Stack<>();
        int currMin = nums[0];
        for (int i= 1;i<nums.length;i++) {
            int num = nums[i];
            while (!stk.isEmpty() && num >= stk.peek().num) {
                stk.pop();
            }
            if (!stk.isEmpty() && num > stk.peek().min){
                return true;
            } 
            stk.add(new Pair(num, currMin));
            currMin = Math.min(currMin,num);
        }
        return false;
    }
}
class Pair{
    int num;
    int min;
    Pair(int num,int min){
        this.num = num;
        this.min = min;
    }
}
