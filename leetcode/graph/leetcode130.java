package graph;

public class leetcode130 {
    public static void main(String[] args) {
        
    }
    public static void solve(char[][] board) {
        char[][] useBoard=board;
        int n=board.length;
        int m=board[0].length;
        int[] checkRow={-1,0,1,0};
        int[] checkCol={0,-1,0,1};
        int[][] visited=new int[n][m];
        for (int i = 0; i < m; i++) {
            //first row
            if (visited[0][i]==0 && useBoard[0][i]=='O') {
                dfs(0,i,n,m,visited,useBoard,checkRow,checkCol);
            }
            //last row
            if (visited[n-1][i]==0 && useBoard[n-1][i]=='O') {
                dfs(n-1, i, n, m, visited, useBoard, checkRow, checkCol);
            }
        }
        for (int i = 0; i < n; i++) {
            //first col
            if (visited[i][0]==0 && useBoard[i][0]=='O') {
                dfs(i,0,n,m,visited,useBoard,checkRow,checkCol);
            }
            //last row
            if (visited[i][m-1]==0 && useBoard[i][m-1]=='O') {
                dfs(i,m-1, n, m, visited, useBoard, checkRow, checkCol);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]==0 && useBoard[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }
    private static void dfs(int r, int c, int n, int m, int[][] visited, char[][] useBoard, int[] checkRow,int[] checkCol) {
        visited[r][c]=1;
        for (int i = 0; i <4; i++) {
            int row=checkRow[i]+r;
            int col=checkCol[i]+c;
            if (row>=0 && row<n && col>=0 && col<m && visited[row][col]==0 && useBoard[row][col]=='O') {
                dfs(row, col, n, m, visited, useBoard, checkRow, checkCol);
            }
        }
    }
}
