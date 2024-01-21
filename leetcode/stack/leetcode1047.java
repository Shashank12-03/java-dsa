
import java.util.Stack;
public class leetcode1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stk= new Stack<>();
        stk.push(s.charAt(0)); 
        for(int i=1;i<s.length();i++){
            if(!stk.isEmpty() && stk.peek()==s.charAt(i)){
                while(!stk.isEmpty() && stk.peek()==s.charAt(i)){
                    stk.pop();
                }
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        StringBuilder ans= new StringBuilder("");
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        ans.reverse();
        String answer;
        answer=ans.toString();
        return answer;
    }
}

