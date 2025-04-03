package string;

import java.util.ArrayList;
import java.util.List;

public class leetcode783 {
    public static void main(String[] args) {
        String input = "ababcbacadefegdehijhklij";
        leetcode783 solution = new leetcode783();
        List<Integer> result = solution.partitionLabels(input);
        System.out.println(result);
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int firstIndex = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int lastIndex = s.lastIndexOf(ch);
            
            if(lastIndex>=index){
                index = lastIndex;
            }
            if(i>=index){
                list.add(i+1-firstIndex);
                firstIndex = i+1;
            }
            
        }
        return list;
    }
}
