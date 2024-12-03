class Solution(object):
    def diffWaysToCompute(self, expression):
        """
        :type expression: str
        :rtype: List[int]
        """
        operations = {
            "+":lambda x,y : x+y,
            "-":lambda x,y : x-y,
            "*":lambda x,y : x*y
        }

        def backtrack(left,right):
            result = []

            for i in range(left,right+1):
                op = expression[i]
                if op in operations:
                    num1 = backtrack(left,i-1)
                    num2 = backtrack(i+1,right)
                    for n1 in num1:
                        for n2 in num2:
                            cal = operations[op](n1,n2)
                            result.append(cal)
            if result == []:
                result.append(int(expression[left:right+1]))
            
            return result
        
        return backtrack(0,len(expression)-1)
        
sol = Solution()
print(sol.diffWaysToCompute("2-1-1"))