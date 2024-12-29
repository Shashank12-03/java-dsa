package greedy;

import java.util.PriorityQueue;

public class leetcode1792 {
    public static void main(String[] args) {
        leetcode1792 sol = new leetcode1792();
        System.out.println(sol.maxAverageRatio(new int[][]{ {1, 2},{3, 5},{2, 2}}, 2));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            double ratio1 = ((double) (a.pass + 1) / (a.total + 1)) - ((double) a.pass / a.total);
            double ratio2 = ((double) (b.pass + 1) / (b.total + 1)) - ((double) b.pass / b.total);
            return Double.compare(ratio2, ratio1);
        });
        for(int[] currclass : classes){
            pq.offer(new Pair(currclass[0],currclass[1]));
        }
        while(extraStudents>0){
            Pair pair = pq.poll();
            int pass = pair.pass+1;
            int total = pair.total+1;
            pq.offer(new Pair(pass,total));
            extraStudents--;
        }
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int pass = pair.pass;
            int total = pair.total;
            ans+=((double)pass/total);
        }
        return ans/n;
    }
}

class Pair{
    int pass;
    int total;
    Pair(int pass, int total){
        this.pass = pass;
        this.total = total;
    }
}
