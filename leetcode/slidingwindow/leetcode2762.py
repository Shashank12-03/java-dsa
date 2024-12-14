from collections import deque

class Solution():
    def continuousSubarrays(self, nums):
        """
        :type nums: List[int]
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
            
            while max_q[0] - min_q[0] > 2 :
                
                if nums[left] == max_q[0]:
                    max_q.popleft()
                
                if nums[left] == min_q[0]:
                    min_q.popleft()
                
                left+=1
            
            ans  += (right-left+1)
        
        return ans
    
sol = Solution()
print(sol.continuousSubarrays([5,4,2,4]))