package sorting;
import java.util.Arrays;

public class leetcode75 {
    public static void main(String[] args) {
        int[] arr={2,0,1};
        sortColors(arr);
    }
    static void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            if(nums[i]==1){
                one++;
            }
            if(nums[i]==2){
                two++;
            }
        }
        for(int i=0;i<zero;i++){
            nums[i]=0;
        }
        for(int i=zero;i<zero+one;i++){
            nums[i]=1;
        }
        for(int i=zero+one;i<zero+one+two;i++){
            nums[i]=2;
        }
        System.out.println(Arrays.toString(nums));
    }
}
