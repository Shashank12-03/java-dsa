package round1005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int t = sc.nextInt();
        while (t--> 0) {
            solution();
        }
    }
    private static void solution(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int right = 0;
        int len = 0;
        int ansr = -1;
        int ansl = -1;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, i);
            while (right<n && map.get(arr[right])==1) {
                right++;
            }
            if (right-i>len) {
                len = right-i;
                ansl = i;
                ansr = right-1;
            }
        }
        if (ansl==-1) {
            System.out.println(0);
        }
        else{
            System.out.println((ansl + 1) + " " + (1 + ansr));
        }
    }
}
