package greedy;

public class leetcode55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
    public static boolean canJump(int[] nums) {
        if (nums.length==0 && nums.length>1 ) {
            return false;
        }
        int max_jump=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i>max_jump){
                return false;
            }
            else if(max_jump<nums[i]+i){
                max_jump=nums[i]+i;
            }
        }
        return max_jump>=nums.length-1;
    }
}
