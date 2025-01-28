package arrays;

import java.util.HashMap;
import java.util.Map;

public class leetcode2661 {

    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row =row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) {
        
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] Row = new int[n];
        int[] Col = new int[m];
        Map<Integer,Pair> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                map.put(mat[i][j],new Pair(i,j));
            }
        }
        for(int i = 0;i<arr.length;i++){
            Pair pair = map.get(arr[i]);
            Row[pair.row]++;
            Col[pair.col]++;
            if(Row[pair.row]==m || Col[pair.col]==n){
                return i;
            }
        }
        return n;
    }
}
