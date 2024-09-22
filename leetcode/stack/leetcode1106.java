package stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode1106 {
    public static void main(String[] args) {
        leetcode1106 sol = new leetcode1106();
        System.out.println(sol.parseBoolExpr("&(|(f))"));
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> opr = new Stack<>();
        Stack<Character> oprnd = new Stack<>();
        expression = expression.replaceAll("[-+.:,]", "");  // Keep as per original logic
        char[] exp = expression.toCharArray();
        System.out.println(Arrays.toString(exp));  // Debugging print, can be removed if not needed
        int i = 0;
        while (i < exp.length) {
            if (exp[i] == 'f' || exp[i] == 't') {
                oprnd.add(exp[i]);  // Add the operand to the stack
            } else if (exp[i] == '&' || exp[i] == '|' || exp[i] == '^' || exp[i] == '!') {
                opr.add(exp[i]);  // Add the operator to the stack
            } else if (exp[i] == ')') {
                // When you encounter a closing parenthesis, evaluate the expression
                char operator = opr.pop();
                char result = evaluate(opr, oprnd, operator);
                oprnd.add(result);  // Push the result of the evaluation
            } else if (exp[i] == '(') {
                // Skip the opening parenthesis as it's just a marker
            }
            i++;
        }
        return oprnd.pop() == 't';  // Return the final result
    }
    
    // Helper method to evaluate the current expression based on the operator
    private char evaluate(Stack<Character> opr, Stack<Character> oprnd, char operator) {
        if (operator == '!') {
            // For '!', pop one operand and negate it
            char operand = oprnd.pop();
            return (operand == 't') ? 'f' : 't';
        }
    
        // For '&', '|', or '^', collect all operands until the stack is empty or the next '('
        boolean result = (operator == '&') ? true : (operator == '|') ? false : false;  // Default based on operator
        List<Character> operands = new ArrayList<>();
        
        while (!oprnd.isEmpty() && oprnd.peek() != '(') {
            operands.add(oprnd.pop());
        }
        
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
