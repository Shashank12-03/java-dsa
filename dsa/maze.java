import java.util.*;

public class maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        path("", 3, 3);
        System.out.println((allpath("", 3, 3)));
        boolean[][] mazze={{true,true,false},{true,false,true},{true,true,true}};
        pathobs("", mazze, 0, 0);
    }
    static int count(int row, int col){
        if(row==1 || col==1){
            return 1;
        }
        int down=count(row-1, col);
        int right=count(row, col-1);
        return down+right;
    }
    static void path(String p,int row, int col){
        if(row==1 && col==1){
            System.out.println(p);
            return;
        }
        if(row>1){
            path(p+'D', row-1, col);
        }
        if(col>1){
            path(p+'R', row, col-1);
        }
    }
    static ArrayList<String> allpath(String p,int row, int col){
        if(row==1 && col==1){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list= new ArrayList<>();
        if(row>1 && col>1){
            list.addAll(allpath(p+'d', row-1, col-1));
        }
        if(row>1){
            list.addAll(allpath(p+'D', row-1, col));
        }
        if(col>1){
            list.addAll(allpath(p+'R', row, col-1));
        }
        return list;
    }
    static void pathobs(String p,boolean[][] mazze,int row, int col){
        if(row==mazze.length-1 && col==mazze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!mazze[row][col]){
            return;
        }
        if(row<mazze.length-1){
            pathobs(p+'D', mazze, row+1, col);
        }
        if(col<mazze[0].length-1){
            pathobs(p+'R', mazze, row, col+1);
        }
    }
}
