package arrays;

import java.util.Arrays;

public class leetcode521 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
    public static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c :tasks) {
            arr[c-'A']++;
        }
        Arrays.sort(arr);
        int chunk=arr[25]-1;
        int idle=chunk*n;
        for (int i = 24; i >=0; i--) {
            idle-=Math.min(chunk,arr[i]);
        }
        return idle<0 ? tasks.length :tasks.length+idle; 
    }
}
