import java.util.*;

public class quicksort {
    //  public static void main(String[] args) {
    //     Scanner t=new Scanner(System.in);
    //     int n=t.nextInt();
    //     int[] arr=new int[n];//{4,5,3,1,2};
    //     for(int i=0;i<n;i++)
    //     {
    //         arr[i]=t.nextInt();
    //     }
    //     sort(arr, 0, arr.length-1);
    //     System.out.println(Arrays.toString(arr));
    //     t.close();
    // }
    // static void sort(int[] nums,int low,int high){
    //     if(low>=high){
    //         return;
    //     }
    //     int s=low;
    //     int e=high;
    //     int m=s+(e-s)/2;
    //     while(s<=e){
    //         while(nums[s]<nums[m]){
    //             s++;
    //         }
    //         while(nums[s]>nums[m]){
    //             e--;
    //         }
            
    //         if(s<=e){
    //             int temp=nums[s];
    //             nums[s]=nums[e];
    //             nums[e]=temp; 
    //             s++;
    //             e--;
    //         }
    //     }
    //     sort(nums,low, e);
    //     sort(nums,s, high);
    // }
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //Arrays.sort(arr);
    }

    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }
}
