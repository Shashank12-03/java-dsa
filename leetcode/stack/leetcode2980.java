package stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode2980 {
    public static void main(String[] args) {
        leetcode2980 sol = new leetcode2980();
        System.out.println(Arrays.toString(sol.leftmostBuildingQueries(new int[]{5,3,8,2,6,1,4,6}, new int[][]{{0,7},{3,5},{5,2},{3,0},{1,6}})));
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] stk = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        stk[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            if(stack.isEmpty()){
                stk[i]=-1;
            }else{
                while (!stack.isEmpty() && heights[stack.peek()]<=heights[i]) {
                    stack.pop();
                }
                int x = i;
                if(!stack.isEmpty()){
                    stk[i]= stack.peek();
                }else{
                    stk[i]=-1;
                }
                stack.push(x);
            }
        }   
        System.out.println(Arrays.toString(stk));
        int[] ans = new int[queries.length];
        for(int i = 0;i<ans.length;i++){
            if(heights[queries[i][0]]<=heights[queries[i][1]]){
                ans[i] = heights[queries[i][1]];
            }
            if(queries[i][0]==queries[i][1]){
                ans[i] = queries[i][0];
            }
            else if(heights[queries[i][0]]==-1 || heights[queries[i][1]]==-1){
                ans[i] = -1;
            }
            else{
                ans[i] = heights[Math.max(queries[i][0],queries[i][1])];
            }
        }
        return ans;
    }
}
