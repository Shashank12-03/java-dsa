package stack;

public class leetcode1091 {
    public static void main(String[] args) {
        
    }
    public String removeOuterParentheses(String s) {
        // Stack<Character> st =new Stack<Character>();
        // StringBuilder sb= new StringBuilder();

        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     if(ch=='('){
                
        //         if(st.size()>0) sb.append(ch);

        //         st.push(ch);
        //     }
        //     else{
        //         st.pop();
        //             if(st.size()>0) sb.append(ch);
        //     }
        // }
        // return sb.toString();
        char[] chr=s.toCharArray();
        int c=1,l=chr.length,i=1;
        StringBuilder res=new StringBuilder();
        while(i<l){
            if(chr[i]=='(')c++;
            else c--;
            if(c==0){
                i+=2;
                c=1;
            }else{
                res.append(chr[i]);
                i++;
            }
        }
        return res.toString();
        // String.
    }
}
