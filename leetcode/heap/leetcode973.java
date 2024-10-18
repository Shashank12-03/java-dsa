package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode973 {
    public static void main(String[] args) {
        leetcode973 sol = new leetcode973();
        int[][] ans = sol.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        for (int[] is : ans) {
            System.out.println(Arrays.toString(is));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Dist> pq = new PriorityQueue<>(new Comparator<Dist>() {
            @Override
            public int compare(Dist d1, Dist d2){
                return d1.dist -d2.dist;
            }
        });
        for (int[] dist : points) {
            pq.add(new Dist(dist, dist[0]*dist[0] + dist[1]*dist[1]));
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (k>0) {
            int[] dist = pq.poll().points;
            ans[i++] = dist;
            k--;
        }
        return ans;
    }
}

class Dist{
    int[] points;
    int dist;
    Dist(int[] points,int dist){
        this.points = points;
        this.dist = dist;
    }
}