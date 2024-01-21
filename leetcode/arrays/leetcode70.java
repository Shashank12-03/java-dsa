package arrays;

public class leetcode70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        return helper(n,0);
    }
    private static int helper(int n, int ans){
        // if(n<=1){
        //     return 1;
        // }
        // ans+=helper(n-1,ans)+helper(n-2,ans);
        // return ans;
        int first=0;
        int second=1;
        for (int i = 0; i < n; i++) {
            if(i<=1){
                ans=i;
            }
            ans=first+second;
            first=second;
            second=ans;
        }
        return ans;
    }
}
