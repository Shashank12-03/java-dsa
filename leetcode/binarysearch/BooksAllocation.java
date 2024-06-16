package binarysearch;
public class BooksAllocation {
    public static void main(String[] args) {
        System.out.println(books(new int[]{12,34,67, 90}, 2));
    }
    public static int books(int[] nums, int students) {
        if(nums.length<students){
            return -1;
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        if(students==nums.length){
            return max;
        }
        int ans=Integer.MAX_VALUE;
        int low=0;
        int high=sum;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(check( nums, mid, students)){
                ans=Math.min(ans, mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static boolean check(int[] nums, int mid,int students) {
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>mid){
                return false;
            }
            if(nums[i]+sum>mid){
                sum=nums[i];
                count++;
                if(count>students){
                    return false;
                }
            }
            else{
                sum+=nums[i];
            }
        }
        return true;
    }
}
