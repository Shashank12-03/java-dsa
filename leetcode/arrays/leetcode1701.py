class Solution(object):
    def averageWaitingTime(self, customers):
        """
        :type customers: List[List[int]]
        :rtype: float
        """
        
        start = customers[0][0]+customers[0][1]
        sums = start-customers[0][0]
        
        for i in range (1,len(customers)):
            if customers[i][0]>start:
                start = customers[i][0]+customers[i][1]
                sums += start- customers[i][0]
            else:
                start += customers[i][1]
                sums += start-customers[i][0]
        print(sums/len(customers))
        return float(sums/len(customers))
    
sol = Solution()
print(sol.averageWaitingTime([[5,2],[5,4],[10,3],[20,1]]))