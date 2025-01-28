package graph;


import java.util.LinkedList;
import java.util.Queue;

public class leetcode1926 {
    public static void main(String[] args) {
        
        char[][] maze = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};
        leetcode1926 solution = new leetcode1926();
        int result = solution.nearestExit(maze, entrance);
        System.out.println("The nearest exit is " + result + " steps away.");
    }
    int n;
    int m;
    public int nearestExit(char[][] maze, int[] entrance) {
        n = maze.length;
        m = maze[0].length;
        int[] travRow = {-1,0,1,0};
        int[] travCol = {0,-1,0,1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0],entrance[1],0});
        int[][] visited = new int[n][m];
        visited[entrance[0]][entrance[1]] = 1;

        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int x = currPos[0];
            int y = currPos[1];
            int step = currPos[2];
            
            for(int k = 0;k<4;k++){
                int row = x + travRow[k];
                int col = y + travCol[k];
                if(row>=0 && row<n && col>=0 && col<m && maze[row][col]=='.' && visited[row][col]==0){
                    if ((row == 0 || row == n - 1 || col == 0 || col == m - 1) && !(row == entrance[0] && col == entrance[1])) {
                        return step+1;
                    } 
                    queue.add(new int[]{row,col,step+1});
                    visited[row][col] = 1;
                }
            }
        }
        return -1;
    }
}
