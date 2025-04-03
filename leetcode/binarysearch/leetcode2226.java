package binarysearch;

public class leetcode2226 {
    public static void main(String[] args) {
        int[] candies = {4, 7, 5};
        long k = 4;
        leetcode2226 solution = new leetcode2226();
        int result = solution.maximumCandies(candies, k);
        System.out.println("Maximum candies each child can get: " + result);
    }
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        long sum = 0;
        int high = 0;
        for(int candy : candies){
            sum+=candy;
            high = Math.max(high,candy);
        }
        if(sum<k){
            return 0;
        }
        int res = 0;
        while(low<=high){
            int mid = high - (high-low)/2;
            if(isGettingEveryone(candies,mid,k)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;
    }
    private boolean isGettingEveryone (int[] candies, int maxCandy, long k){
        long candyAlloted = 0;
        for(int candy : candies){
            if(maxCandy<=candy){
                candyAlloted += (int) candy/maxCandy;
            }
            if(candyAlloted>=k){
                break;
            }
        }
        return candyAlloted>=k;
    }
}
