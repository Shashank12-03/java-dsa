package graph;

public class leetcode723 {
    public static void main(String[] args) {
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image, 1, 1, 2);
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initcolor=image[sr][sc];
        int[] checkRow={0,1,0,-1};
        int[] checkCol={-1,0,1,0};
        int[][] ans=image;
        dfs(image,ans,sr,sc,initcolor,color,checkRow,checkCol);
        return ans;
    }
    private static void dfs(int[][] image, int[][] ans, int ro, int co, int initcolor, int color, int[] checkRow,
            int[] checkCol) {
        ans[ro][co]=color;
        for (int i = 0; i<4; i++) {
            int row=ro+checkRow[i];
            int col=co+checkCol[i];
            if (row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col]==initcolor && ans[row][col]!=color) {
                dfs(image, ans, row, col, initcolor, color, checkRow, checkCol);
            }
        }
    }
}
