package backtracking;

import java.util.ArrayList;

import java.util.List;

public class leetcode61 {
    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        System.out.println(ans);
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        System.out.println(helper(board,0,ans,new ArrayList<>()));
        return ans;
    }
    private static int helper(boolean[][] board, int row,List<List<String>> ans,List<String> list) {
        if(row==board.length){
            list.clear(); // Reset the list for the new solution
            for (boolean[] arr : board) {
                StringBuilder str = new StringBuilder("");
                for (boolean element : arr) {
                    if (element) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }
            ans.add(new ArrayList<>(list)); // Add a copy of the list to the answer
            return 1;
        }
        int count  =0;
        for (int col = 0; col < board[0].length; col++) {
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count+= helper(board,row+1,ans,list);
                board[row][col]=false;
            }
        }
        return count;
    }
    private static boolean isSafe(boolean[][] board, int row, int col) {
        //vertical row
        for(int i = 0;i<row;i++){
            if (board[i][col]) {
                return false;
            }
        }
        //diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }
        //diagonal right
        int maxRight= Math.min(row, board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    public static void display(boolean[][] board){
        for(boolean[] row:board){
            for(boolean element:row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
