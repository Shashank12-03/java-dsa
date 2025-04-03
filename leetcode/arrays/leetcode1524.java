package arrays;

public class leetcode1524 {
    public static void main(String[] args) {
        
    }
    private static final int MOD = 1000000007;
    
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        int odd = 0;
        int even = 0;
        int count = 0;
        if (prefixSum[0] % 2 == 0) {
            even++;
        } else {
            count++;
            odd++;
        }
        for(int i = 1;i<n;i++){
            prefixSum[i] =  prefixSum[i-1] + arr[i];
            if(prefixSum[i]%2==0){
                count = (count + odd) % MOD;
                even++;
            }
            else{
                count = (count + even + 1) % MOD;
                odd++;
            }
        }
        return count;
    }
}
