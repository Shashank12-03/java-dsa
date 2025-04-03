package round1005;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] suffix = new int[n];
            int[] prefix = new int[n];
            prefix[0] = Math.max(0, arr[0]);
            suffix[n - 1] = Math.max(0, -arr[n - 1]);
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + Math.max(0, arr[i]);
            }
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + Math.max(0, -arr[i]);
            }
            int ans = 0;

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, prefix[i] + suffix[i]);
            }
            System.out.print(ans);
            System.out.println();
        }
    }
}