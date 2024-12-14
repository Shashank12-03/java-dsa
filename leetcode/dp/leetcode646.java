package dp;

import java.util.Arrays;

public class leetcode646 {
    public static void main(String[] args) {
        leetcode646 sol = new leetcode646();
        System.out.println(sol.findLongestChain(new int[][]{{1,2},{7,8},{4,5}}));
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> Integer.compare(a[1], b[1]));
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
        return 0;
    }
}
