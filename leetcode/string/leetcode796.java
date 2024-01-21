package string;

public class leetcode796 {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int j=0;
        int k=goal.length();
        String temp=s+s;
        for (int i = 0; i < goal.length(); i++) {
            String sub=temp.substring(j, k);
            if(sub.equals(goal)){
                return true;
            }
            j++;
            k++;
        }
        return false;
    }
}
