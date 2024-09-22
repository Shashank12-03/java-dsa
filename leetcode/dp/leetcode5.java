package dp;

// import java.util.Arrays;

public class leetcode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
    public static String longestPalindrome(String text1) {
        StringBuilder str = new StringBuilder();
        for(int i =text1.length()-1;i>=0;i--){
            str.append(text1.charAt(i));
        }
        String text2 = longestPalindromeSubseq(text1);
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        // for (int i = 0; i <=n; i++) {
        //     dp[i][0] = 0;
        // }
        // for (int i = 0; i <=m; i++) {
        //     dp[0][i] = 0;
        // }
        int maxLen = 0;
        int endIdx = 0;
        for (int i = 1; i <=n; i++) {
            for (int k = 1; k <=m; k++) {
                if (text1.charAt(i-1)==text2.charAt(k-1)){
                    dp[i][k] = 1+ dp[i-1][k-1];  /*helper(text1, text2, i-1, j-1,dp);*/

                    if (dp[i][k] > maxLen && (i - dp[i][k] == n - k)) {
                        maxLen = dp[i][k];
                        endIdx = i; // Update the ending index of the longest palindrome
                    }

                }else{
                    dp[i][k] = 0;
                }
            }
            // for (int[] is : dp) {
            //     System.out.println(Arrays.toString(is));
            // }
        }
        // System.out.println(maxLen);
        // System.out.println(endIdx);
        // System.out.println(row);
        // System.out.println(col);
        // StringBuilder ans = new StringBuilder();
        // while (row>0 && col>0 && dp[row][col]!=0) {
        //     ans.append(text1.charAt(row-1));
        //     row--;
        //     col--;
        // }

        // for (int[] is : dp) {
        //     System.out.println(Arrays.toString(is));
        // }
        return text1.substring(endIdx - maxLen, endIdx);
    }
    public static String longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder();
        for(int i =s.length()-1;i>=0;i--){
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
