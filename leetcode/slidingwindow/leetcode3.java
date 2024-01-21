package slidingwindow;


import java.util.HashSet;

public class leetcode3 {
    public static void main(String[] args) {
        String up="pwwkew";
        System.out.println(lengthOfLongestSubstring(up));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charset = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charset.contains(s.charAt(r))) {
                charset.remove(s.charAt(l));
                l++;
            }
            charset.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
