def findMinArrowShots(points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points.sort()
        count=len(points)
        prev=points[0]
        for i in range(1,len(points)):
            curr=points[i]
            if curr[0]<=prev[1]:
                count-=1
                prev=[curr[0],min(curr[1],prev[1])]
            else:
                prev=curr
        
        return count
    
points = [[10, 16], [2, 8], [1, 6], [7, 12]]

print("Minimum number of arrows needed:", findMinArrowShots(points))