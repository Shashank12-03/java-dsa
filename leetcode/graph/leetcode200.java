package graph;
class Pairs{
    int first;
    int second;
    public Pairs(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class leetcode200 {
    public static void main(String[] args) {
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
    static int rowLength;
    static int coLength;
    static char[][] g;
    static int count;

    public static int numIslands(char[][] grid) {
        rowLength = grid.length;
        coLength = grid[0].length;
        g = grid;
        count = 0;
        for (int i = 0; i < rowLength; i++) {
            check(g[i], i);
        }
        return count;
    }

    public static void check(char[] g, int i) {
        for (int j = 0; j < coLength; j++) {
            if (g[j] == '1') {
                bfs(i, j);
                count++;
            }
        }
    }

    public static void bfs(int i, int j) {
        // In the bfs method, g[i][j] = '2'; is used to mark the cell at position (i, j)
        // as visited
        g[i][j] = '2';
        if (i - 1 >= 0 && g[i - 1][j] == '1') {
            bfs(i - 1, j);
        }
        if (i + 1 < rowLength && g[i + 1][j] == '1') {
            bfs(i + 1, j);
        }
        if (j - 1 >= 0 && g[i][j - 1] == '1') {
            bfs(i, j - 1);
        }
        if (j + 1 < coLength && g[i][j + 1] == '1') {
            bfs(i, j + 1);
        }
    }
    // public static int numIslands(char[][] grid) {
    //     int count=0;
    //     int[][] visited=new int[grid.length][grid[0].length];
    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             if (visited[i][j]==0 && grid[i][j]=='1') {
    //                 count++;
    //                 bfs(i,j,visited,grid);
    //             }
    //         }
    //     }
    //     return count;
    // }
    // private static void bfs(int row, int col, int[][] visited, char[][] grid) {
    //     visited[row][col] = 1;
    //     Queue<Pairs> queue = new LinkedList<>();
    //     queue.add(new Pairs(row, col));
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    //     while (!queue.isEmpty()) {
    //         Pairs pair = queue.poll();
    //         int r = pair.first;
    //         int c = pair.second;
    //         for (int[] dir : directions) {
    //             int newRow = r + dir[0];
    //             int newCol = c + dir[1];
    //             if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0) {
    //                 visited[newRow][newCol] = 1;
    //                 queue.add(new Pairs(newRow, newCol));
    //             }
    //         }
    //     }
    // }
    // if all directions
    // private static void bfS(int row, int col, int[][] visited, char[][] grid) {
    //     visited[row][col]=1;
    //     Queue<Pairs> list=new LinkedList<Pairs>();
    //     list.add(new Pairs(row,col));
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     while (!list.isEmpty()) {
    //         Pairs pair=list.poll();
    //         int ro=pair.first;
    //         int co=pair.second;
    //         for (int delrow = -1; delrow <=1; delrow++) {
    //             for (int delcol = -1; delcol <=1; delcol++){
    //                 int newRow=ro+delrow;
    //                 int newCol=co+delcol;
    //                 if (newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]=='1' && visited[newRow][newCol]==0) {
    //                     visited[newRow][newCol]=1;
    //                     list.add(new Pairs(newRow,newCol));
    //                 }
    //             }
    //         }
    //     }
    // }
}
