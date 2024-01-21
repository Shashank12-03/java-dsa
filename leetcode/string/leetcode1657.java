package string;

import java.util.Arrays;

public class leetcode1657 {
    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        if(!containsAllChars(word1, word2)){
            return false;
        }
        int[] store1=new int[26];
        int[] store2=new int[26];
        for (int i = 0; i < word1.length(); i++) {
            store1[word1.charAt(i)-'a']++;
            store2[word2.charAt(i)-'a']++;
        }
        System.out.println(Arrays.toString(store1));
        System.out.println(Arrays.toString(store2));
        Arrays.sort(store1);
        Arrays.sort(store2);
        for (int i = 0; i <26; i++) {
            if (store1[i]!=store2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean containsAllChars(String mainString, String checkString) {

        // Check if all characters in checkString are present in mainString
        for (char c : checkString.toCharArray()) {
            if (!mainString.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }
}
