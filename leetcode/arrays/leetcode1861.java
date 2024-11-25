package arrays;

import java.util.Arrays;

public class leetcode1861 {
    public static void main(String[] args) {
        leetcode1861 sol = new leetcode1861();
        char[][] ans = sol.rotateTheBox(new char[][]{{'#', '#', '*', '.', '*', '.'},
        {'#', '#', '#', '*', '.', '.'},
        {'#', '#', '#', '.', '#', '.'}});
        for (char[] cs : ans) {
            System.out.println(Arrays.toString(cs));
        }
    }

    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] rotated = new char[m][n];
        for(int i = n;i>0;i--){
            for(int j =0;j<m;j++){
                rotated[j][n-i] = box[i-1][j];
            }
        }
        for(int i = 0;i<n;i++){
            int st = 0;
            int en = m-1;
            while(st<=en){
                
            }
        }
        return rotated;
    }
}
