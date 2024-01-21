package arrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
    }

    public int pick(int target) {
        Integer key = getKeyByValue(map, target);
        return (key != null) ? key : -1; // Return -1 if target not found
    }

    private static <K, V> K getKeyByValue(Map<K, V> map, V targetValue) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(targetValue)) {
                return entry.getKey();
            }
        }
        return null; // Value not found
    }
}
