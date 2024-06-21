import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack <Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(2); 
        stk.push(1);
        stk.push(7);
        stk.push(6);
        reverse(stk);
        System.out.println(stk);
    }
    public static void reverse(Stack<Integer> s){
        int i=0;
        while (i<s.size()-1) {
            int a = s.pop();
            rev(s,a,i);
            i++;
        }
    }
    private static void rev(Stack<Integer> s, int a, int i) {
        if (i==s.size()){
            s.push(a);
            return;
        }
        int x = s.pop();
        rev(s, a, i);
        s.push(x);
    }
}
