package arrays;

import java.util.*;
public class leetcode1207 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16}));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> set= new HashSet<>();
        for (Integer integer : map.values()) {
            if(!set.add(integer)){
                return false;
            }
        }
        return true;
    }
}
