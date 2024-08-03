package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode1091 {
    public static void main(String[] args) {
        
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==1 && grid[0].length==1){
            if ( grid[0][0]==0){
                return 1;
            }else{
                return -1;
            }
        }
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }
        int[][] distance = new int[grid.length][grid[0].length];
        for(int[] arr:distance){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,0));

        int[][] directions = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;

            for(int[] dir : directions) {
                int ro = row + dir[0];
                int co = col + dir[1];
                if(ro >= 0 && ro < grid.length && co >= 0 && co < grid[0].length && grid[ro][co] == 0 && dist + 1 < distance[ro][co]) {
                    distance[ro][co] = dist + 1;
                    if(ro == grid.length - 1 && co == grid[0].length - 1) {
                        return distance[ro][co]+1;
                    }
                    queue.add(new Pair(ro, co, dist + 1));
                }
            }
        }
        return -1;
    }
}
class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row =row;
        this.col = col;
        this.dist = dist;
    }
}
