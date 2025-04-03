package dp;

public class leetcode2140 {
    public static void main(String[] args) {
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        leetcode2140 obj = new leetcode2140();
        long result = obj.mostPoints(questions);
        System.out.println("Maximum points: " + result);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long [] dp = new long[n+1];
        // Arrays.fill(dp,-1);
        for(int ind = n-1;ind>=0;ind--){
            long notTake = dp[ind+1];
            long take = questions[ind][0];
            int newInd = ind+questions[ind][1]+1;
            if(newInd<n){
                take += dp[newInd];
            }
            dp[ind] = Math.max(take,notTake);
        }
        return dp[0];
    }
    private long helper(int ind,int[][] questions, long[] dp){
        if(ind>=questions.length){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        long notTake = helper(ind+1,questions,dp);
        long take =  questions[ind][0] + helper(ind+questions[ind][1]+1,questions,dp);
        return dp[ind] = Math.max(take,notTake);
    }
}
