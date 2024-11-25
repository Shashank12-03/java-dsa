package stack;

import java.util.*;

public class leetcode946 {
    public static void main(String[] args) {
        leetcode946 sol = new leetcode946();
        System.out.println(sol.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int push = 0;
        int pop = 0;
        while (push<pushed.length){
            while (!stk.isEmpty() && pop<popped.length && stk.peek()==popped[pop]){
                pop++;
                stk.pop();
            }
            if (pop==popped.length){
                return true;
            }
            stk.push(pushed[push]);
            push++;
        } 
        while(!stk.isEmpty() && stk.peek()==popped[pop]){
            stk.pop();
            pop++;
        }
        if (pop==popped.length){
            return true;
        }
        return false;
    }
}
