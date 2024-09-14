import sys

class Solution:
    def matrixMultiplication(self, N, arr):
        dp = [[-1 for _ in range(N)]for _ in range(N)]
        return self.helper(1,N-1,arr,dp)
    
    def helper(self,i,j,arr,dp):
        
        if i==j:
            return 0
        
        mini = sys.maxsize
        
        if dp[i][j] !=-1:
            return dp[i][j]
        
        for k in range(i,j):
            steps = (arr[i-1]*arr[k]*arr[j]) + self.helper(i,k,arr,dp) + self.helper(k+1,j,arr,dp)
            mini = min(steps,mini)
            
        dp[i][j] = mini 
        
        return mini
    
sol = Solution()
print(sol.matrixMultiplication(5,[10,20,30,40,50]))