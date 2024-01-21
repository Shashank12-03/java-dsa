// package binarysearch;
public class leetccode209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
    static int minSubArrayLen(int target, int[] nums) {
        int max=0;
        int sum=0;
        int min=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i], max);
            sum+=nums[i];
            min=Math.min(nums[i], min);
        }
        if((target>sum) || (target<min)){
            return 0;
        }
        if(target==sum){
            return nums.length;
        }
        if(target==max){
            return 1;
        }
        int count=0;
        int start=max;
        int end=sum;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(sumadd(nums,mid,target)){
                count++;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return count;

    }
    static boolean sumadd(int[] arr,int mid,int target){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]>mid){
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return sum>=target;
    }
    // static int[] reverse(int[] arr){
    //     int start=0;
    //     int end=arr.length-1;
    //     while(start<=end){
    //         int temp=arr[start];
    //         arr[start]=arr[end];
    //         arr[end]=temp;
    //         start++;
    //         end--;
    //     }
    //     return arr;
    // } 
}
