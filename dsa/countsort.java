import java.util.Arrays;

public class countsort {
    public static void main(String[] args) {
        int[] nums=new int[]{3,4,1,3,2,5,2,8};
        CountSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void CountSort(int[] nums){
        if(nums==null || nums.length<=1){
            return;
        }
        int max=Arrays.stream(nums).max().getAsInt();
        int[] freq=new int[max+1];
        for(int num:nums){
            freq[num]++;
        }
        int index=0;
        for(int i=0;i<max;i++){
            while (freq[i]>0) {
                nums[index++]=i;
                freq[i]--;
            }
        }
    }
}
