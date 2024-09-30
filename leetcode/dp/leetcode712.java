package dp;

import java.util.*;

public class leetcode712 {
    public static void main(String[] args) {
        leetcode712 sol = new leetcode712();
        System.out.println(sol.minimumDeleteSum("delete","leet"));
    }
    public int minimumDeleteSum(String s1, String s2) {
        String common = longestCommonSubsequence(s1, s2);
        return sumofASCII(s1)+sumofASCII(s2)-2*sumofASCII(common);
    }
    private int sumofASCII(String s){
        int sum  = 0;
        for (int i = 0; i < s.length(); i++) {
            sum+=(int)s.charAt(i);
        }
        return sum;
    }
    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        for (int i = 1; i <=n; i++) {
            for (int k = 1; k <=m; k++) {
                if (text1.charAt(i-1)==text2.charAt(k-1)){
                    dp[i][k] = 1+ dp[i-1][k-1];  /*helper(text1, text2, i-1, j-1,dp);*/
                }else{
                    dp[i][k] = Math.max( dp[i-1][k]  /*helper(text1, text2, i-1, j,dp)*/,dp[i][k-1] /*helper(text1, text2, i, j-1,dp)*/);
                }
            }
        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        int len=dp[n][m];
        int i=n;
        int j=m;
        
        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(text1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == text2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) ); 
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>text2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        // System.out.println(str2);
        return  str2.toString();
    }
}
