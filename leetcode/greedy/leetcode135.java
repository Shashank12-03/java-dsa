package greedy;

import java.util.Arrays;

public class leetcode135 {
    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 5, 2};
        System.out.println(new leetcode135().candy(ratings));
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        for(int i = 1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        int sum = candies[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum += candies[i];
        }
        return sum;
        // 1 3 4 5 2
        // 1 1 1 1 1
        // 1 2 3 4 1 
        // 1 2 3 5 1
    }
}
