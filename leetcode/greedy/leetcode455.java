package greedy;

import java.util.Arrays;

public class leetcode455 {
    
    public static void main(String[] args) {
        
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int indG=0;
        int indS=0;
        int cnt = 0;
        while (indG<g.length && indS<s.length) {
            if(g[indG]<=s[indS]){
                cnt++;
                indG++;
                indS++;
            }else{
                indS++;
            }
        }
        return cnt;
    }
}
