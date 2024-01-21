    public class Main{
        // public static void main(String[] args) {
        // Scanner t=new Scanner(System.in);
        // int n=t.nextInt();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i]=t.nextInt();
        // }
        // int target=t.nextInt();
        // System.out.println(search(arr,target,pivot(arr)));
        // t.close();
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    static double myPow(double x, int n) {
        if(n==1){
            return x;
        }
        return x *(myPow(x,n-1));
    }
}
    // static boolean search(int[] nums, int target,int pivot) {
        
    //     if(pivot==-1)
    //     {
    //         return bs(nums,target,0,nums.length-1);
    //     }
    //     if(target==nums[pivot])
    //     {
    //         return true;
    //     }
    //     if (target>=nums[0])
    //     {
    //         return bs(nums, target, 0, pivot-1);
    //     }
    //     return bs(nums, target, pivot+1, nums.length-1);
    // }
    // static int pivot(int[] nums)
    // {
    //     int l=0;
    //     int e=nums.length-1;
    //     while(l<=e)
    //     {
    //         int mid=l+(e-l)/2; 
    //         if(mid<e && nums[mid+1]<nums[mid])
    //         {
    //             return mid;
    //         }
    //         if(mid>l && nums[mid]<nums[mid-1])
    //         {
    //             return mid-1;
    //         }
    //         if(nums[mid]<=nums[l])
    //         {
    //             e=mid-1;
    //         }
    //         else
    //         {
    //             l=mid+1;
    //         }
    //     }
    //     return -1;
    // }
    // static boolean bs(int[] arr,int target,int l, int e)
    // {
    
    //     while(l<=e)
    //     {
    //         int mid=l+(e-l)/2;
    //         if(arr[mid]==target)
    //         {
    //             return true;
    //         }
            
    //         if(target<arr[mid])
    //         {
    //             e=mid-1;
    //         }
    //         else if(target>arr[mid])
    //         {
    //             l=mid+1;
    //         }      
    //     }
    //     return false;
    // }  
