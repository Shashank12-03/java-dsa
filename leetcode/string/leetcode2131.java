package string;

import java.util.HashMap;
import java.util.Map;

public class leetcode2131 {
    public static void main(String[] args) {
        leetcode2131 obj = new leetcode2131();
        String[] words = {"lc","cl","gg"};
        int result = obj.longestPalindrome(words);
        System.out.println(result);
    }
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean hasMiddlePalindrome = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(reversed, 0) > 0) {
                length += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                hasMiddlePalindrome = true;
                break;  // only one such palindromic string can go in the center
            }
        }

        if (hasMiddlePalindrome) {
            length += 2;
        }

        return length;
    }
}
