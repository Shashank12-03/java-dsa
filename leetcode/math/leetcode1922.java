package math;

public class leetcode1922 {
    public static void main(String[] args) {
        leetcode1922 solution = new leetcode1922();
        System.out.println(solution.countGoodNumbers(4));
    }
    private long powerMod(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        final int MOD = 1000000007;
        if(n==1){
            return 5;
        }
        long odd = n/2;
        long even = n-odd;
        long evenPer = powerMod(5, even, MOD);
        long oddPer = powerMod(4, odd, MOD);
        int result = (int)((oddPer * evenPer) % MOD);
        return result;
    }
}
