import java.util.Stack;

public class leetcode20 {
    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('|| c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    if(c==')'  && stack.peek()=='('){
                        stack.pop();
                    }
                    else if(c==']'  && stack.peek()=='['){
                        stack.pop();
                    }
                    else if(c=='}'  && stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.empty()?true:false;
    }
}
