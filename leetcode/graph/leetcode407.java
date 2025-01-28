package graph;

import java.util.PriorityQueue;

public class leetcode407 {
    static class Pair {
        int height;
        int row;
        int col;
        Pair(int height, int row, int col){
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        leetcode407 solution = new leetcode407();
        int result = solution.trapRainWater(heightMap);
        System.out.println("Trapped rain water: " + result);
    }
    public int trapRainWater(int[][] heightMap) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.height, b.height);
        });
        int n = heightMap.length;
        int m = heightMap[0].length;
        int[] travRow = {-1,0,1,0};
        int[] travCol = {0,-1,0,1};
        int[][] visited = new int[n][m];

        for(int i = 0;i<n;i++){
            pq.add(new Pair(heightMap[i][0], i, 0));
            visited[i][0]=1;
            pq.add(new Pair(heightMap[i][m-1], i, m-1));
            visited[i][m-1]=1;
        }
        for(int i = 0;i<m;i++){
            pq.add(new Pair(heightMap[0][i], 0, i));
            visited[0][i]=1;
            pq.add(new Pair(heightMap[n-1][i], n-1, i));
            visited[n-1][i]=1;
        }
        int ans = 0;
        int maxHeight = -1;

        while (!pq.isEmpty()) {
            Pair pr = pq.poll();
            int height = pr.height;
            int r = pr.row;
            int c = pr.col;
            maxHeight = Math.max(maxHeight, height);
            ans += maxHeight-height;
            for (int i = 0; i < 4; i++) {
                int row = r + travRow[i];
                int col = c + travCol[i];

                if (row>=0 && row<n && col>=0 && col<m && visited[row][col]==0) {
                    pq.add(new Pair(heightMap[row][col], row, col));
                    visited[row][col] = 1;
                }
            }
        }
        return ans;
    }
}

