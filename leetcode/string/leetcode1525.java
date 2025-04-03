package string;

import java.util.HashSet;
import java.util.Set;

public class leetcode1525 {
    public static void main(String[] args) {
        leetcode1525 solution = new leetcode1525();
        System.out.println(solution.numSplits("aacaba"));
    }
    public int numSplits(String s) {
        //  aacaba
        //  112233
        //  333221
        Set<Character> set =  new HashSet<>();
        int n = s.length();
        set.add(s.charAt(0));
        int[] prefix = new int[n];
        prefix[0] = 1;
        int[] suffix = new int[n];
        suffix[n-1] = 1; 
        for(int i = 1;i<n;i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                prefix[i] = 1 + prefix[i-1];
            }
            else{
                prefix[i] = prefix[i-1];
            }
            set.add(ch);
        }
        set.clear();
        set.add(s.charAt(n-1));
        for(int i = n-2;i>=0;i--){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                suffix[i] = 1 + suffix[i+1];
            }
            else{
                suffix[i] = suffix[i+1];
            }
            set.add(ch);
        }
        int res = 0;
        for(int i = 0;i<n-1;i++){
            if(prefix[i]==suffix[i+1]){
                res++;
            }
        }
        return res;
    }
}
