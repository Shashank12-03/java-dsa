package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode784 {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }
    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(0,s,ans,new StringBuilder());
        return ans;
    }
    private static void helper(int ind, String s, List<String> ans, StringBuilder str) {
        if (ind == s.length()) {
            ans.add(str.toString());
            return;
        }
        char ch = s.charAt(ind);
        if (Character.isLetter(ch)) {
            str.append(Character.toLowerCase(ch));
            helper(ind + 1, s, ans, str);
            str.deleteCharAt(str.length() - 1);
            
            str.append(Character.toUpperCase(ch));
            helper(ind + 1, s, ans, str);
            str.deleteCharAt(str.length() - 1);
        } else {
            str.append(ch);
            helper(ind + 1, s, ans, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
