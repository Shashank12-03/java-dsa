package arrays;
import java.util.*;
public class leetcode2482 {
    public static void main(String[] args) {
        int[][] grid={{0,1,1},{1,0,1},{0,0,1}};
        int[][] ans=onesMinusZeros(grid);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] onesMinusZeros(int[][] grid) {
        int[]onesrow=new int[grid.length];
        int[]onescol=new int[grid[0].length];

        int[][]ans=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    onesrow[i]++;
                }
            }
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1){
                    onescol[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(onesrow));
        System.out.println(Arrays.toString(onescol));
        for(int i=0;i<onesrow.length;i++){
            for(int j=0;j<onescol.length;j++){
                ans[i][j]=onesrow[i]+onescol[j]-(onesrow.length-onesrow[i])-(onescol.length-onescol[j]);
            }
        }
        return ans;
    }
}
