package sorting;
import java.util.*;
public class leetcode441 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int ans=arrangeCoins(n);
        System.out.println(ans);
        t.close();
    }
    static int arrangeCoins(int n) {
        int i=0;
        while(n>i)
        {
            ++i;
            n=n-i;
        }
        return i;
    }
}
