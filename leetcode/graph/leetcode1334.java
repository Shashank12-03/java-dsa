package graph;

import java.util.Arrays;

public class leetcode1334 {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(new leetcode1334().findTheCity(n, edges, distanceThreshold));
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for(int[] dist:distance){
            Arrays.fill(dist,1000000000);
        }
        for(int[] edge:edges){
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }
        for(int i = 0;i<n;i++){
            distance[i][i] = 0;
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    distance[i][j] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        for (int[] is : distance) {
            System.out.println(Arrays.toString(is));
        }
        int ans = 0;
        int min = n;
        for(int i = 0;i<n;i++){
            int cities = 0;
            for(int j = 0;j<n;j++){
                if(distance[i][j]<=distanceThreshold){
                    cities++;
                }
            }
            if(min>=cities){
                ans = i;
                min = cities;
            }
        }
        return ans;
    }
}
