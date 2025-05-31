package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode3341 {

    class Tuple{
        int row;
        int col;
        int time;
        Tuple(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        int[][] moveTime = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        leetcode3341 obj = new leetcode3341();
        int result = obj.minTimeToReach(moveTime);
        System.out.println("Minimum time to reach the bottom-right corner: " + result);
    }
    public int minTimeToReach(int[][] moveTime) {
        int[] tansRow = {0,1,0,-1};
        int[] tansCol = {-1,0,1,0};
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] distance = new int[n][m];
        for(int[] arr: distance){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.time-b.time); 
        pq.add(new Tuple(0,0,0));
        distance[0][0] = 0;

        while(!pq.isEmpty()){
            Tuple curr = pq.peek();
            pq.remove();
            int r = curr.row;
            int c = curr.col;
            int time = curr.time;

            if (time > distance[r][c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int row = r + tansRow[i];
                int col = c + tansCol[i];
                if (row >= 0 && row < n && col >= 0 && col < m) {
                    int newTime = Math.max(time + 1, moveTime[row][col]);
                    if (newTime < distance[row][col]) {
                        distance[row][col] = newTime;
                        pq.add(new Tuple(row, col, newTime));
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}


