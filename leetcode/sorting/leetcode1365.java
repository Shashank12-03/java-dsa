package sorting;
import java.util.*;
public class leetcode1365 {
    public static void main(String[] args) {
        // Scanner t=new Scanner(System.in);
        // // int n=t.nextInt();
        // int[] arr=new int[];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i]=t.nextInt();
        // }
        // smallerNumbersThanCurrent(arr);
        // //t.close();
        int[] arr={8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
    static int[] smallerNumbersThanCurrent(int[] nums) {
        //int[] ans=new int[nums.length];
        // int k=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     int count=0;
        //     for(int j=0;j<nums.length;j++)
        //     {
        //         if (i!=j && nums[i]>nums[j])
        //         {
        //             count++;
        //         }
        //     }
        //     ans[k++]=count;
        // }
        // Arrays.sort(nums);
        // int count=0;
        // //int k=0;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]!=nums[i-1]){
        //         count++;
        //     }
        //     ans[i]=count;
        // }
        // return ans;
        // for(int i=0;i<ans.length;i++)
        // {
        //     System.out.println(ans[i]);
        // }
        int[] bucket=new int[102];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]+1]++;
        }
        for(int i=1;i<102;i++){
            bucket[i]+=bucket[i-1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=bucket[nums[i]];
        }
        return nums;
    }
}
