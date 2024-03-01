package string;

public class leetcode2864 {
    public static void main(String[] args) {
        System.out.println( maximumOddBinaryNumber("101"));
    }
    public static String maximumOddBinaryNumber(String s) {
        int ones=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        char[] str=new char[s.length()];
        str[s.length()-1]='1';
        ones--;
        for (int i = 0; i < str.length-1; i++) {
            if (ones>0) {
                str[i]='1';
                ones--;
            }
            else{
                str[i]='0';
            }
        }
        return new String(str);
    }
}
