import java.util.Scanner;

public class codeforces995I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // Read n
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            // Read the array a
            System.out.println(helper(n,a,b,c));
            
            
        }
        scanner.close();
    }
    private static int helper(int n, int a, int b, int c){
        int ans = 0;
        int d = (a+b+c);
        ans += n/d;
        n = n%d;
        if (n>0 && n<=a) {
            ans++;
        }
        else if (n>a) {
            ans+=2;
        }
        else{
            ans+=3;
        }
        return ans;
    }
    
}
