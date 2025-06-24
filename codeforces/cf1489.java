import java.io.*;
import java.util.*;

public class cf1489 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(br.readLine()); 
        // for (int test = 0; test < t; test++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     int n = Integer.parseInt(st.nextToken()); 
        //     int k = Integer.parseInt(st.nextToken());

        //     int[] health = new int[n];
        //     st = new StringTokenizer(br.readLine());
        //     for (int i = 0; i < n; i++) {
        //         health[i] = Integer.parseInt(st.nextToken());
        //     }
        //     int[] ans = helper(health,k);
        //     for(int i = 0;i<n;i++){
        //         System.out.print(ans[i] + " ");
        //     }
        //     System.out.println();
        // }
        int[] testHealth = {2, 8, 3, 5};
        int[] result = helper(testHealth, 3);
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static int[] helper(int[] health, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(b[0],a[0]);
        });
        int[] ans = new int[health.length];
        for(int i = 0;i<health.length;i++){
            int val = health[i];
            val%=k;
            if(val==0) val = k; // Ensure that the value is not zero
            pq.add(new int[]{val,i});
        }
        int i = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            curr[0]-=k;
            if(curr[0]>0){
                pq.add(curr);
            }
            else{
                ans[i++] = curr[1] + 1; 
            }
        }
        return ans;
    }
}


