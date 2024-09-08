class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [[0 for _ in range(n)]for _ in range(n)]
        for i in range(n):
            dp[n-1][i] = 0
        
        return self.helper(nums,-1,0,dp)
    
    def helper(self,nums,prev,ind,dp):
        if ind ==len(nums):
            return 0
        
        if dp[ind][prev] !=-1:
            return dp[ind][prev]
        notTake = self.helper(nums,prev,ind+1,dp)
        take = 0
        if prev==-1 or nums[prev]<nums[ind]:
            take = 1 + self.helper(nums,ind,ind+1,dp)
            
        dp[ind][prev] = max(take,notTake)
        return dp[ind][prev] 
    
sol = Solution()
print(sol.lengthOfLIS([10,9,2,5,3,7,101,18]))

