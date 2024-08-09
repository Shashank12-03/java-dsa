package dp;

// import java.util.Arrays;

public class ninjaTraining {
    public static void main(String[] args) {
        ninjaTraining sol = new ninjaTraining();
        System.out.println(sol.maximumPoints(new int[][]{{1,2,5},{3,1,1},{3,3,3}}, 3));
    }
    public int maximumPoints(int arr[][], int N) {
        // code here
        int[][] dp = new int[N][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        // int points = 0;
        // int last = 0;
        for(int i =1;i<N;i++){
            for(int j = 0;j<4;j++){
                // int max=0;
                dp[i][j]=0;
                for(int k =0;k<3;k++){
                    if(k!=j){
                        int point = arr[i][k]+dp[i-1][k];
                        dp[i][k] = Math.max(dp[i][j],point);
                    }
                }
            }
        }
        return dp[N-1][3];
    }
    public int helper(int[][]arr,int ind,int last,int[][]dp){
        if(ind ==0){
            int max = 0;
            for(int i =0;i<3;i++){
                if(i!=last){
                    max = Math.max(max,arr[ind][i]);    // dp[ind][i]=max;
                }
            }
            return max;
        }
        if(dp[ind][last]!=-1){
            return dp[ind][last];
        }
        int max =0;
        // int index = 0;
        for(int i =0;i<3;i++){
                if(i!=last){
                    int point = arr[ind][i]+helper(arr,ind-1,i,dp);
                    max = Math.max(max,point);
                }
            }
        return dp[ind][last]=max;
    }
}
