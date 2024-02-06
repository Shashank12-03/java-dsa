package arrays;
import java.util.*;
public class leetcode49 {
    public static void main(String[] args) {
        List<List<String>> ans=groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String s : strs) {
            // Sort the characters and create a key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // Add the original string to the corresponding list in the map
            graph.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Return the values (lists of anagrams) from the map
        return new ArrayList<>(graph.values());
    }
}
