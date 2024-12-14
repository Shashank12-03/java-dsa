from collections import deque

class Solution(object):
    def longestSubarray(self, nums, limit):
        """
        :type nums: List[int]
        :type limit: int
        :rtype: int
        """
        max_q = deque()
        min_q = deque()
        
        left = 0
        ans = 0
        for right in range(0,len(nums)):
            
            while min_q and min_q[-1] > nums[right]:
                min_q.pop()
            
            while max_q and max_q[-1] < nums[right]:
                max_q.pop()
                
            min_q.append(nums[right])
            max_q.append(nums[right])
            
            while max_q[0] - min_q[0] > limit:
                
                if nums[left] == max_q[0]:
                    max_q.popleft()
                
                if nums[left] == min_q[0]:
                    min_q.popleft()
                
                left+=1
            
            ans  = max(ans, right - left +1)
        
        return ans

sol = Solution()
print(sol.longestSubarray([8,2,4,7],4))