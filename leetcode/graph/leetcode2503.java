package graph;

import java.util.*;

public class leetcode2503 {
    
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 4},
            {3, 4, 3},
            {2, 1, 2}
        };
        int[] queries = {3, 4, 2};
        leetcode2503 obj = new leetcode2503();
        int[] result = obj.maxPoints(grid, queries);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    int[] travRow = {-1, 0, 1, 0};
    int[] travCol = {0, -1, 0, 1};
    int n, m;

    public int[] maxPoints(int[][] grid, int[] queries) {
        n = grid.length;
        m = grid[0].length;

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        pq.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        int[] result = new int[queries.length];
        int count = 0;

        for (int[] query : sortedQueries) {
            int queryValue = query[0];
            int queryIndex = query[1];

            while (!pq.isEmpty() && grid[pq.peek()[0]][pq.peek()[1]] < queryValue) {
                int[] cell = pq.poll();
                int i = cell[0];
                int j = cell[1];
                count++;

                for (int k = 0; k < 4; k++) {
                    int row = i + travRow[k];
                    int col = j + travCol[k];
                    if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]) {
                        visited[row][col] = true;
                        pq.add(new int[]{row, col});
                    }
                }
            }

            // Store the result for the current query
            result[queryIndex] = count;
        }

        return result;
    }
}