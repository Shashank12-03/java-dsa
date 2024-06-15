package arrays;

import java.util.*;
public class subarrayxor {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 2, 2, 6, 4}, 6));
    }
    public static int solve(int[] A, int B) {
        int count = 0;
        int xr = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<A.length;i++){
            xr ^= A[i];
            int x = xr^B;
            count += map.getOrDefault(x,0);
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
