package string;

public class leetcode392{
    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){
            return true;
        }
        for(int i=0;i<t.length();i++){
            if(!s.isEmpty()){
                if(s.charAt(0)==t.charAt(i)){
                    s=s.substring(1);
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}