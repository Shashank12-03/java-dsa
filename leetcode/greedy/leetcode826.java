package greedy;

import java.util.Arrays;
public class leetcode826 {
    
    public static void main(String[] args) {
        leetcode826 sol = new leetcode826();
        System.out.println(sol.maxProfitAssignment(new int[]{7,20,68}, new int[]{26,28,57}, new int[]{71,20,71}));
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int[][] job = new int[difficulty.length][2];
        for (int i = 0; i < job.length; i++) {
            job[i] = new int[]{difficulty[i],profit[i]};
        }
        Arrays.sort(job, (a,b)->(a[0]-b[0]));
        Arrays.sort(worker);
        int j = 0;
        int totalProfit = 0;
        int prof = 0;
        for (int ability : worker){
            while(j<job.length && ability>=job[j][0]){
                prof = Math.max(prof,job[j][1]);
                j++;
            }
            totalProfit+=prof;
        }
        return totalProfit;
    }
}
