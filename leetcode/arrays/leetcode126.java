package arrays;

public class leetcode126 {
    public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{4,1,2,1,2}));
	}
	public static int singleNumber(int[] nums) {
        int unique=0;
        for(int n:nums){
            unique^=n;
        }
        return unique;
    }
}
