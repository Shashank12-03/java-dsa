class Solution:
    
    def tribonacci(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [-1 for _ in range(n+1)]
        return self.helper(n,dp)
        
    def helper(self,ind,dp):
        
        if ind==0:
            return ind
        if ind==1 or ind==2:
            return 1
        
        if (dp[ind]!=-1):
            return dp[ind]
        

        dp[ind] = self.helper(ind-1,dp) + self.helper(ind-2,dp) + self.helper(ind-3,dp)
        return dp[ind]
    
sol = Solution()
print(sol.tribonacci(4))