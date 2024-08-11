package dp;

public class leetcode62 {
    public static void main(String[] args) {
        leetcode62 sol = new leetcode62();
        System.out.println(sol.uniquePaths(3, 7));
        
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }
                else{
                    int down =dp[i-1][j];
                    int right = dp[i][j-1];
                    dp[i][j] = down+right;
                }
            }
        }
        return dp[m-1][n-1];
    }
    // public int helper(int[][] dp ,int m,int n){
    //     if(m==1 || n==1){
    //         return 1;
    //     }
    //     if(m<0 && n<0){
    //         return 0;
    //     }
    //     if(dp[m][n]!=-1){
    //         return dp[m][n];
    //     }
    //     int right = uniquePaths(m,n-1);
    //     int down = uniquePaths(m-1,n);
    //     return dp[m][n]=down+right;
    // }
}
