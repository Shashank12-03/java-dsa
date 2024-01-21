public class Nknights {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        horse(board, 0, 0, 4);
    }
    static void horse(boolean[][] board,int row,int col,int knights){
        if(knights==0){
            display(board);
            System.out.println();
            return;
        }
        if(row==board.length-1 && col==board.length){
            return;
        }
        if(col==board.length){
            horse(board, row+1,0, knights);
            return;
        }
        if(issafe(board,row,col)){
            board[row][col]=true;
            horse(board, row, col+1, knights-1);
            board[row][col]=false;
        }
        horse(board, row, col+1, knights);
    }
    static boolean isvalid(boolean[][] board,int row,int col){
        if(row>=0 && row<board.length && col>=0 && col< board.length){
            return true;
        }
        return false;
    }
    static boolean issafe(boolean[][]board,int row,int col){
        if(isvalid(board, row-2, col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }
        if(isvalid(board, row-1, col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }
        if(isvalid(board, row-2, col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }
        if(isvalid(board, row-1, col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }
        return true;
    } 
    static void display(boolean[][] board){
        for(boolean[] row:board){
            for(boolean element:row){
                if(element){
                    System.out.print("N ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
