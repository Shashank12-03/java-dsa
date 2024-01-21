package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode451 {
    public static void main(String[] args) {
         System.out.println(frequencySort("asssfee"));
    }
    public static String frequencySort(String s) {
        if (s == null ||s.isEmpty()) {
            return s;
        }
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(charFrequencyMap.entrySet());

        // Sort the list based on frequency in ascending order
        entryList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
 
        // Print the sorted character frequency map
        StringBuilder ans= new StringBuilder("");
        for (Map.Entry<Character, Integer> entry : entryList) {
            int time=entry.getValue();
            while (time>0) {
                ans.append(entry.getKey());
                time--;
            }
        }
        
       
        return ans.toString();
    }

}
