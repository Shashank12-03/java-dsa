package codeft;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class B1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            String s = scanner.nextLine();
            System.out.println(helper(s.toCharArray()));
        }
        scanner.close();
    }
    private static int helper(char[] s) {
        int count = 0;
        int n = s.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i]==s[n-i-1]) {
                continue;
            }
            if (set.contains(Math.abs(s[i]-s[n-i-1]))) {
                count++;
                set.remove(Math.abs(s[i]-s[n-i-1]));
            } else {
                count++;
                set.add(Math.abs(s[i]-s[n-i-1]));
            }
        }
        if (set.size() > 0 || count==0)  {
           return -1; 
        }
        return count;
    }
}
