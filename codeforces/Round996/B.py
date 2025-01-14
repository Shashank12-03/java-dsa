class Solution:
    
    def helper(arr1,arr2):
        defi = 0
        sufi = 0
        
        for i in range(0,len(arr1)):
            if arr1[i]>=arr2[2]:
                sufi+= arr1[i]-arr2[i]
            else:
                defi+= arr2[i]- arr1[i]
                
        return defi <= sufi

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr1 = list(map(int, input().split()))
        arr2 = list(map(int, input().split()))
        sol = Solution()
        if sol.helper(arr1, arr2):
            print("YES")
        else:
            print("NO")