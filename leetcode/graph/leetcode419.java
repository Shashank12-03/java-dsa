package graph;

public class leetcode419 {
    public static void main(String[] args) {
        leetcode419 sol = new leetcode419();
        System.out.println(sol.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
    }
    int n;
    int m;
    public int countBattleships(char[][] board) {
        n = board.length;
        m = board[0].length;
        int[][] visited = new int[n][m];
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visited[i][j]!=1 && board[i][j]=='X'){
                    ans++;
                    dfs(board, visited,i,j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] board, int[][] visited, int i, int j){
        visited[i][j] = 1;
        if(i+1<n && board[i+1][j]=='X'){
            dfs(board, visited,i+1,j);
        }
        else if(j+1<m && board[i][j+1]=='X'){
            dfs(board, visited,i,j+1);
        }
    }
}
