package greedy;

import java.util.HashSet;
import java.util.Set;

public class leetcode316{
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
    public static String removeDuplicateLetters(String s) {
        Set<Character> set=new HashSet<>();
        for (char character : s.toCharArray()) {
            set.add(character);
        }
        System.out.println(set);
        StringBuilder ans= new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            
        }
        return ans.toString();
    }
}