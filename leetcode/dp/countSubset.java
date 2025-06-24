package dp;

public class countSubset {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 16, 8, 10};
        int K = 10;
        countSubset cs = new countSubset();
        System.out.println(cs.perfectSum(arr, K));
    }
    public int perfectSum(int[] arr, int K) {
        // int count = 0;
        // for(int i = 0;i<arr.length;i++){
        //     if(){
        //         count++;
        //     } 
        // }
        return helper(0,arr,K);
    }
    private int helper(int ind, int[] arr, int K){
        if(K==0){
            return 1;
        }
        if(ind==arr.length-1){
            if(K==arr[ind]) return 1;
            return 0; 
        }

        int notPick = helper(ind+1,arr,K);
        int pick = 0;
        if (K-arr[ind]>=0){
            pick = helper(ind+1,arr,K-arr[ind]);
        }
        return pick + notPick;
    }
}
