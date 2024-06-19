package binarysearch;

public class leetcode1482 {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length){
            return -1;
        } 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int start = min;
        int end = max;
        int ans = 1;
        while (start<=end) {
            int mid = start + (end-start)/2;
            if(canFormBouquet(bloomDay,m,k,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    private static boolean canFormBouquet(int[] bloomDay, int m, int k, int mid) {
        int bouquet = 0;
        int noOBO = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i]<=mid) {
                bouquet++;
            }
            else{
                noOBO += bouquet/k;
                bouquet = 0;
            }
        }
        noOBO += bouquet/k;
        return noOBO>=m;
    }
}
