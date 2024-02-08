package dp;
public class leetcode279 {
    /*
     * 
    1. Calculate the square root of the given integer `n` and store it in the variable `sqrt`.
    
    2. Check if `n` itself is a perfect square. If it is, return 1 because only one perfect square (the number itself) is needed to represent `n`.

    3. While `n` is divisible by 4, keep dividing it by 4. This step is for optimization purposes, and it essentially reduces `n` to its square-free part. This is because any perfect square can only have the prime factorization of the form \(2^{2k} \times x\), where \(x\) is an odd number. If `n` has factors of 4, they can be factored out.

    4. Check if `n` modulo 8 equals 7. If it does, return 4. This check is based on Lagrange's four-square theorem, which states that any natural number can be represented as the sum of at most four perfect squares. The condition `n % 8 == 7` covers cases where the number is of the form \(4^k \times (8m + 7)\).

    5. Iterate through all numbers from 1 to the square root of `n`. For each number `i`, calculate its square and subtract it from `n`. Calculate the square root of the result and store it in the variable `base`. If `base` squared equals the remaining difference (`n - square`), return 2 because two perfect squares (`i*i` and `base*base`) sum up to `n`.

    6. If none of the above conditions are met, return 3, which implies that `n` can be represented as the sum of three perfect squares.

     */
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int sqr=(int)Math.sqrt(n);
        if (sqr*sqr==n) {
            return 1;
        }
        while (n%4==0) {
            n=n/4;
        }
        if (n%8==7) {
            return 4;
        }
        for (int i = 1; i <= n; i++) {
            int sqrt=i*i;
            int base=(int) Math.sqrt(n-sqrt);
            if (base*base==n-sqrt) {
                return 2;
            }
        }
        return 3;
        // int index=0;
        // int[] squares={1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484, 529, 576, 625, 676, 729, 784, 841, 900, 961, 1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209, 2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 3721, 3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329, 5476, 5625, 5776, 5929, 6084, 6241, 6400, 6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649, 8836, 9025, 9216, 9409, 9604, 9801};
        // for (int i = 0; i < squares.length; i++) {
        //     if(squares[i]<=n/2){
        //         index++;
        //     }else{
        //         break;
        //     }
        // }
        // return coinChange( Arrays.copyOfRange(squares, 0, index), n);
    }
    // public static int coinChange(int[] coins, int amount) {
    //     int[][]dp=new int[coins.length][amount+1];
        
    //     for (int[] is : dp) {
    //         Arrays.fill(is,-1);
    //     }
    //     int ans=helper(coins.length-1,coins,amount,dp);
    //     if (ans>=(int) Math.pow(10, 9)) {
    //         return -1;
    //     }
    //     return ans;
    // }
    // public static int helper(int index, int[] coins,int amount,int[][]dp) {
    //     if (index==0) {
    //         if (amount%coins[0]==0) {
    //             return amount/coins[0];
    //         }else{
    //             return (int) Math.pow(10, 9);
    //         }
    //     }
    //     if (dp[index][amount]!=-1) {
    //         return dp[index][amount];
    //     }
    //     int not_take=helper(index-1, coins, amount,dp);
    //     int take=(int) Math.pow(10, 9);
    //     if (coins[index]<=amount) {
    //         take=1+helper(index, coins, amount-coins[index],dp);
    //     }
    //     return dp[index][amount]=Math.min(not_take, take);
    // }
}
