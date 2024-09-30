package dp;

public class leetcode91 {
    public static void main(String[] args) {
        
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        // Arrays.fill(dp, -1);
        for (int ind = n-1; ind >=0 ; ind--) {
            if(s.charAt(ind) == '0'){
                dp[ind] = 0;
            }
            else{
                int ans = 0;
                long num  = 0;
                for(int i =ind ;i < s.length() ; i++){
                    num = num*10 + (s.charAt(i)-'0');
                    if(num>26){
                        break;
                    }
                    ans = ans + dp[i+1];
                }
                dp[ind] = ans;
            }
        }
        return dp[0];
    }
}
