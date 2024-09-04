class Solution:
    def construct2DArray(self, original, m, n):
        return [original[i:i+n] for i in range(0,len(original),n)]  if m*n==len(original) else []

sol = Solution()
print(sol.construct2DArray([1,2,3,4],2,2))
