package string;

public class leetcode1405 {
    public static void main(String[] args) {
        leetcode1405 sol = new leetcode1405();
        System.out.println(sol.longestDiverseString(0,8,11));
    }
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder str = new StringBuilder();
        helper(a,b,c,0,0,0,str);
        return str.toString();
    }
    private void helper(int a, int b, int c, int countA, int countB, int countC,StringBuilder result){
        if (a == 0 && b == 0 && c == 0) {
            return;
        }

        if ((a >= b && a >= c && countA < 2) || (countB == 2 && a > 0) || (countC == 2 && a > 0)) {
            result.append('a');
            helper(a - 1, b, c, countA + 1, 0, 0, result);
        }
        else if ((b >= a && b >= c && countB < 2) || (countA == 2 && b > 0) || (countC == 2 && b > 0)) {
            result.append('b');
            helper(a, b - 1, c, 0, countB + 1, 0, result);
        }
        else if ((c >= a && c >= b && countC < 2) || (countA == 2 && c > 0) || (countB == 2 && c > 0)) {
            result.append('c');
            helper(a, b, c - 1, 0, 0, countC + 1, result);
        }
    }
}
