
class Solution(object):
    def missingRolls(self, rolls, mean, n):
        """
        :type rolls: List[int]
        :type mean: int
        :type n: int
        :rtype: List[int]
        """
        sum  = 0
        for roll in rolls:
            sum+=roll
        
        remaining_sum = mean*(n+len(rolls))-sum
        
        require_sum =(int) (remaining_sum/n)
        
        mod = remaining_sum%n
        
        ans = []
        for i in range(0,mod):
            ans.append(require_sum+1)
        for i in range(mod,n):
            ans.append(require_sum)
        
        return ans
    
sol = Solution()
print(sol.missingRolls([3,2,4,3],4,2))