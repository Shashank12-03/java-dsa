import java.util.Arrays;

public class backtracking {
    public static void main(String[] args) {
        boolean[][] mazze={{true,true,true},{true,true,true},{true,true,true}};
        //bt("", mazze, 0, 0);
        int[][] path=new int[mazze.length][mazze[0].length];
        matrix("",mazze, 0, 0, path, 0);
    }
    static void bt(String p, boolean[][] mazze, int row,int col){
        if(row==mazze.length-1 && col==mazze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!mazze[row][col]){
            return;
        }
        //considering this block in my path
        mazze[row][col]=false;
        if(row<mazze.length-1){
            bt(p+'D', mazze, row+1, col);
        }
        if(col<mazze[0].length-1){
            bt(p+'R', mazze, row, col+1);
        }
        if(row>0){
            bt(p+'U', mazze, row-1, col);
        }
        if(col>0){
            bt(p+'L', mazze, row, col-1);
        }
        // this line is where the function will be over
        // before the function get removed,also remove te changes that were made by that function
        mazze[row][col]=true;
    }
    static void matrix(String p, boolean[][] mazze, int row,int col,int[][]path,int step){
        if(row==mazze.length-1 && col==mazze[0].length-1){
            path[row][col]=step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!mazze[row][col]){
            return;
        }
        //considering this block in my path
        mazze[row][col]=false;
        path[row][col]=step;
        if(row<mazze.length-1){
            matrix(p+'D', mazze, row+1, col, path, step+1);
        }
        if(col<mazze[0].length-1){
            matrix(p+'R', mazze, row, col+1, path, step+1);
        }
        if(row>0){
            matrix(p+'U', mazze, row-1, col, path, step+1);
        }
        if(col>0){
            matrix(p+'L', mazze, row, col-1, path, step+1);
        }
        // this line is where the function will be over
        // before the function get removed,also remove te changes that were made by that function
        mazze[row][col]=true;
        path[row][col]=0;
    }
}
