package dp;



public class leetcode1416 {
    public static void main(String[] args) {
        
    }

    int mod =(int) Math.pow(10,9)+7;

    public int numberOfArrays(String s, int k) {
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
                    if(num>k){
                        break;
                    }
                    ans = ( ans % mod + dp[i+1] % mod) % mod;
                }
                dp[ind] = ans;
            }
        }
        return dp[0];
    }
    

    // private int helper(int ind , String s ,int k,int[] dp){
    //     if(ind>=s.length()){
    //         return 1;
    //     }
        
    //     if(dp[ind]!=-1){
    //         return dp[ind];
    //     }
    //     if(s.charAt(ind) == '0'){
    //         return 0;
    //     }
    //     int ans = 0;
    //     long num  = 0;
    //     for(int i =ind ;i < s.length() ; i++){
    //         num = num*10 + (s.charAt(i)-'0');
    //         if(num>k){
    //             break;
    //         }
    //         ans = ( ans % mod + helper(i+1, s, k,dp) % mod) % mod;
    //     }
    //     return dp[ind] = ans;
    // }
}
