package binarysearch;

public class leetcode1760 {

    public static void main(String[] args) {
        leetcode1760 sol = new leetcode1760();
        System.out.println(sol.minimumSize(new int[]{2,4,8,2}, 4));
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int left = 1;
        int right = max;
        int ans = 0;
        while(left<right){
            int mid = left + (right-left)/2;
            if(check(mid,nums,maxOperations)){
                ans = mid;
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int maxballs,int[] nums, int maxOperations){
        int opers = 0;
        for(int num:nums){
            opers+= Math.ceil(num/maxballs)-1;
            if (opers>maxOperations){
                return false;
            }
        }
        return true;
    }
}
