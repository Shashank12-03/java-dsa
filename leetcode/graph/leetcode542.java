package graph;
import java.util.*;
public class leetcode542 {
    public static void main(String[] args) {

    }
    public static int[][] updateMatrix(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        int[][] dist = new int[mat.length][mat[0].length];
        Queue<Pair> store = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==0) {
                    store.add(new Pair(i, j, 0));
                    visited[i][j]=1;
                }else{
                    visited[i][j]=0;
                }
            }
        }
        int[] Col={0,1,0,-1};
        int[] Row={-1,0,1,0};
        while (!store.isEmpty()) {
            Pair pair=store.poll();
            int r=pair.first;
            int c=pair.second;
            int steps=pair.third;
            dist[r][c]=steps;
            for (int i = 0; i <4; i++) {
                int row=Row[i]+r;
                int col=Col[i]+c;
                if (row>=0 && row<mat.length && col>=0 && col<mat[0].length && visited[row][col]==0) {
                    visited[row][col]=1;
                    store.add(new Pair(row, col, steps+1));
                }
            }
        }
        return dist;
    }
}
class Pair {
    int first;
    int second;
    int third;
    public Pair(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}