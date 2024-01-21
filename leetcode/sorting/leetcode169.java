package sorting;
import java.util.Arrays;

public class leetcode169 {
    public static void main(String[] args) {
    System.out.println("Hello World");
    int[] arr={2,2,1,1,1,2,2};
    System.out.println(majorityElement(arr));
    }
	static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }
}
