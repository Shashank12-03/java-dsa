package backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'7', '8', '0', '4', '0', '0', '1', '2', '0'},
                {'6', '0', '0', '0', '7', '5', '0', '0', '9'},
                {'0', '0', '0', '6', '0', '1', '0', '7', '8'},
                {'0', '0', '7', '0', '4', '0', '2', '6', '0'},
                {'0', '0', '1', '0', '5', '0', '9', '3', '0'},
                {'9', '0', '4', '0', '6', '0', '0', '0', '5'},
                {'0', '7', '0', '3', '0', '0', '0', '1', '2'},
                {'1', '2', '0', '0', '0', '7', '4', '0', '0'},
                {'0', '4', '9', '2', '0', '6', '0', '0', '7'}
        };
        solve(board);
        display(board);
    }
    
    static boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '0') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }
        if (emptyLeft) {
            return true;
        }
        for (char number = '1'; number <= '9'; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '0';
                }
            }
        }
        return false;
    }
    
    static void display(char[][] board) {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    
    static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        for (char[] chars : board) {
            if (chars[col] == num) {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
