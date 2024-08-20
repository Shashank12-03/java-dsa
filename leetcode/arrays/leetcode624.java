package arrays;

import java.util.*;

public class leetcode624 {
    public static void main(String[] args) {
        leetcode624 sol = new leetcode624();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(4);
        list.add(new ArrayList<>(ls));
        ls.clear();
        ls.add(0);
        ls.add(5);
        list.add(new ArrayList<>(ls));
        System.out.println(list);
        System.out.println(sol.maxDistance(list));
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arrays.size();i++){
            List<Integer> list = arrays.get(i);
            min = Math.min(min,list.get(0));
            max = Math.max(max,list.get(list.size()-1));
        }
        return Math.abs(min-max);
    }
}
