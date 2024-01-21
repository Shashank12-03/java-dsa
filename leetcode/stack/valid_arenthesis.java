
import java.util.Stack;

public class valid_arenthesis {
    public static void main(String[] args) {
        System.out.println(valid("{[(]}"));
    }
    static boolean valid(String parenthesis){
        Stack<Character> stack= new Stack<>();
        for(char ch: parenthesis.toCharArray()){
            if(ch=='(' || ch=='['|| ch=='{'){
                stack.push(ch);
            }
            if(ch==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
            }
            else if(ch==']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }
            }
            else if(ch=='}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
