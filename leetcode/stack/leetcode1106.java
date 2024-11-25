package stack;

import java.util.*;

public class leetcode1106 {
    public static void main(String[] args) {
        leetcode1106 sol = new leetcode1106();
        System.out.println(sol.parseBoolExpr("|(f,&(t,t))"));
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> opr = new Stack<>();
        Stack<Character> oprnd = new Stack<>();
        expression = expression.replaceAll("[-+.:,]", "");  // Retain original logic to clean up input
        char[] exp = expression.toCharArray();
        
        int i = 0;
        while (i < exp.length) {
            char current = exp[i];
            if (current == 'f' || current == 't') {
                oprnd.add(current);
            } else if (current == '&' || current == '|' || current == '^' || current == '!') {
                opr.add(current);
            } else if (current == '(') {
                oprnd.add(current);  // Mark the start of a new sub-expression
            } else if (current == ')') {
                char operator = opr.pop();
                char result = evaluate(oprnd, operator);
                oprnd.add(result);  // Push result of sub-expression to the operand stack
            }
            i++;
        }
        return oprnd.pop() == 't'; 
    }

    private char evaluate(Stack<Character> oprnd, char operator) {
        List<Character> operands = new ArrayList<>();
        
        // Collect operands inside parentheses until '(' is encountered
        while (!oprnd.isEmpty() && oprnd.peek() != '(') {
            operands.add(oprnd.pop());
        }
        oprnd.pop();
        if (operator == '!') {
            // NOT operator only works on one operand
            return (operands.get(0) == 't') ? 'f' : 't';
        }

        // For other operators, handle multiple operands
        boolean result = (operator == '&') ? true : (operator == '|') ? false : false;

        for (char operand : operands) {
            boolean value = operand == 't';
            if (operator == '&') {
                result &= value;
            } else if (operator == '|') {
                result |= value;
            } else if (operator == '^') {
                result ^= value;
            }
        }

        return result ? 't' : 'f';
    }
}
