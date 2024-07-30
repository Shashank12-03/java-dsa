package backtracking;

public class leetcode678 {
    public static void main(String[] args) {
        leetcode678 sol = new leetcode678();
        sol.checkValidString("(*()))");
    }
    public boolean checkValidString(String s) {
        int leftMin =0;
        int leftMax =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch=='('){
                leftMin++;
                leftMax++;
            }
            else if(ch==')'){
                leftMin--;
                leftMax--;
            }
            else{
                leftMin--;
                leftMax++;
            }
            if(leftMax<0){
                return false;
            }
            if(leftMin<0){
                leftMin = 0;
            }
        }
        return leftMin==0?true:false;
    }
}
