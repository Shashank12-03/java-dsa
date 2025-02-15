package graph;

import java.util.*;

public class leetcode827 {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0},
            {0, 1}
        };
        leetcode827 solution = new leetcode827();
        int result = solution.largestIsland(grid);
        System.out.println("Largest island area: " + result);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int color = 2;
        int[][] visited = new int[n][m];

        // Use DFS to find all islands and assign a unique color to each island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int area = dfs(i, j, color, visited, grid);
                    map.put(color, area);
                    color++;
                }
            }
        }

        int maxArea = 0;
        boolean hasZero = false;

        // Calculate the potential area for each 0 in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> seenColors = new HashSet<>();
                    int area = 1; // Convert this 0 to 1
                    for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] > 1) {
                            int clr = grid[ni][nj];
                            if (!seenColors.contains(clr)) {
                                area += map.get(clr);
                                seenColors.add(clr);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        if (!hasZero) {
            return n * m;
        }

        return maxArea;
    }

    private int dfs(int i, int j, int color, int[][] visited, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1 || visited[i][j] == 1) {
            return 0;
        }
        visited[i][j] = 1;
        grid[i][j] = color;
        int area = 1;
        for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            area += dfs(i + dir[0], j + dir[1], color, visited, grid);
        }
        return area;
    }
}
