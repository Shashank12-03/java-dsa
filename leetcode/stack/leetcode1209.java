package stack;

import java.util.Stack;

public class leetcode1209 {
    public static void main(String[] args) {
        leetcode1209 sol = new leetcode1209();
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3));
    }
    public String removeDuplicates(String s, int k) {
        Stack<Character> stk = new Stack<>();
        for(char ch :s.toCharArray()){
            
            while(!stk.isEmpty() ){
                stk.pop();
            }
            
            stk.push(ch);
        } 
        char[] arr = new char[stk.size()];
        int i = stk.size()-1;
        while(!stk.isEmpty()){
            arr[i] = stk.pop();
            i--;
        }
        return new String(arr); 
    }
}
