package slidingwindow;


public class leetcode76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() ==0 || t.length() == 0 || s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE,startIndex =0;
        for (char c :t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- >0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                    
                }
            }
        }

        return minLen == Integer.MAX_VALUE? new String():
                new String(chS,startIndex,minLen);
        // HashMap<Character, Integer> targetMap = new HashMap<>();
        // for (char c : t.toCharArray()) {
        //     targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        // }

        // int left = 0;
        // int right = 0;
        // int requiredChars = t.length();
        // int minLength = Integer.MAX_VALUE;
        // int minStart = 0;

        // while (right < s.length()) {
        //     char rightChar = s.charAt(right);
        //     if (targetMap.containsKey(rightChar) && targetMap.get(rightChar) > 0) {
        //         requiredChars--;
        //     }
        //     targetMap.put(rightChar, targetMap.getOrDefault(rightChar, 0) - 1);
        //     right++;

        //     while (requiredChars == 0) {
        //         minLength=Math.min(right-left,minLength);
        //         minStart = left;
        //         char leftChar = s.charAt(left);
        //         targetMap.put(leftChar, targetMap.get(leftChar) + 1);

        //         if (targetMap.containsKey(leftChar) && targetMap.get(leftChar) > 0) {
        //             requiredChars++;
        //         }

        //         left++;
        //     }
        // }

        // return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);
    }
}
