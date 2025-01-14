package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode916 {
    public static void main(String[] args) {
        leetcode916 solution = new leetcode916();
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"l", "e"};
        List<String> result = solution.wordSubsets(words1, words2);
        System.out.println(result);
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        // Arrays.fill(freq, Integer.MAX_VALUE);
        for (String str : words2) {
            int[] freq2 = new int[26];
            for (char ch : str.toCharArray()) {
                freq2[ch-'a']++;
            }
            for (int i = 0; i <26; i++) {
                freq[i] = Math.max(freq[i], freq2[i]);
            }
        }
        System.out.println(Arrays.toString(freq));
        List<String> list = new ArrayList<>();
        for (String word : words1) {
            int[] freq2 = new int[26];
            for (char ch : word.toCharArray()) {
                freq2[ch-'a']++;
            }
            System.out.println(Arrays.toString(freq2));
            boolean isSubset =true;
            for (int i = 0; i <26; i++) {
                if (freq[i]>freq2[i]) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                list.add(word);
            }
        }
        
        return list;
    }
}
