class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        left = 0
        right = len(height)-1
        maxLeft = maxRight = 0
        res = 0
        while left<= right:
            if height[left]<=height[right]:
                if(maxLeft<= height[left]):
                    maxLeft = height[left]
                else:
                    res += maxLeft-height[left]
                left+=1
            else:
                if(maxRight<= height[right]):
                    maxRight = height[right]
                else:
                    res += maxRight-height[right]
                right-=1
        return res
    
sol = Solution()
print(sol.trap([0,1,0,2,1,0,1,3,2,1,2,1]))