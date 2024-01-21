package sorting;
import java.util.Arrays;

public class leetcode462 {
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,2,3}));
    }
    static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int mid=(nums.length-1)/2;
        for(int i=0;i<nums.length;i++){
            count+=Math.abs(nums[mid]-nums[i]);
        }
        return count;
    }
}
