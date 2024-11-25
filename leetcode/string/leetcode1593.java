package string;

import java.util.HashSet;
import java.util.Set;

public class leetcode1593 {
    public static void main(String[] args) {
        leetcode1593 sol = new leetcode1593();
        System.out.println(sol.maxUniqueSplit("ababccc"));
    }
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return helper(s,0,s.length(),set);
        
    }
    private int helper(String s, int stInd, int n, Set<String> set ){
        if (stInd==n){
            return set.size();
        }
        int max = 0;
        for (int i = stInd+1; i <n; i++) {
            String sub = s.substring(stInd, i);
            if (!set.contains(sub)) {
                set.add(sub);
                max = Math.max(max, helper(sub,i, n, set));
                set.remove(sub);
            }
        }
        return max;
    }
}
