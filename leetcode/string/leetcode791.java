package string;

public class leetcode791 {
    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
    public static String customSortString(String order, String s) {
        int[] str=new int[26];
        for (char ch : s.toCharArray()) {
            str[ch-'a']++;
        }
        StringBuffer ans=new StringBuffer("");
        for (int i = 0; i < order.length(); i++) {
            int ind=order.charAt(i)-'a';
            while (str[ind]>0) {
                ans.append((char)(ind+'a'));
                str[ind]--;
            }
        }
        for (int i = 0; i < str.length; i++) {
            while (str[i]>0) {
                ans.append((char)(i+'a'));
                str[i]--;
            }
        }
        return ans.toString();
    }
}
