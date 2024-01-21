package sorting;
import java.util.ArrayList;
import java.util.List;

public class leetcode442 {
    public static void main(String[] args) {
        int[] arr={1,1,2};
        System.out.println(findDuplicates(arr));
    }
    static List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> list=new ArrayList<Integer>(arr.length);
        // Arrays.sort(nums);
        int i=0;
        while(i<arr.length)
        {
            int correct=arr[i]-1;
            if(arr[correct]!=arr[i])
            {
                swap(arr,i,correct);
            }
            else
            {
                i++;
            }
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1 ){
                list.add(arr[i]);
            }
        }
        return list;
    }
    static void swap(int[] nums, int r,int c){
        int temp=nums[r];
        nums[r]=nums[c];
        nums[c]=temp;
    }
}
