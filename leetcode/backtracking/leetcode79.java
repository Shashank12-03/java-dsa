package backtracking;

public class leetcode79 {
    public static void main(String[] args) {
        
    }
    public static boolean exist(char[][] board, String word) {
        return helper(0,0,0,board,word);
    }
    private static boolean helper(int ind, int row, int col, char[][] board, String word) {
        if(ind == word.length()){
            return true;
        }
        if (word.charAt(ind)==board[row][col]){
            helper(ind+1, row, col, board, word);
        }
        for(int i=0;i<word.length();i++){
            if()
        }

    }
}
