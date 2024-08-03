package slidingwindow;

public class leetcode2134 {
    public static void main(String[] args) {
        leetcode2134 sol = new leetcode2134();
        System.out.println(sol.minSwaps(new int[]{0,1,0,1,1,0,0}));
    }
    public int minSwaps(int[] nums) {
        int minSwap=Integer.MAX_VALUE;
        int zero = 0;
        int totalOne = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==1){
                totalOne++;
            }
        }
        int[] newArr = new int[nums.length*2];
        for(int i =0;i<newArr.length;i++){
            newArr[i] = nums[i%nums.length];
        }
        for(int i =0;i<totalOne;i++){
            if(newArr[i]==0){
                zero++;
            }
        }
        minSwap = Math.min(minSwap,zero);
        for(int i =totalOne;i<newArr.length;i++){
            if(newArr[i-totalOne]==0){
                zero--;
            }
            if (newArr[i]==0){
                zero++;
            }
            minSwap = Math.min(minSwap,zero);
        }
        return minSwap;
    }
}
