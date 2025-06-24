

import java.util.Arrays;
import java.util.Scanner;



public class A902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] capacity = new int[n];
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                capacity[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                cost[i] = sc.nextInt();
            }
            A902 sol = new A902();
            System.out.println(sol.helper(n,p,capacity,cost));
        }
        sc.close();
        // System.out.println(helper(4,94,new int[]{1,4,2,3}, new int[]{110,94,86,57}));
    }
    private long helper(int n, int p, int[] capacity, int[] cost){
        long[][] pair = new long[n][2];
        for (int i = 0; i < n; i++) {
            pair[i] = new long[]{capacity[i], cost[i]};
        }
        Arrays.sort(pair,(a,b)->{
            if(a[1]==b[1]){
                return Long.compare(b[0],a[0]);
            }
            return Long.compare(a[1],b[1]);
        });
        long total = 1;
        long totalCost = p;
        // for (long[] is : pair) {
        //     System.out.println(Arrays.toString(is));
        // }
        for(int i = 0; i<n && total<n ; i++){
            if (p>pair[i][1]) {
                totalCost += (long)(pair[i][1]*Math.min(pair[i][0], n-total));
                total+=Math.min(pair[i][0], n-total);
            }
        }
        return totalCost += (long)((n-total)*p);
    }
}


