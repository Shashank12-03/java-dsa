/*check whether the single element is at start or end as next condition will give index out of bound exception
 if middle element is even check for its succeeding element if its equal then the single element will be on the right side of the middle or else on the left side
if middle element is odd check for its preceding element if its equal then the single element will be on the left side of the middle or else on the right side */
package binarysearch;
import java.util.*;
public class leetcode540 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int ans=singleNonDuplicate(arr);
        System.out.println(ans);
        t.close();
    }
    static int singleNonDuplicate(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while (s<=e) {
            int mid=s+(e-s)/2;
            if(mid==0 || mid==nums.length-1){
                return nums[mid];
            }
            if((nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])){
                    return nums[mid];
            }
            if(mid%2==0)
            {
                if(nums[mid+1]==nums[mid]){
                    s=mid+1;
                }  
                else{
                    e=mid;
                } 
            }
            else{
                if(nums[mid-1]==nums[mid]){
                    s=mid+1;
                }  
                else{
                    e=mid;
                }
            }    
        }
        return -1;
    }
}
