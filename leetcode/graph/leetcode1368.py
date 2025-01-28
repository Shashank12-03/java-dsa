from collections import deque

class Solution:
    
    def minCost(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        directions = {1:[0, 1], 2:[0, -1], 3:[1, 0],4:[-1, 0]}
        
        queue = deque(([(0,0,0)]))
        n,m = len(grid),len(grid[0])
        
        min_cost =  {(0,0):0}
        
        while queue:
            r,c,cost = queue.popleft()
            if (r,c) == (n-1,m-1):
                return cost
            
            for d in directions:
                dr,dc = directions[d]
                nr,nc = r+dr, c+dc
                new_cost = cost if d==grid[r][c] else cost+1
                
                if (
                    nr<0 or nc<0 or nr==n or nc==m or new_cost>=min_cost.get((nr,nc),float("inf"))
                ):
                    continue
                min_cost[(nr,nc)] = new_cost
                if d==grid[r][c]:
                    queue.appendleft((nr,nc,new_cost))
                else:
                    queue.append((nr,nc,new_cost))