package stack;

import java.util.Stack;

public class leetcode150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public static int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        int eval =0;
        for (String string : tokens) {
            if (string.equals("/") || string.equals("+") || string.equals("-") || string.equals("*")){
                if (!stk.isEmpty() && string.equals("/")){
                    int op2 = Integer.parseInt(stk.pop());
                    int op1 = Integer.parseInt(stk.pop());
                    eval = op1/op2; 
                }
                if (!stk.isEmpty() && string.equals("*")){
                    int op2 = Integer.parseInt(stk.pop());
                    int op1 = Integer.parseInt(stk.pop());
                    eval = op1*op2;  
                }
                if (!stk.isEmpty() && string.equals("-")){
                    int op2 = Integer.parseInt(stk.pop());
                    int op1 = Integer.parseInt(stk.pop());
                    eval = op1-op2; 
                }
                if (!stk.isEmpty() && string.equals("+")){
                    int op2 = Integer.parseInt(stk.pop());
                    int op1 = Integer.parseInt(stk.pop());
                    eval= op1+op2;  
                }
                stk.push( String.valueOf(eval));
            }
            else{
                stk.push(string);
            }
        }
        return Integer.parseInt(stk.peek());
    }
}
