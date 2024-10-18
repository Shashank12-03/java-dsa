package arrays;

import java.util.*;

public class leetcode624 {
    public static void main(String[] args) {
        leetcode624 sol = new leetcode624();
        List<List<Integer>> listOfLists = new ArrayList<>();
        
        // Adding the first list
        List<Integer> list1 = new ArrayList<>();
        list1.add(-8);
        list1.add(-7);
        list1.add(-7);
        list1.add(-5);
        list1.add(1);
        list1.add(1);
        list1.add(3);
        list1.add(4);
        listOfLists.add(list1);

        // Adding the second list
        List<Integer> list2 = new ArrayList<>();
        list2.add(-2);
        listOfLists.add(list2);

        // Adding the third list
        List<Integer> list3 = new ArrayList<>();
        list3.add(-10);
        list3.add(-10);
        list3.add(-7);
        list3.add(0);
        list3.add(1);
        list3.add(3);
        listOfLists.add(list3);

        // Adding the fourth list
        List<Integer> list4 = new ArrayList<>();
        list4.add(2);
        listOfLists.add(list4);
        System.out.println(listOfLists);
        System.out.println(sol.maxDistance(listOfLists));
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int diff = Integer.MIN_VALUE;
        for(int i =1;i<arrays.size();i++){
            List<Integer> list = arrays.get(i);
            diff = Math.max(diff,Math.max(Math.abs(max-list.get(0)),Math.abs(list.get(list.size()-1)-min)));
            min = Math.min(min,list.get(0));
            max = Math.max(max,list.get(list.size()-1));
        }
        return diff;
    }
}
