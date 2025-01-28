package graph;

import java.util.*;

public class leetcode1368 {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 3},
            {3, 2, 2},
            {1, 1, 4}
        };
        leetcode1368 solution = new leetcode1368();
        int result = solution.minCost(grid);
        System.out.println(result);
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        queue.offer(new int[]{0, 0, 0});
        map.put("0,0", 0);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            for (int i = 0; i < 4; i++) {
                int row = r + directions[i][0];
                int col = c + directions[i][1];
                int newCost = cost;
                if (i + 1 != grid[r][c]) {
                    newCost += 1;
                }
                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }
                String key = row + "," + col;
                if (newCost >= map.getOrDefault(key, Integer.MAX_VALUE)) {
                    continue;
                }
                map.put(key, newCost);
                if (i + 1 == grid[r][c]) {
                    queue.offer(new int[]{row, col, newCost});
                } else {
                    queue.addFirst(new int[]{row, col, newCost});
                }
            }
        }
        return map.getOrDefault((n - 1) + "," + (m - 1), 0);
    }
}