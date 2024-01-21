import java.util.Stack;

public class leetcode2390 {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
    public static String removeStars(String s) {
        Stack<Character> stk= new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty() && s.charAt(i)=='*'){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        StringBuilder ans=new StringBuilder("");
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        ans.reverse();
        String answer= ans.toString();
        return answer;
    }
}
