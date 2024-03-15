package graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode1020 {
    public static void main(String[] args) {
        
    }
    public static int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited = new int[n][m];
        int[] checkRow={-1,0,1,0};
        int[] checkCol={0,-1,0,1};
        Queue<Pairs> store = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if (grid[i][j]==1) {
                        visited[i][j]=1;
                        store.add(new Pairs(i, j));
                    }
                }
            }
        }
        while (!store.isEmpty()) {
            Pairs current=store.poll();
            int r=current.first;
            int c=current.second;
            for (int j = 0; j <4; j++) {
                int row=r+checkRow[j];
                int col=c+checkCol[j];
                if (row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 && visited[row][col]==0) {
                    store.add(new Pairs(row, col));
                    visited[row][col]=1;
                }
            }
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1 && visited[i][j]==0) {
                    count++;
                }
            }
        }
        return count;
    }
}
class Pairs{
    int first;
    int second;
    public Pairs(int first,int second){
        this.first=first;
        this.second=second;
    }
}