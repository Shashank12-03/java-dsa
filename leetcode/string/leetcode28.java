package string;

public class leetcode28 {
    public static void main(String[] args) {
        System.out.println(strStr("leetcode", "leeto"));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return  haystack.indexOf(needle);
        }
        else{
            return -1;
        }
    }
}
