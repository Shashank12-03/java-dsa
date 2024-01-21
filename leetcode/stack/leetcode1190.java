import java.util.Stack;

public class leetcode1190 {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
    }
    public static String reverseParentheses(String s) {
        Stack<Character> stk= new Stack<>();
        for(int i=0;i<s.length();i++){
            //add char to stack
            char ch=s.charAt(i);
            if(ch!=')'){
                stk.push(ch);
                continue;
            }
            //takr out of character until getting opening bracket and add it to the string
            StringBuilder rev= new StringBuilder("");
            while(!stk.isEmpty() && stk.peek()!='('){
                rev.append(stk.pop());
            }
            if(!stk.isEmpty()){
                stk.pop();
            }
            if(!rev.isEmpty()){
                for(int j=0;j<rev.length();j++){
                    stk.push(rev.charAt(j));
                }
            }  
        }
        StringBuilder ans= new StringBuilder("");
            while(!stk.isEmpty()){
                ans.append(stk.pop());
            }
        return ans.reverse().toString();
    }
}
