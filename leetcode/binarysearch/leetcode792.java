package binarysearch;

import java.util.*;

public class leetcode792 {
    public static void main(String[] args) {
        
    }
    public int numMatchingSubseq(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        char[] sChar = s.toCharArray();
        
        int ans = 0;
        for (String string: map.keySet()) {
            char[] seq = string.toCharArray();
            int i = 0;
            int j = 0;
            while (i<sChar.length && j<seq.length) {
                if (sChar[i]==seq[j]) {
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            } 
            if (j==seq.length) {
                ans+=map.get(string);
            }
        }
        return ans;
    }
    // public int numMatchingSubseq(String s, String[] words) {
    //     Map<Character,List<Integer>> map = new HashMap<>();
    //     for(int i = 0;i<s.length();i++){
    //         if (map.containsKey(s.charAt(i))){
    //             map.get(s.charAt(i)).add(i);
    //         }
    //         else{
    //             List<Integer> list = new ArrayList<>();
    //             list.add(i);
    //             map.put(s.charAt(i),list);
    //         }
    //     }
    //     int ans = 0;
    //     for(int i = 0;i<words.length;i++){
    //         if(check(words[i],map)){
    //             ans++;
    //         }
    //     }
    //     return ans;
    // }
    // private boolean check(String str, Map<Character,List<Integer>> map){
    //     int last_index = -1;
    //     for(int i = 0;i<str.length();i++){
    //         char ch = str.charAt(i);
    //         if(!map.containsKey(ch)){
    //             return false;
    //         }
    //         List<Integer> list = map.get(ch);
    //         int pos = find(list,last_index);
    //         if(pos==-1){
    //             return false;
    //         }
    //         last_index = list.get(pos);
    //     }
    //     return true;
    // }
    // private int find(List<Integer> list, int index){
    //     int l = 0;
    //     int r = list.size()-1;
    //     while(l<=r){
    //         int mid = (l+r)/2;
    //         if(list.get(mid)>index){
    //             r = mid-1;
    //         }
    //         else{
    //             l = mid +1;
    //         }
    //     }
    //     return l<list.size()?l:-1;
    // }
}
