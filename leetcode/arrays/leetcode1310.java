package arrays;


import java.util.Arrays;

public class leetcode1310 {
    public static void main(String[] args) {
        leetcode1310 sol = new leetcode1310();
        System.out.println(Arrays.toString(sol.xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}})));
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        int xor = arr[0];
        prefix[0] = xor;
        for(int i =1;i<arr.length;i++){
            xor ^= arr[i];
            prefix[i] = xor;
        }
        int[] ans = new int[queries.length];
        for(int i =0;i<queries.length;i++){
            if(queries[i][0]!=0){
                ans[i] = prefix[queries[i][0] - 1] ^ prefix[queries[i][1]];
            }else{
                ans[i] = prefix[queries[i][1]];
            }
        }
        return ans;
    }
}
