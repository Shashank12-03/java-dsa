package round1005;

import java.util.Scanner;


public class A {
    static Scanner sc = new Scanner(System.in);

    private static void printInt(int a) {
        System.out.print(a);
    }

    private static void ln() {
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solution();
        }
    }

    public static void solution() {
        int n = sc.nextInt();
        String s = sc.next();
        int ans = 0;
		for(int i=1;i<n;i++){
			if (s.charAt(i-1)!=s.charAt(i)) {
				ans++;
			}
		}
		if (s.charAt(0)=='1') {
			ans++;
		}

        printInt(ans);
        ln();
    }
}