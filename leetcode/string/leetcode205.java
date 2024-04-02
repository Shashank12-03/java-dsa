package string;

public class leetcode205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","abc"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        int[] arrS = new int[256];
        int[] arrT = new int[256];
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(arrS[c1]!=arrT[c2]){
                return false;
            }
            arrS[c1]=i+1;
            arrT[c2]=i+1;
        }
        return true;
    }
}
