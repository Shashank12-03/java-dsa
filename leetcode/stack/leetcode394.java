package stack;

public class leetcode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        int num = 0;
        while (i!=s.length()) {
            char ch = s.charAt(i);
            int c = s.charAt(i)-'0';
            if (c>=1 && c<=9){
                num= num*10;
                num+= c;
            }
            else if (ch>='['){
                i++;
                StringBuilder inner = new StringBuilder();
                while (s.charAt(i)!=']') {
                    inner.append(s.charAt(i));
                    i++;
                }
                for(int j =0;j<num;j++){
                    ans.append(inner.toString());
                }
                num =0;
            }
            i++;
        }
        return ans.toString();
    }
}
