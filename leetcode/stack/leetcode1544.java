package stack;

import java.util.Stack;

public class leetcode1544 {
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (!stack.isEmpty() && Math.abs(c-stack.peek())==32) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c:stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}