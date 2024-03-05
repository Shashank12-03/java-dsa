package graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode994 {
    
    public static void main(String[] args) {
        int[][] isConnected={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(isConnected));
    }
    public static int orangesRotting(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2) {
                    visited[i][j]=2;
                    queue.add(new Pair(i, j, 0));
                }
                else{
                    visited[i][j]=0;
                }
            }
        }
        int time=0;
        int[] column={-1,0,1,0};
        int[] rowtrav={0,1,0,-1};
        while (!queue.isEmpty()) {
            Pair current=queue.poll();
            int r=current.first;
            int c=current.second;
            int tm=current.time;
            time=Math.max(tm,time);
            for (int i = 0; i <4; i++) {
                int row=r+rowtrav[i];
                int col=c+column[i];
                if (row>=0 && row<grid.length && col>=0 && col<grid[0].length && visited[row][col]==0 &&  grid[row][col]==1 ) {
                    queue.add(new Pair(row, col, tm+1));
                    visited[row][col]=2;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]!=2 && grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return time;
    }
}

class Pair {
    int first;
    int second;
    int time;
    public Pair(int first,int second,int time){
        this.first=first;
        this.second=second;
        this.time=time;
    }
}